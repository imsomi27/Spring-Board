package com.studysetting.domain.board.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

import com.studysetting.common.BaseDateEntity;
import com.studysetting.domain.User.entity.Member;

import lombok.*;
import org.hibernate.annotations.ColumnDefault;

import java.util.List;


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
	private Long boardId;

	@Column(name = "title", nullable = false)
	private String title;

	@Column(name = "content", nullable = false)
	private String content;

	@ManyToOne
	@JoinColumn(name = "member_id")
	private Member user;

	@OneToMany(mappedBy = "board", fetch = FetchType.EAGER, cascade = CascadeType.REMOVE)
	private List<Comment> comments;

//	public Board(String title, String content) {
//		this.title = title;
//		this.content = content;
//	}
	public void setUser(Member writer) {this.user = writer;}
}