package com.bridgelabz.greeting.services;

import java.util.concurrent.atomic.AtomicLong;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import com.bridgelabz.greeting.repositary.IGreetingRepository;
import com.bridgelabz.greeting.user.UserDto;

@Service
public class GreetingService implements IGreetingService {
	private static final String template = "Hello world";
	private final AtomicLong counter = new AtomicLong();

	@Autowired
	private IGreetingRepository greetingRepository;
	@Override
	public Greeting greetingMessage() {
		return new Greeting(counter.incrementAndGet(), String.format(template));
	}

	@Override
	public String greetingMessageByName(UserDto userDto) {
		User user = new User();
		ModelMapper modelMapper = new ModelMapper();
		modelMapper.map(userDto, user);
		return ("Hello " + user.getFirstName() + " " + user.getLastName());
	}

	@Override
	public Greeting addGreeting(User user) {
	String message=String.format(template, (user.toString().isEmpty())?"Hello World":user.toString());
		return greetingRepository.save(new Greeting(counter.incrementAndGet(),message)) ;
	}

	@Override
	public Greeting findGreetingById(long id) {
		return greetingRepository.findById(id).get();
		
	}
	
	
	
	
}