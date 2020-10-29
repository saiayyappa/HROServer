package com.app.hro.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.hro.entity.Cart;
import com.app.hro.repo.CartRepo;

@Service
public class CartServiceImpl implements CartService {

	@Autowired
	CartRepo cartRepo;

	@Override
	public Cart processTransaction(Cart cart) {
		Cart _cart = cartRepo.save(cart);
		return _cart;
	}

	@Override
	public List<Cart> getTransactionByUser(Long userId) {
		return cartRepo.findByPurchasedBy(userId);
	}

}
