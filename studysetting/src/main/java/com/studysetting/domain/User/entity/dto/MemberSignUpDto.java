package com.studysetting.domain.User.entity.dto;

import com.studysetting.domain.User.entity.Member;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class MemberSignUpDto{
	//유저 생성 요청
//	private String uid; //로그인아이디 unique
	private String userEmail;
	private String password;
	/*@Builder
	public MemberSignUpDto(String userEmail, String password) {
		this.userEmail = userEmail;
		this.password = password;
	}*/
}