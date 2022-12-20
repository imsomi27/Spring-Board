package com.studysetting.domain.User.entity;

import com.studysetting.common.BaseDateEntity;

import java.util.List;

import javax.persistence.*;

import com.studysetting.domain.User.entity.dto.MemberSignUpDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor	//생성된 모든 멤버변수를 인자로 받음
@Table(name="tb_member")
public class Member extends BaseDateEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "member_id")
	private Long id;
	@Column(name = "user_email", nullable = false, unique = true, length = 35)
	private String userEmail;
	@Column(name = "password", nullable = false, length = 50)
	private String password;

	public boolean matchPassword(String password) {
		return this.password.equals(password);
	}

//	@OneToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER )
//	@JoinColumn(name="user_id")
//	private Role roles;
//	private List<Role> roles
	@Enumerated(EnumType.STRING)
	@Column(name = "user_role", nullable = false)
	private Role role;
	@Builder
	public Member(String userEmail, String password) {
		this.userEmail = userEmail;
		this.password = password;
	}
	public Member(MemberSignUpDto memberSignUpDto) {
		this.userEmail = memberSignUpDto.getUserEmail();
		this.password = memberSignUpDto.getPassword();
	}
//	public String getRoleKey() {
//		return this.role.getKey();
//	}
}
