package com.studysetting.domain;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	private final HttpSession httpSession = null;
	@GetMapping({"/", "/home"})
	public String home() {
		return "home";
	}
}