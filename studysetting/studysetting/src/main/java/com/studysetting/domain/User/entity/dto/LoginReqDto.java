package com.studysetting.domain.User.entity.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class LoginReqDto {
    private String userEmail;
    private String password;
}
