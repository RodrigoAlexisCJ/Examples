package com.example.validationexample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.validationexample.dto.UserRequest;
import com.example.validationexample.entity.User;
import com.example.validationexample.exception.UserNotFoundException;
import com.example.validationexample.service.UserService;

@RestController
@RequestMapping(value = "/users")
public class UserController {

	@Autowired
	private UserService service;
	
	@GetMapping(value = "/fetchAll")
	public ResponseEntity<List<User>> getAllUser() {
		return ResponseEntity.ok(service.getAllUser());
	}
	
	@GetMapping(value = "/{id}")
	public ResponseEntity<User> getUser(@PathVariable int id) throws UserNotFoundException {
		return new ResponseEntity<>(service.getUser(id),HttpStatus.OK);
//		return ResponseEntity.ok(service.getUser(id));
	}
	
	@PostMapping(value = "/signup")
	public ResponseEntity<User> saveUser(@Valid @RequestBody UserRequest request) {
		return new ResponseEntity<>(service.saveUser(request),HttpStatus.CREATED);
	}
	
}
