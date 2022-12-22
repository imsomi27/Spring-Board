package com.studysetting.domain.board.entity.dto;

import javax.validation.constraints.NotNull;

import com.studysetting.domain.board.entity.Board;

import lombok.Getter;

@Getter
public class BoardSaveReqDto {
	//게시글 생성 요청 {Req:boardId, title, content, createDate, updateDate, userId / Res:전체 보드리스트
	@NotNull
	private String title;
	@NotNull
	private String content;
	public Board toEntity() {
		return Board.builder()
				.title(title)
				.content(content)
				.build();
	}
}