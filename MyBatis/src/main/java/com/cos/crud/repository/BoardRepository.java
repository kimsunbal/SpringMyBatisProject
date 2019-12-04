package com.cos.crud.repository;

import java.util.List;

import com.cos.crud.model.Board;
import com.cos.crud.model.UserBoard;

public interface BoardRepository {
	List<Board> findAll();
	void post(Board board);
	Board findById(int id);
	void delete(int id);
	void update(Board board);
	List<UserBoard> findByPage(int page);
	UserBoard joinUserFindById(int id);
	int selectCount();
	void increaseReadCount(int id);
	List<UserBoard> findOrderByReadCountDesc();
}
