package com.app.hro.repo;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import com.app.hro.entity.User;

public interface UserRepo extends CrudRepository<User, Long>{

	public Optional<User> findByName(String name);
	
}
