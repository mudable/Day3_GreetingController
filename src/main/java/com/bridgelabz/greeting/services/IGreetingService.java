package com.bridgelabz.greeting.services;

import java.util.List;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import com.bridgelabz.greeting.user.UserDto;

public interface IGreetingService {
	Greeting greetingMessage();
	String greetingMessageByName(UserDto userDto);
	Greeting addGreeting(User user);
	Greeting findGreetingById(long id);
	List<Greeting> getAllGreetings();
	Greeting editGreeting(Greeting greeting);
}