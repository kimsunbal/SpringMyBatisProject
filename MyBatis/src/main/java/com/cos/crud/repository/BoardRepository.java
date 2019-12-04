package com.cos.crud.repository;

import java.util.List;

import com.cos.crud.model.Board;

public interface BoardRepository {
	List<Board> findAll();
	void post(Board board);
	Board findById(int id);
}
