package com.studysetting.domain.board.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class BoardSaveReqDto {
	//게시글 생성 요청 {Req:boardId, title, content, createDate, updateDate, userId / Res:전체 보드리스트
	@NotNull
	private String title;
	@NotNull
	private String content;

}