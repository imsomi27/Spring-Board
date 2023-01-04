package com.studysetting.domain.board.entity;

import com.querydsl.core.types.Projections;
import com.studysetting.domain.board.entity.dto.BoardResDto;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import java.util.List;
import static com.studysetting.domain.board.entity.QBoard.board;
import static com.studysetting.domain.User.entity.QMember.member;
import static com.studysetting.domain.board.entity.QComment.comment1;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepository {
	private final JPAQueryFactory jpaQueryFactory;
	public Page<BoardResDto> getBoardList(Pageable pageable) {
		List<BoardResDto> content = jpaQueryFactory
				.select(Projections.constructor(BoardResDto.class,
					board.boardId,
					board.title,
					board.content,
					board.createDttm,
					board.updateDttm,
					member.userEmail.as("userName")
				))
				.from(board)
				.leftJoin(member)
				.on(board.user.memberId.eq(member.memberId))
				.offset(pageable.getOffset()) //페이지 번호(0부터 시작)
				.limit(pageable.getPageSize()) //페이지 사이즈(페이지 limit)
				.orderBy(board.createDttm.desc())
				.fetch();
		return new PageImpl<>(content, pageable, content.size());
	}
	public List<Comment> getComments(Long boardId) {
		return jpaQueryFactory.selectFrom(comment1)
				.where((comment1.board.boardId.eq(boardId)))
				.orderBy(comment1.createDttm.asc())
				.fetch();
	}
	/*member의 DBid가 board에서 생성한 user가 작성한 id가 맞는지 eq로 확인하고 BoardResDto를 List로 반환한다.*/
}