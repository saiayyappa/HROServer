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

import com.app.hro.entity.Remedy;
import com.app.hro.entity.User;
import com.app.hro.service.RemedyService;
import com.app.hro.service.UserService;

@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class RemedyController {

	@Autowired
	UserService userService;

	@Autowired
	RemedyService remedyService;

	@GetMapping(path = "/remedies")
	public List<Remedy> getAllRemedies() {
		System.out.println("Get all remedies...");
		return remedyService.getAllRemedies();
	}

	@PostMapping(path = "/remedy")
	public ResponseEntity<?> createOrUpdateRemedy(@RequestBody Remedy remedy, @RequestParam long id) {
		System.out.println("Upserting Remedy");
		if (id > 0) {
			Optional<User> _u = userService.getUserById(id);
			if (!_u.get().getRole().equals("role_admin")) {
				return new ResponseEntity<>("User not authorized to perform this action", HttpStatus.BAD_REQUEST);
			} else {
				Remedy _remedy = remedyService.upsertRemedy(remedy);
				return new ResponseEntity<>(_remedy, HttpStatus.OK);
			}
		}
		return new ResponseEntity<>("User not authorized to perform this action", HttpStatus.BAD_REQUEST);
	}

	@GetMapping(path = "/remedy/{name}")
	public Remedy getRemedyByName(@PathVariable("name") String name) {
		System.out.println("Get remedy with " + name);
		return remedyService.getRemedyByName(name);
	}

	@GetMapping(path = "/cure/{name}")
	public List<Remedy> getRemediesForDisease(@PathVariable("name") String name) {
		System.out.println("Get cures for disease " + name);
		return remedyService.getRemediesForDisease(name);
	}

	@GetMapping(path = "/search/{query}")
	public ResponseEntity<?> search(@PathVariable("query") String query) {
		System.out.println("Searching..." + query);
		List<Remedy> _remedies = remedyService.search(query);
		if (_remedies.isEmpty()) {
			return new ResponseEntity<>("query not found", HttpStatus.BAD_REQUEST);
		} else {
			return new ResponseEntity<>(_remedies, HttpStatus.OK);
		}
	}

}
