package com.cos.crud.repository;

import com.cos.crud.model.Person;

public interface PersonRepository {
	Person findById(int id);

}