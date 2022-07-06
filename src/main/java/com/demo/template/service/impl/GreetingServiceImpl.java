package com.demo.template.service.impl;

import org.springframework.stereotype.Service;

import com.demo.template.domain.Message;
import com.demo.template.domain.User;
import com.demo.template.service.GreetingService;

@Service
public class GreetingServiceImpl implements GreetingService {

	@Override
	public Message sayHelloWorld() {
		return new Message("Hello World!");
	}

	@Override
	public Message sayHelloWorldToUser(User user) {
		return new Message("Hello World to " + user.getFirstName() + " " + user.getLastName());
	}
}
