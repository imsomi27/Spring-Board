package com.studysetting.domain.board.entity;

import javax.persistence.*;

import com.studysetting.common.BaseDateEntity;
import com.studysetting.domain.User.entity.Member;

import lombok.*;


@Entity
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter
@Table(name = "tb_board")
public class Board extends BaseDateEntity {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "board_id")
	private Long id;
	
	@Column(name = "title", nullable = false)
	private String title;
	
	@Column(name = "content", nullable = false)
	private String content;

	@Enumerated(EnumType.STRING)
	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "user_id", nullable = false)
	private Member user;
	
	public Board(String title, String content) {
		this.title = title;
		this.content = content;
	}
	public void setUser(Member user) {this.user = user;}
}