package com.mlbd.springstarterdemo.modules.users.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/users")
public class UserController {
	
	@GetMapping("/dummy")
	public ResponseEntity<String> getDummyUser() {
		return new ResponseEntity<>("Hello User!", HttpStatus.OK);
	}
}
