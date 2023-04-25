package com.example.validationexample.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.validationexample.entity.User;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findUserByUserId(int id);
	@Override List<User> findAll();
	
}
