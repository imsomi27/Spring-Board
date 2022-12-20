package com.studysetting.domain.User;

import java.util.HashMap;

import javax.transaction.Transactional;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.studysetting.domain.User.entity.MemberRepository;
import com.studysetting.domain.User.entity.dto.MemberSignUpDto;

import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberService {
	
	private final MemberRepository memberRepository;
	
	//email 중복 검사
	public HashMap<String, Object> emailOverlap(String email) {
        HashMap<String, Object> map = new HashMap<>();
        map.put("result", memberRepository.existsByemail(email));
        return map;
    }
	//닉네임 중복 검사
	 public HashMap<String, Object> nicknameOverlap(String nickname) {
	        HashMap<String, Object> map = new HashMap<>();
	        map.put("result", memberRepository.existsByNickname(nickname));
	        return map;
	    }
	//유저 가입 요청
	@Transactional
	public void userSignUp(MemberSignUpDto userSignUpDto) {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		userSignUpDto.setPassword(passwordEncoder.encode(userSignUpDto.getPassword()));
		memberRepository.save(userSignUpDto.toEntity());
	}

}