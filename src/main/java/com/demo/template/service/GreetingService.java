package com.demo.template.service;

import com.demo.template.domain.Message;
import com.demo.template.domain.User;

public interface GreetingService {

	Message sayHelloWorld();

	Message sayHelloWorldToUser(User user);
}
