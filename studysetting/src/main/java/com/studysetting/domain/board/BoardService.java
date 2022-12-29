package com.studysetting.domain.board;

import com.studysetting.domain.User.entity.Member;
import com.studysetting.domain.User.entity.MemberRepository;
import com.studysetting.domain.board.entity.*;
import com.studysetting.domain.board.entity.dto.BoardResDto;
import com.studysetting.domain.board.entity.dto.BoardSaveReqDto;
import com.studysetting.domain.board.entity.dto.CommentSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

// Service는 비즈니스 로직을 담당하는 부분으로 DB로부터 데이터를 받거나 전달하는 역할을 함.
// 해당 class를 루트 컨테이너에 Bean 객체로 생성함.
@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	private final MemberRepository memberRepository;
	private final BoardQueryRepository boardQueryRepository;
	private final CommentRepository commentRepository;

	//1. 게시글 등록
	@Transactional
	public void createPost(BoardSaveReqDto boardSaveReqDto, HttpServletRequest request, HttpServletResponse response) {
		try {
			Member member = memberRepository.findById(Long.valueOf(String.valueOf(request.getSession().getAttribute("userId")))).orElseThrow();
			Board board = Board.builder()
					.title(boardSaveReqDto.getTitle())
					.content(boardSaveReqDto.getContent())
					.user(member)
					.build();
			boardRepository.save(board);
			response.sendRedirect(("/home"));
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//2. 전체 게시판 조회 - board를 작성한 userEmail도 보여주기 위해 custom 할 필요가 있음.
	@Transactional(readOnly = true)
	public List<BoardResDto> BoardList() {return boardQueryRepository.getBoardList();}

	//3. 코멘트 상세 게시글 조회
/*	@Transactional(readOnly = true)
	public BoardDetailResDto getPost(Long boardId) {
		Board board = boardRepository.findByBoardId(boardId).orElseThrow();
		List<Comment> comments = boardQueryRepository.getComments(boardId);
		return BoardDetailResDto.builder()

	}*/
	//3-1. 나중에 작성자email을 조회하면 그것들만 보이는 getMapping도 추가하고 싶음.


	//4. 게시글 수정-작성자만 수정할 수 있음
	//5. 게시글 삭제-게시글을 삭제하면 댓글도 삭제되고 작성자만 삭제할 수 있고 관리자는 삭제 가능.
	@Transactional
	public void deletePost(Long id) {
		boardRepository.deleteById(id);
	}
	//6. 댓글 삽입
	@Transactional
	public void createComment(Long boardId, CommentSaveReqDto commentSaveReqDto, HttpServletRequest request, HttpServletResponse response) {
		try {
			Member member = memberRepository.findById(Long.valueOf(String.valueOf(request.getSession().getAttribute("userId")))).orElseThrow();
			Board board = boardRepository.findByBoardId(boardId).orElseThrow();
			Comment comment = Comment.builder()
					.comment(commentSaveReqDto.getComment())
					.board(board)
					.build();
			comment.setUser(member);
			commentRepository.save(comment);
			response.sendRedirect("");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

}
