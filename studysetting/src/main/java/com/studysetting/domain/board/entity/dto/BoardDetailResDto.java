package com.studysetting.domain.board.entity.dto;

import com.studysetting.domain.board.entity.Comment;
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
    private String userName;
    private Long userId;
    private List<Comment> comments;


}
