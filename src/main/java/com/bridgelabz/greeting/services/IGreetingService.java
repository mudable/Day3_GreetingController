package com.bridgelabz.greeting.services;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import com.bridgelabz.greeting.user.UserDto;

public interface IGreetingService {
	Greeting greetingMessage();
	String greetingMessageByName(UserDto userDto);
	Greeting addGreeting(User user);


}