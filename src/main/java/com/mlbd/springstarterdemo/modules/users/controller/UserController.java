package com.mlbd.springstarterdemo.modules.users.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.mlbd.springstarterdemo.libs.Utils;
import com.mlbd.springstarterdemo.modules.users.repositories.UserRepository;
import com.mlbd.springstarterdemo.schemas.User;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
public class UserController {

	private final UserRepository userRepository;

	@GetMapping("/dummy")
	public ResponseEntity<String> getDummyUser() {
		return new ResponseEntity<>("Hello User!", HttpStatus.OK);
	}

	@PostMapping
	public ResponseEntity<?> createUser(@Validated @RequestBody User user) {
		User newUser = userRepository.save(user);
		return new ResponseEntity<>(newUser, HttpStatus.CREATED);
	}

	@GetMapping
	public ResponseEntity<?> getALl() {
		return new ResponseEntity<>(userRepository.findAll(), HttpStatus.OK);
	}

	@GetMapping("/user")
	public ResponseEntity<?> getUserByName(@RequestParam("name") String name) {
		List<User> users = userRepository.findByName(name);
		return new ResponseEntity<>(users, HttpStatus.OK);
	}

	@GetMapping("/{id}")
	public ResponseEntity<?> getUser(@PathVariable("id") Long id) {
		Optional<User> user = userRepository.findById(id);
		if (user.isPresent()) {
			return new ResponseEntity<>(user.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>("User not found ally with ID : " + id, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Long id) {
		userRepository.deleteById(id);
	}

	@PutMapping("/{id}")
	public ResponseEntity<?> updateUser(@PathVariable("id") Long id, @Validated @RequestBody User user) {
		User sourceUser = userRepository.getOne(id);
		Utils.merge(sourceUser, user);
		User updatedUser = userRepository.save(sourceUser);
		return new ResponseEntity<>(updatedUser, HttpStatus.CREATED);
	}
}
