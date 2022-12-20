package com.studysetting.domain.User;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.studysetting.domain.User.entity.dto.MemberSignUpDto;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class MemberController {
	
	private final MemberService memberService;
	
	@GetMapping("")
	//i think it is usersignup
	@PostMapping("/signup")
	public void addUser(@RequestBody MemberSignUpDto memberSignUpDto) {
		memberService.userSignUp(memberSignUpDto);
//		return "redirect:/user/login";
	}
	
	@GetMapping("/user/userup")
	public void signupForm(Model model) {
		model.addAttribute("memberSignUpDto", new MemberSignUpDto());
	}
	
//	@GetMapping("/user/signin")
//	public String SignUpForm(User user) {
//		user.addAttribute("user", new UserSignUpDto());
//		return "user/SignUpForm";
//	}
	//user 생성
//	@PostMapping("/adduser")
//	public String addUser() {
//		
//	}
	/*
	 * MVC pattern Model 객체 사용방법 아래는 예시
	 * 
	 * @RequestMapping("url...") public String patternTrend(Model model) | model :
	 * 데이터를 담는 key와 value로 구성된 map구조로 저장되는 어떤 객체 model.addAttribute("list",
	 * patternTrendService.getList()) | model.addAttribute("변수명", 값(함수)) return "" |
	 * view에서 보이고자 하는 위치(예를 들어 home이라던가, 포워딩되는 파일형식은 적지 않음, 렌더링될 화면을 의미)
	 */
}
