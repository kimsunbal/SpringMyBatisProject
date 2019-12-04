package com.cos.crud.repository;

import java.util.List;

import com.cos.crud.model.User;

public interface UserRepository {
	User findById(int id);
	List<User> findAll();
	void join(User user);
	User login(String username, String password);
}
