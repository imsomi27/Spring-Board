package com.studysetting.domain.board.entity.dto;

import java.time.LocalDateTime;

import com.studysetting.domain.board.entity.Board;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@ToString
@NoArgsConstructor	//인자 없이 객체 생성 가능, 빈 생성자를 만듦
//@RequiredArgsConstructor	//class를 만들 때 필수적인 멤버변수(ex.final 변수)를 인자로 받는 생성자를 만듦.
public class BoardDto {
	
	private Long id; 
	private String title;
	private String content;
//	id는 auto-increment
	private LocalDateTime createdDate;
	private LocalDateTime modifiedDate;
	
	public Board toEntity() {
		return Board.builder()
				.title(title)
				.content(content)
				.build();
	}
}
