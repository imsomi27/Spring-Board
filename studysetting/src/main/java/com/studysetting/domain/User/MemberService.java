package com.studysetting.domain.User;

import java.util.HashMap;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;

import com.studysetting.domain.User.entity.Member;
import lombok.extern.slf4j.Slf4j;
import org.apache.catalina.User;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.studysetting.domain.User.entity.MemberRepository;
import com.studysetting.domain.User.entity.dto.MemberSignUpDto;

import lombok.RequiredArgsConstructor;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;
	//email 중복 검사
//	public boolean checkEmailDuplicate(String userEmail) {
//		return MemberRepository.existsByuserEmail(userEmail);
//	}
//	public HashMap<String, Object> emailOverlap(String email) {
//        HashMap<String, Object> map = new HashMap<>();
//        map.put("result", memberRepository.existsByuserEmail(email));
//        return map;
//    }
/*	//닉네임 중복 검사
	 public HashMap<String, Object> nicknameOverlap(String nickname) {
	        HashMap<String, Object> map = new HashMap<>();
	        map.put("result", memberRepository.existsByNickname(nickname));
	        return map;
	    }*/

	//유저 가입 요청 비밀번호 암호화
	@Transactional
	public void userSignUp(MemberSignUpDto userSignUpDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userSignUpDto.setPassword(passwordEncoder.encode(userSignUpDto.getPassword()));
		memberRepository.save(userSignUpDto.toEntity());
	}/*	회원 정보 저장
	@Param으로 정보를 저장하는 DTO가 들어가면서 입력받은 패스워드를 BCrypt로 암호화한 후 회원을 저장함*/
//	public void signupdb(MemberSignUpDto memberSignUpDto) {
//		userMapper.insertUser(memberSignUpDto);
//	}

//	//로그인
//	public Long login(String email, String password) {
//		Member member = userMapper.
//	}

}