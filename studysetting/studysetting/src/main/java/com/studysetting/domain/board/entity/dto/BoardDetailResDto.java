package com.studysetting.domain.board.entity.dto;

import com.studysetting.domain.board.entity.Comment;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;

@Data
@NoArgsConstructor
public class BoardDetailResDto {
    private Long boardId;
    private String title;
    private String content;
    private LocalDateTime createDttm;
    private LocalDateTime updateDttm;
    private Long userId;
    private String userName;
    private List<Comment> comments;

    /*dto to entity*/
    @Builder
    public BoardDetailResDto(Long boardId, String title, String content, LocalDateTime createDttm, LocalDateTime updateDttm, Long userId, String userName, List<Comment> comments){
        this.boardId = boardId;
        this.title = title;
        this.content = content;
        this.createDttm = createDttm;
        this.updateDttm = updateDttm;
        this.userId = userId;
        this.userName = userName;
        this.comments = comments;
    }
}
