package com.app.hro;

import java.util.stream.Stream;

import org.springframework.boot.ApplicationRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.app.hro.entity.Remedy;
import com.app.hro.entity.User;
import com.app.hro.repo.RemedyRepo;
import com.app.hro.repo.UserRepo;

@SpringBootApplication
public class HroApplication {

	public static void main(String[] args) {
		SpringApplication.run(HroApplication.class, args);
	}

	@Bean
	ApplicationRunner init(UserRepo userRepo) {
		return args -> {
			Stream.of(new User("User1", "user1@gmail.com", "root", "role_admin"),
					new User("User2", "user2@gmail.com", "root", "role_member")).forEach(user -> {
						userRepo.save(user);
					});
			userRepo.findAll().forEach(System.out::println);
		};
	}
	
	@Bean
	ApplicationRunner initRemedy(RemedyRepo remedyRepo) {
		return args -> {
			Stream.of(new Remedy("lemon", "scurvy", "yellow citrus fruit", 25),
					new Remedy("apple", "gingivitis", "red malic fruit", 50)).forEach(remedy -> {
						remedyRepo.save(remedy);
					});
			remedyRepo.findAll().forEach(System.out::println);
		};
	}

}