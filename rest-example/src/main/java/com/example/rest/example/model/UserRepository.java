package com.example.rest.example.model;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {

	public User findUserById(int id);
	@Override public List<User> findAll();
	
}
