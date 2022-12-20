package com.studysetting.domain;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;

@Controller
public class WebController {
//	private final HttpSession httpSession = null;
	//(/ 와 /home 경로를 다루는 controller)
	@GetMapping("/")
	public String home(Model model, HttpSession session) {
		return "home";
	}

	@GetMapping("/signup")
	public String signup(){
		return "signup";
	}
	@GetMapping("/login")
	public String login() {
		return "login";
	}
}