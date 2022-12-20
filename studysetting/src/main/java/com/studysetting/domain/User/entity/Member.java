package com.studysetting.domain.User.entity;

import com.studysetting.common.BaseDateEntity;

import java.util.List;

import javax.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Builder
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor	//생성된 모든 멤버변수를 인자로 받음
@ToString
@Table(name="tb_member")
public class Member extends BaseDateEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	
	@Column(name= "user_id", nullable = false, unique = true, length = 50)
	private String uid;	//아무래도 일반적인 로그인
	
	@Column(name = "password", nullable = false)
	private String password;

	@Column(name = "user_email", nullable = false, unique = true)
	private String email; 
	
	
	@Column(name = "nickname", unique = true)
	private String nickname;
	
//롤은 나중에 할게요
//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
//	@JoinColumn(name="user_id")
//	private Role roles;
//	private List<Role> roles
//	@Enumerated(EnumType.STRING)
//	@Column(nullable = false)
//	private Role role;
	
	public Member(String email, String password, String nickname) {
		this.email = email;
		this.password = password;
		this.nickname = nickname;

	}
//	public String getRoleKey() {
//		return this.role.getKey();
//	}
}
