package com.studysetting.domain.User;

import com.studysetting.domain.User.entity.Member;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import com.studysetting.domain.User.entity.dto.MemberSignUpDto;

import lombok.RequiredArgsConstructor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class MemberController {
	private final MemberService memberService;
	//User와 관련된 경로(/login, /logout, /signup ... )을 다루는
	//I think It is UserSignUp
	@PostMapping("/signup")
	public String signup(MemberSignUpDto memberSignUpDto) {
		memberService.userSignUp(memberSignUpDto);
		return "redirect:/login";
	}
//	@PostMapping("/signup")
//	public String Signup(@ModelAttribute("memberSignUpDto") MemberSignUpDto memberSignUpDto, HttpServletRequest request) {
//		return memberService.userSignUp(memberSignUpDto);
//	}
	@PostMapping("/logout")
	public String logOut(HttpServletRequest request) throws Exception {
		HttpSession session = request.getSession(false);
		if(session !=null) {
			session.invalidate();
		}
		return "redirect:/home";
	}
//	@PostMapping("/login")
//	public String signupForm(Member member, )
//	}
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
