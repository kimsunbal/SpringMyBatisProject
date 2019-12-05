package com.cos.crud.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cos.crud.model.Board;
import com.cos.crud.model.UserBoard;
import com.cos.crud.repository.BoardRepository;
import com.cos.crud.utils.Utils;

@Service
public class BoardService {

	@Autowired
	private BoardRepository boardRepo;

	public List<Board> findAll() {
		try {
			List<Board> boards = boardRepo.findAll();
			return boards;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public List<UserBoard> findByPage(int page) {
		try {
			int findpage = (page - 1) * 3;
			List<UserBoard> userBoards = boardRepo.findByPage(findpage);
			Utils.setPreviewImg(userBoards);
			return userBoards;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int selectCount() {
		try {
			int countPage = boardRepo.selectCount();
			if (countPage % 3 == 0) {
				countPage = countPage / 3;
			} else {
				countPage = countPage / 3 + 1;
			}
			return countPage;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public List<UserBoard> findOrderByReadCountDesc() {
		try {
			List<UserBoard> popularBoards = boardRepo.findOrderByReadCountDesc();
			Utils.setPreviewImg(popularBoards);
			return popularBoards;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int post(Board board) {
		try {
			boardRepo.post(board);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public Board updateForm(int id) {
		try {
			Board board = boardRepo.findById(id);
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int update(Board board) {
		try {
			boardRepo.update(board);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

	public UserBoard detail(int id) {
		try {
			UserBoard board = boardRepo.joinUserFindById(id);
			boardRepo.increaseReadCount(id);
			return board;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}

	public int delete(int id) {
		try {
			boardRepo.delete(id);
			return 1;
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1;
	}

}
