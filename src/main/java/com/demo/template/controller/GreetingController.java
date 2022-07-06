package com.demo.template.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.template.domain.Message;
import com.demo.template.domain.User;
import com.demo.template.service.GreetingService;

@RestController
public class GreetingController {

	@Autowired
	private GreetingService greetingService;

	@GetMapping("/greeting")
	public Message sayHelloWorld() {
		return greetingService.sayHelloWorld();
	}

	@PostMapping("/greeting")
	public Message sayHelloWorldToUser(@Validated @RequestBody User user) {
		return greetingService.sayHelloWorldToUser(user);
	}

}
