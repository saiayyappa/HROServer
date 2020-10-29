package com.app.hro.service;

import java.util.List;

import com.app.hro.entity.Cart;

public interface CartService {

	public Cart processTransaction(Cart cart);

	public List<Cart> getTransactionByUser(Long userId);
	
}
