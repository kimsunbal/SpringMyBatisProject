package com.cos.crud.controller;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.cos.crud.model.User;
import com.cos.crud.service.UserService;
import com.cos.crud.utils.Script;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserService uService;

	@Value("${file.path}")
	private String resourcePath;

	@GetMapping("/joinForm")
	public String joinForm() {
		return "/user/joinForm";
	}

	@PostMapping("/join")
	public @ResponseBody String join(User user, @RequestParam("photo") MultipartFile file) {
		int result = uService.join(user, file);
		if (result == 1) {
			return Script.href("/user/loginForm");
		}
		return Script.back("Fail Join");
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "/user/loginForm";
	}

	@PostMapping("/login")
	public @ResponseBody String login(User user, HttpSession session) {
		User u = uService.login(user);
		if (u != null) {
			session.setAttribute("user", u);
			return Script.href("/");
		} else {
			return Script.back("Fail Login");
		}
	}

	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		User user = uService.updateForm(id);
		if (user != null) {
			model.addAttribute("user", user);
			return "/user/updateForm";
		}
		return "redirect:/";
	}

	@PostMapping("/update")
	public @ResponseBody String update(User user, @RequestParam("photo") MultipartFile file, HttpSession session) {
		int result = uService.update(user, file);
		if (result == 1) {
			session.setAttribute("user", user);
			return Script.href("/");
		}
		return Script.back("Fail Update");

	}

	@GetMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable int id, HttpSession session) {
		int result = uService.delete(id);
		if (result == 1) {
			session.invalidate();
			return Script.href("/");
		}
		return Script.back("Fail Logout");
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
