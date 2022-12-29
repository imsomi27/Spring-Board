package com.studysetting.domain.board.entity;

import com.studysetting.common.BaseDateEntity;
import com.studysetting.domain.User.entity.Member;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.validation.constraints.Size;

@Entity
@NoArgsConstructor
@AllArgsConstructor    //생성된 모든 멤버변수를 인자로 받음
@Builder
@Getter
@Table(name = "tb_comment")
public class Comment extends BaseDateEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "comment_id")
    private Long commentId;

    @Size(min = 1)
    @Column(name = "comment")
    private String comment;

    @ManyToOne
    @JoinColumn(name = "board_id")
    private Board board;

    @ManyToOne
    @JoinColumn(name = "member_id")
    private Member user;

    public void setUser(Member user) {
        this.user = user;
    }
}
