package com.studysetting.domain.User.entity;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum Role {
	ROLE_ADMIN("ADMIN", "관리자"),
	ROLE_USER("USER","일반사용자");
	
	private final String key;
	private final String title;
//	private String value;
//	Role(String value) {
//		this.value = value;
//	} 
}
