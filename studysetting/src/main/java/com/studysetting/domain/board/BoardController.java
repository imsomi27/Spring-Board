package com.studysetting.domain.board;

import com.studysetting.domain.board.entity.dto.BoardSaveReqDto;
import com.studysetting.domain.board.entity.dto.CommentSaveReqDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

//Controller 는 View 에서 오는 API요청을 어떻게 처리할 것인지 정의함.
@RestController
@RequiredArgsConstructor
@RequestMapping("/board") 	//board 경로로 들어오는 요청은 아래 Method로 처리
public class BoardController {
	private final BoardService boardService;

	//게시글 등록 - 나중에 게시글 list 경로로 list메서드와 매핑
	@PostMapping("/upload")
	public void Post(@Valid @ModelAttribute("boardSaveForm") BoardSaveReqDto boardSaveReqDto, HttpServletRequest request, HttpServletResponse response) {
		boardService.createPost(boardSaveReqDto, request, response);
	}
	@GetMapping("/upload")
	public ModelAndView getPost() {
		BoardSaveReqDto boardSaveReqDto = new BoardSaveReqDto();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("boardSaveForm", boardSaveReqDto);
		modelAndView.setViewName("PostBoard");
		return modelAndView;
	}

	//전체 게시글 조회 [작성자Email, 제목, 컨텐츠, 작성날짜, 수정날짜]
	@GetMapping("/list")
	public ModelAndView getBoardlist() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("board", boardService.BoardList());
		modelAndView.setViewName("BoardList");
		return modelAndView;
	}
	//일부 게시글 삭제
	@DeleteMapping("/post/{boardId}")
	public String delete(@PathVariable Long boardId) {
		boardService.deletePost(boardId);
		return "redirect:/board/list";
	}
	//댓글 등록
	@PostMapping("/{boardId}/comment")
	//6. 댓글 삽입, 연쇄 삭제
	public void postComment(@PathVariable Long boardId, @Valid @ModelAttribute CommentSaveReqDto commentSaveReqDto, HttpServletRequest request, HttpServletResponse response) {
		boardService.createComment(boardId, commentSaveReqDto, request, response);
	}

}