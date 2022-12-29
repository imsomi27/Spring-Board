package com.studysetting.domain.board.entity;

import com.querydsl.core.types.Projections;
import com.studysetting.domain.board.entity.dto.BoardResDto;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Repository;

import com.querydsl.jpa.impl.JPAQueryFactory;

import lombok.RequiredArgsConstructor;

import java.awt.print.Pageable;
import java.util.List;
import static com.studysetting.domain.board.entity.QBoard.board;
import static com.studysetting.domain.User.entity.QMember.member;
import static com.studysetting.domain.board.entity.QComment.comment1;

@Repository
@RequiredArgsConstructor
public class BoardQueryRepository {
	private final JPAQueryFactory jpaQueryFactory;
	public List<BoardResDto> getBoardList() {
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
				.orderBy(board.createDttm.desc())
				.fetch();
		return content;
	}
	public List<Comment> getComments(Long boardId) {
		return jpaQueryFactory.selectFrom(comment1)
				.where((comment1.board.boardId.eq(boardId)))
				.fetch();
	}
	/*member의 DBid가 board에서 생성한 user가 작성한 id가 맞는지 eq로 확인하고 BoardResDto를 List로 반환한다.*/
}