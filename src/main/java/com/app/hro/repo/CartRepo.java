package com.app.hro.repo;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.app.hro.entity.Cart;

public interface CartRepo extends CrudRepository<Cart, Long> {

	public List<Cart> findByPurchasedBy(long id);

}
