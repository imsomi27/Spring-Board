package com.studysetting.domain.User;

import com.studysetting.domain.User.entity.Member;
import com.studysetting.domain.User.entity.MemberRepository;
import com.studysetting.domain.User.entity.dto.LoginReqDto;
import com.studysetting.domain.User.entity.dto.MemberSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class MemberService {
	private final MemberRepository memberRepository;

	private final PasswordEncoder passwordEncoder;
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
/*	@Transactional
	public void userSignUp(MemberSignUpDto userSignUpDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userSignUpDto.setPassword(passwordEncoder.encode(userSignUpDto.getPassword()));
		memberRepository.save(userSignUpDto.toEntity());
	}*//*	회원 정보 저장
	@Param으로 정보를 저장하는 DTO가 들어가면서 입력받은 패스워드를 BCrypt로 암호화한 후 회원을 저장함*/

	//유저 가입
	@Transactional
	public void userSignUp(MemberSignUpDto memberSignUpDto, HttpServletResponse response){
		try {
			if(memberRepository.findByUserEmail(memberSignUpDto.getUserEmail()).isPresent());
			Member member = Member.builder()
					.userEmail(memberSignUpDto.getUserEmail())
					.password(passwordEncoder.encode(memberSignUpDto.getPassword()))
					.build();
			memberRepository.save(member);
			response.sendRedirect("/home");
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	//로그인
	@Transactional
	public void login(LoginReqDto loginReqDto, HttpServletRequest request, HttpServletResponse response) {
		try {
			Member member = memberRepository.findByUserEmail(loginReqDto.getUserEmail()).orElseThrow();
//			if(loginReqDto.getPassword().equals(member.getPassword())) {
			if(!passwordEncoder.matches(loginReqDto.getPassword(), member.getPassword()));
			HttpSession session = request.getSession();
			session.setMaxInactiveInterval(1800);
			session.setAttribute("userId", member.getMemberId());
			session.setAttribute("userEmail", member.getUserEmail());
			session.setAttribute("isLogin", true);
			response.sendRedirect("/home");
//			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}

	@Transactional
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		try {
			HttpSession session = request.getSession(false);
			if(session !=null) {
				session.invalidate();
				response.sendRedirect("/home");
			}
		} catch (IOException e) {
			throw new RuntimeException(e);
		}
	}
}