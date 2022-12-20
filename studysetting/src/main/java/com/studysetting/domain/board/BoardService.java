package com.studysetting.domain.board;

import javax.transaction.Transactional;

import com.studysetting.domain.board.entity.Board;
import org.springframework.stereotype.Service;

import com.studysetting.domain.User.entity.MemberRepository;
import com.studysetting.domain.board.entity.BoardQueryRepository;
import com.studysetting.domain.board.entity.BoardRepository;
import com.studysetting.domain.board.entity.dto.BoardDto;

import lombok.RequiredArgsConstructor;

import java.util.List;

// Service는 비즈니스 로직을 담당하는 부분으로 DB로부터 데이터를 받거나 전달하는 역할을 함.
// 해당 class를 루트 컨테이너에 Bean 객체로 생성함.
@Service
@RequiredArgsConstructor
public class BoardService {
	private final BoardRepository boardRepository;
	private final MemberRepository userRepository;
	
	private final BoardQueryRepository boardQueryRepository;
	private static final int PAGE_POST_COUNT = 4; //한 페이지에 존재하는 게시글 수
	

	//게시글 등록
	@Transactional
	public Long createPost(BoardDto boardDto) {
		return boardRepository.save(boardDto.toEntity()).getId();
	}
	//게시글 삭제
	@Transactional
	public void deletePost(Long id) {
		boardRepository.deleteById(id);
	}
	//게시글 검색(전체)
	@Transactional
	public List<Board> getAllBoard() {
		return boardRepository.findAll();
	}
	//게시글 검색(상세)
//	@Transactional
//	public List<BoardDto> getPost(Long id) {
//		return boardQueryRepository.
//	}
}
