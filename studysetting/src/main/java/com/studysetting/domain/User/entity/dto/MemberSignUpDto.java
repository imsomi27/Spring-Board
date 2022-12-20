package com.studysetting.domain.User.entity.dto;

import com.studysetting.domain.User.entity.Role;
import com.studysetting.domain.User.entity.Member;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;

@Data
@NoArgsConstructor
public class MemberSignUpDto{
	//유저 생성 요청
//	private String uid; //로그인아이디 unique
	private String userEmail;
	private String password;

//	private Role role;
	public Member toEntity() {
		return Member.builder()
				.userEmail(userEmail)
				.password(password)
//				.role(role)
				.build();
	}
}