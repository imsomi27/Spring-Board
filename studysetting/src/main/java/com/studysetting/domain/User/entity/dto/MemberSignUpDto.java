package com.studysetting.domain.User.entity.dto;

import com.studysetting.domain.User.entity.Role;
import com.studysetting.domain.User.entity.Member;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberSignUpDto{
	//유저 생성 요청
	private String uid; //로그인아이디 unique
	private String email;
	private String password;
	private String nickname;
//	private Role role;
	
	public Member toEntity() {
		return Member.builder()
				.uid(uid)
				.email(email)
				.password(password)
				.nickname(nickname)
//				.role(role)
				.build();
	}
}