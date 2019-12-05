package com.cos.crud.controller;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.UUID;

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
import com.cos.crud.repository.UserRepository;
import com.cos.crud.utils.Script;

@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	private UserRepository userRepo;

	@Value("${file.path}")
	private String resourcePath;

	@GetMapping("/{id}")
	public @ResponseBody User getUser(@PathVariable int id) {
		User user = userRepo.findById(id);
		return user;
	}

	@GetMapping("/findAll")
	public @ResponseBody List<User> findAll() {
		List<User> users = userRepo.findAll();
		return users;
	}

	@GetMapping("/joinForm")
	public String joinForm() {
		return "/user/joinForm";
	}

	@PostMapping("/join")
	public String join(User user, @RequestParam("photo") MultipartFile file) {
		String fname = file.getOriginalFilename();
		try {
			if (fname.equals("")) {
				user.setUserProfile("/userProfile/default.jpg");
			} else {
				UUID uuid = UUID.randomUUID();
				String uuidFileName = uuid + "_" + file.getOriginalFilename();
				Path filePath = Paths.get(resourcePath + uuidFileName);
				System.out.println("filePath:" + filePath);
				Files.write(filePath, file.getBytes());
				user.setUserProfile("/userProfile/" + uuidFileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userRepo.join(user);
		return "/user/loginForm";
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "/user/loginForm";
	}

	@PostMapping("/login")
	public @ResponseBody String login(User user, HttpSession session) {
		User u = userRepo.login(user.getUsername(), user.getPassword());
		if (u != null) {
			session.setAttribute("user", u);
			return Script.href("/");
		} else {
			return Script.back("Fail Login");
		}
	}

	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		User user = userRepo.findById(id);
		model.addAttribute("user", user);
		return "/user/updateForm";
	}

	@PostMapping("/update")
	public String update(User user, @RequestParam("photo") MultipartFile file, HttpSession session) {
		String fname = file.getOriginalFilename();
		try {
			if (fname.equals("")) {
				user.setUserProfile(user.getUserProfile());
			} else {
				UUID uuid = UUID.randomUUID();
				String uuidFileName = uuid + "_" + file.getOriginalFilename();
				Path filePath = Paths.get(resourcePath + uuidFileName);
				System.out.println("filePath:" + filePath);
				Files.write(filePath, file.getBytes());
				user.setUserProfile("/userProfile/" + uuidFileName);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		userRepo.update(user);
		session.setAttribute("user", user);
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id, HttpSession session) {
		userRepo.delete(id);
		session.invalidate();
		return "redirect:/";
	}

	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
}
