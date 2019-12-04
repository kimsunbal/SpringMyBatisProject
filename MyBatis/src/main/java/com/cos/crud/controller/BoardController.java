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
import com.cos.crud.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepo; 
	
	@GetMapping("/list")
	public String list(Model model) {
		List<Board> boards = boardRepo.findAll();
		model.addAttribute("boards", boards);
		return "/board/list";
	}
	
	@GetMapping("/findall")
	public @ResponseBody List<Board> findAll() {
		List<Board> boards = boardRepo.findAll();
		return boards;
	}

	@GetMapping("/postForm")
	public String joinForm() {
		return "/board/postForm";
	}
	
	@PostMapping("/post")
	public String post(Board board) {
		boardRepo.post(board);
		return "redirect:/board/list";
	}
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		Board board = boardRepo.findById(id);
		model.addAttribute(board);
		return "/board/detail";
	}
}
