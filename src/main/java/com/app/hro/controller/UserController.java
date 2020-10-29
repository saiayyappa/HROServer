package com.app.hro.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.app.hro.entity.User;
import com.app.hro.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class UserController {

	@Autowired
	UserService userService;

	@GetMapping(path = "/users")
	public List<User> getUsers() {
		System.out.println("Get all Users...");
		return userService.getUsers();
	}

	@PostMapping(path = "/user")
	public ResponseEntity<?> upsertUser(@RequestBody User user, @RequestParam Long id) {
		System.out.println("Upserting User...");
		if (id.intValue() > 0 && user.getId() > 0) {
			Optional<User> _u = userService.getUserById(id);
			if (!_u.get().getRole().equals("role_admin"))
				return new ResponseEntity<>("User not authorized to perform this action", HttpStatus.BAD_REQUEST);
		}
		User _user = userService.upsertUser(user);
		return new ResponseEntity<>(_user, HttpStatus.OK);
	}

	@GetMapping(path = "/user/{userId}")
	public Optional<User> getUserById(@PathVariable("userId") Long userId) {
		System.out.println("Get user with with " + userId);
		return userService.getUserById(userId);
	}

	@PostMapping(path = "/login")
	public String userLogin(@RequestBody User user) {
		System.out.println("Logging in...");
		return userService.login(user);
	}
}
