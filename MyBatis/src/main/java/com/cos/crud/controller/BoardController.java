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
import com.cos.crud.repository.BoardRepository;

@Controller
@RequestMapping("/board")
public class BoardController {
	
	@Autowired
	private BoardRepository boardRepo; 
	
	@GetMapping("/list")
	public String list() {
		return "redirect:/board/list/1";
	}
	
	@GetMapping("/findall")
	public @ResponseBody List<Board> findAll() {
		List<Board> boards = boardRepo.findAll();
		return boards;
	}
	
	@GetMapping("/list/{page}")
	public String findByPage(@PathVariable int page, Model model) {
		int findpage = (page - 1) * 3;
		List<UserBoard> userBoards = boardRepo.findByPage(findpage);
		int countPage = boardRepo.selectCount();
		if (countPage%3==0) {
			countPage = countPage/3;
		}else {
			countPage = countPage/3+1;
		}

		List<UserBoard> popularBoards = boardRepo.findOrderByReadCountDesc();
		model.addAttribute("page",page);
		model.addAttribute("countPage",countPage);
		model.addAttribute("userBoards",userBoards);
		model.addAttribute("popularBoards",popularBoards);
		return "/board/list";
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
	
	@GetMapping("/updateForm/{id}")
	public String updateForm(@PathVariable int id, Model model) {
		Board board = boardRepo.findById(id);
		model.addAttribute(board);
		return "/board/updateForm";
	}
	
	@PostMapping("/update")
	public String update(Board board) {
		boardRepo.update(board);
		System.out.println("[[[[[[board object]]]]]]"+board);
		return "redirect:/board/detail/"+board.getId();
	}
	
	@GetMapping("/detail/{id}")
	public String detail(@PathVariable int id, Model model) {
		UserBoard board = boardRepo.joinUserFindById(id);
		boardRepo.increaseReadCount(id);
		List<UserBoard> popularBoards = boardRepo.findOrderByReadCountDesc();
		model.addAttribute("board",board);
		model.addAttribute("popularBoards",popularBoards);
		return "/board/detail";
	}

	@GetMapping("/delete/{id}")
	public String delete(@PathVariable int id) {
		boardRepo.delete(id);
		return "redirect:/board/list";
	}
	
	
}
