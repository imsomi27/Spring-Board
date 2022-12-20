package com.studysetting.domain.board;

import com.studysetting.domain.board.entity.Board;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.studysetting.domain.board.entity.dto.BoardDto;

import lombok.RequiredArgsConstructor;

import java.util.List;

//Controller 는 View 에서 오는 API요청을 어떻게 처리할 것인지 정의함.
@RestController
@RequiredArgsConstructor
@RequestMapping("board") 	//board 경로로 들어오는 요청은 아래 Method로 처리
public class BoardController {
	private BoardService boardService;
	
	//게시글 등록 - 나중에 게시글 list 경로로 list메서드와 매핑 
	@PostMapping("/post")
	public String create(BoardDto boardDto) {
		boardService.createPost(boardDto);
		return "redirect:/board/list";
	}
	//게시글 삭제
	@DeleteMapping("/post/{id}")
	public String delete(@PathVariable("no") Long no) {
		boardService.deletePost(no);
		return "redirect:/board/list";
	}
	//게시글 목록
	@GetMapping("/list")
	public String BoardList(Model model) {
		List<Board> boardList = boardService.getAllBoard();
		model.addAttribute("boardList", boardList);
		return "board/list";
	}
}