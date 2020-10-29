package com.app.hro.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hro.entity.User;
import com.app.hro.repo.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserRepo userRepo;

	@Override
	public List<User> getUsers() {
		return (List<User>) userRepo.findAll();
	}

	@Override
	public User upsertUser(User user) {
		return userRepo.save(user);
	}

	@Override
	public Optional<User> getUserByName(String name) {
		return userRepo.findByName(name);
	}
	
	@Override
	public Optional<User> getUserById(Long id) {
		return userRepo.findById(id);
	}

	@Override
	public String login(User user) {
		Optional<User> _user = this.getUserByName(user.getName());
		System.out.println(_user.toString());
		if (_user.isPresent() &&_user.get().getPassword().equals(user.getPassword())) {
			return String.valueOf(_user.get().getId());
		} else {
			return "fail";
		}
	}
}
