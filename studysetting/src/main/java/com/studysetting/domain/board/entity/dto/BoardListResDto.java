package com.studysetting.domain.board.entity.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class BoardListResDto {
	//게시글 전체 조회 {Res:title, content
	private String title;
	private String content;
}