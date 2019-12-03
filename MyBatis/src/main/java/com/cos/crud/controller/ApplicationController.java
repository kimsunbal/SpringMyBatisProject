package com.cos.crud.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ApplicationController {

	@GetMapping("/")
	public String home() {
		return "home";
	}

	@GetMapping("/board/list")
	public String list() {
		return "/board/list";
	}

	@GetMapping("/user/loginForm")
	public String loginForm() {
		return "/user/loginForm";
	}
	
	//login 구현

	@GetMapping("/user/joinForm")
	public String joinForm() {
		return "/user/joinForm";
	}
	
	//join 구현

	@GetMapping("/user/logout")
	public String logout() {
		return "redirect:/";
	}
}
