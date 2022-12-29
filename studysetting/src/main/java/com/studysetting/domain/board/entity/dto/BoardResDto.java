package com.studysetting.domain.board.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

import java.time.LocalDateTime;

@Getter
@AllArgsConstructor
public class BoardResDto {
	//게시글 상세 조회 {Res:title, content
	private Long boardId;
	private String title;
	private String content;
	private LocalDateTime createDttm;
	private LocalDateTime updateDttm;
	private String writer;
}