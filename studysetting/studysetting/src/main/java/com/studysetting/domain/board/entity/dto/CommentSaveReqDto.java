package com.studysetting.domain.board.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.NotNull;

@Data
@NoArgsConstructor
public class CommentSaveReqDto {
    @NotNull
    private String content;
}
