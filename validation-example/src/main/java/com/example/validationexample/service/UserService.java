package com.example.validationexample.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.validationexample.dto.UserRequest;
import com.example.validationexample.entity.User;
import com.example.validationexample.exception.UserNotFoundException;
import com.example.validationexample.repository.UserRepository;

@Service
public class UserService {

	@Autowired
	private UserRepository repository;
	
	public User saveUser(UserRequest request) {
		User user = User.build(0, request.getName(), request.getEmail(), 
				request.getMobile(), request.getGender(), request.getAge(), request.getNationality()); 
		return repository.save(user);
	}
	
	public List<User> getAllUser() {
		return repository.findAll();
	}
	
	public User getUser(int id) throws UserNotFoundException{
		User userFinded = repository.findUserByUserId(id);
		if (userFinded == null) {
			throw new UserNotFoundException(String.format("User not Found: %d", id));
		} else {
			return userFinded;
		}
	}
	
}
