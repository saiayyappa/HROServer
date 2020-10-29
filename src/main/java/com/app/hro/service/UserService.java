package com.app.hro.service;

import java.util.List;
import java.util.Optional;

import com.app.hro.entity.User;

public interface UserService {

	public List<User> getUsers();

	public User upsertUser(User user);

	public Optional<User> getUserByName(String name);
		
	public Optional<User> getUserById(Long id);
	
	public String login(User user);
}
