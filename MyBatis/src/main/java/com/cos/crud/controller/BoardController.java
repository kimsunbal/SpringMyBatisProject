package com.cos.crud.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.cos.crud.model.Board;
import com.cos.crud.model.UserBoard;
import com.cos.crud.service.BoardService;
import com.cos.crud.utils.Script;

@Controller
@RequestMapping("/board")
public class BoardController {

	@Autowired
	private BoardService bService;

	@GetMapping("/list")
	public String list() {
		return "redirect:/board/list/1";
	}

	@GetMapping("/list/{page}")
	public String findByPage(@PathVariable int page, Model model) {
		List<UserBoard> userBoards = bService.findByPage(page);
		int countPage = bService.selectCount();
		List<UserBoard> popularBoards = bService.findOrderByReadCountDesc();
		if (userBoards != null && countPage != -1 && popularBoards != null) {
			model.addAttribute("page", page);
			model.addAttribute("countPage", countPage);
			model.addAttribute("userBoards", userBoards);
			model.addAttribute("popularBoards", popularBoards);
			return "/board/list";
		} else {
			return "redirect:/";
		}
	}

	@GetMapping("/postForm")
	public String joinForm() {
		return "/board/postForm";
	}

	@PostMapping("/post")
	public @ResponseBody String post(Board board) {
		int result = bService.post(board);
		if (result == 1) {
			return Script.href("/board/list");
		}
		return Script.back("Fail Post");
	}

	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		Board board = bService.updateForm(id);
		if (board != null) {
			model.addAttribute(board);
			return "/board/updateForm";
		}
		return "redirect:/";
	}

	@PostMapping("/update")
	public @ResponseBody String update(Board board) {
		int result = bService.update(board);
		if (result == 1) {
			return Script.href("/board/detail/" + board.getId());
		}
		return Script.back("Fail Update");
	}

	@GetMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		UserBoard board = bService.detail(id);
		List<UserBoard> popularBoards = bService.findOrderByReadCountDesc();
		if (board != null && popularBoards != null) {
			model.addAttribute("board", board);
			model.addAttribute("popularBoards", popularBoards);
			return "/board/detail";
		}
		return "redirect:/";
	}

	@GetMapping("/delete/{id}")
	public @ResponseBody String delete(@PathVariable int id) {
		int result = bService.delete(id);
		if (result == 1) {
			return Script.href("/board/list");
		}
		return Script.back("Fail Update");
	}

}
