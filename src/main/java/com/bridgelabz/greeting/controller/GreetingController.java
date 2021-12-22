package com.bridgelabz.greeting.controller;

import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.greeting.model.Greeting;
import com.bridgelabz.greeting.model.User;
import com.bridgelabz.greeting.services.IGreetingService;
import com.bridgelabz.greeting.user.UserDto;

@RestController
public class GreetingController {
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	/**
	 * curl localhost:8080/greeting
	 * 
	 * @return={id =1 , content="hello world!}
	 *             localhost:8080/greeting?name=Shilpa @return= {
	 *             id=2,content="hello Shilpa!
	 */
	@GetMapping(value = { "/greeting", "/greeting/", "/greeting/home" })
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	/**
	 * localhost:8080/greeting/Shilpa
	 * 
	 * @return={id =1 , content="hello Shilpa!}
	 */
	@GetMapping("greeting/{name}")
	public Greeting greetings(@PathVariable String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}

	@Autowired
	private IGreetingService greetingService;

	/**
	 * localhost:8080/greeting/service
	 * 
	 * @return={id =1 , content="hello world!}
	 */
	@GetMapping("greeting/service")
	public Greeting greetings() {
		return greetingService.greetingMessage();
	}

	@PostMapping("/greeting")
	public String greetingMessage(@RequestBody UserDto userDto) {
		return greetingService.greetingMessageByName(userDto);
	}
/* Used add method to store on Repository.
 * 
 */
	@GetMapping("/greetings")
	public Greeting greetingdata(@RequestParam(value = "name", defaultValue = "World") String name) {
		User user = new User();
		user.setFirstName(name);
		return greetingService.addGreeting(user);
	}
	@GetMapping("/greetingdata/{id}")
	public Greeting findGreetingById(@PathVariable long id) {
		return greetingService.findGreetingById(id);
}
	@GetMapping("/greetinglist")
	public List<Greeting> getAllGreetings() {
		return greetingService.getAllGreetings();
	}
	@PutMapping("/editdata")
	public Greeting editGreeting(Greeting greeting) {
		return greetingService.editGreeting(greeting);	
	}
}