package com.studysetting.domain.board.entity.dto;

import javax.validation.constraints.NotNull;

import com.studysetting.domain.board.entity.Board;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BoardSaveReqDto {
	//게시글 생성 요청 {Req:boardId, title, content, createDate, updateDate, userId / Res:전체 보드리스트
	@NotNull
	private String title;
	@NotNull
	private String content;

}