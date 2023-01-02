package com.studysetting.domain.User;

import com.studysetting.domain.User.entity.dto.LoginReqDto;
import com.studysetting.domain.User.entity.dto.MemberSignUpDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
@RequestMapping("/user")
public class MemberController {
	private final MemberService memberService;
	//User와 관련된 경로(/login, /logout, /signup ... )을 다루는
	//I think It is UserSignUp

	@GetMapping(value = "/login")
	public ModelAndView getLogin() {
		LoginReqDto loginReqDto = new LoginReqDto();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("idPw", loginReqDto);
		modelAndView.setViewName("login");
		return modelAndView;
	}
	@GetMapping("/signup")
	public ModelAndView getSignup() {
		MemberSignUpDto memberSignUpDto = new MemberSignUpDto();
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("signupForm", memberSignUpDto);
		modelAndView.setViewName("signup");
		return modelAndView;
	}
	@PostMapping("/signup")
	public void signup(@ModelAttribute("signupForm") MemberSignUpDto memberSignUpDto, HttpServletResponse response) {
		memberService.userSignUp(memberSignUpDto, response);
	}


//	@PostMapping("/signup")
//	public String Signup(@ModelAttribute("memberSignUpDto") MemberSignUpDto memberSignUpDto, HttpServletRequest request) {
//		return memberService.userSignUp(memberSignUpDto);
//	}

	@PostMapping("/login")
	public void login(@ModelAttribute("idPw") LoginReqDto loginReqDto, HttpServletRequest request, HttpServletResponse response) {
		memberService.login(loginReqDto, request, response);
	}

	//로그아웃 안돼요~~~ [수정]
	@GetMapping ("/logout")
	public void logout(HttpServletRequest request, HttpServletResponse response) {
		memberService.logout(request, response);
	}


	//이메일 중복 검사
//	@GetMapping("/exists")
//	public ResponseEntity<Boolean> checkEmailDuplicate(@PathVariable String userEmail) {
//		return ResponseEntity.ok(memberService.checkEmailDuplicate(userEmail));
//	}
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
