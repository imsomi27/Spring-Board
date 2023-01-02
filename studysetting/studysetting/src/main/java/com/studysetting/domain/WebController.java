package com.studysetting.domain;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class WebController {
//	private final HttpSession httpSession = null;
	//(/ 와 /home 경로를 다루는 controller)
	@GetMapping({"/", "/home"})
	public String home() {
		return "home";
	}


//	@GetMapping("/signup")
//	public String signup(){
//		return "signup";
//	}
//	@GetMapping("/login")
//	public String login() {
//		return "/user/login";
//	}
}