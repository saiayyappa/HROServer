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

import com.app.hro.entity.Cart;
import com.app.hro.entity.User;
import com.app.hro.service.CartService;
import com.app.hro.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class CartController {

	@Autowired
	CartService cartService;

	@Autowired
	UserService userService;

	@PostMapping(path = "/cart")
	public ResponseEntity<?> processTransaction(@RequestBody Cart cart, @RequestParam long id) {
		System.out.println("Processing Transaction");
		if (id > 0) {
			cart.setPurchasedBy(id);
			Optional<User> _u = userService.getUserById(id);
			if (_u.isPresent()) {
				cartService.processTransaction(cart);
				return new ResponseEntity<>("transaction completed successfully", HttpStatus.OK);
			} else {
				return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
			}
		}
		return new ResponseEntity<>("User not found", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/cart/{userId}")
	public List<Cart> getTransactionByUser(@PathVariable("userId") long userId) {
		System.out.println("Get all transactions for " + userId);
		return cartService.getTransactionByUser(userId);
	}
}
