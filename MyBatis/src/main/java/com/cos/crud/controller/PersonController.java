package com.cos.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cos.crud.model.Person;
import com.cos.crud.repository.PersonRepository;


@RestController
public class PersonController {

	@Autowired
	PersonRepository repository;

	@GetMapping("/person")
	public Person getPerson() {
		Person person = repository.findById(1);
		return person;
	}
}