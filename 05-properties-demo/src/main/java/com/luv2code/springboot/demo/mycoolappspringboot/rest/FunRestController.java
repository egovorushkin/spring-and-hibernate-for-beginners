package com.luv2code.springboot.demo.mycoolappspringboot.rest;

import java.time.LocalDateTime;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class FunRestController {
	
	// inject properties for: coach.name and team.name
	
	@Value("${coach.name}")
	private String coachName;
	
	@Value("${team.name}")
	private String teamName;
	
	// expose a new endpoint for "teaminfo"
	@GetMapping("/teaminfo")
		public String teamInfo() {
		
		return "Coach: " + coachName + ", Team name: " + teamName;
	}
	
	
	// expose "/" that returns "Hello World!"
	@GetMapping("/")
	public String sayHello() {
		
		return "Hello world! Time on server is " + LocalDateTime.now();
	}
	
	// expose a new endpoint for "workout"
	@GetMapping("/workout")
	public String getDailyWorkout() {
		
		return "Run a Hard 5k!";
	}
	
	// expose a new endpoint for "fortune"
	@GetMapping("/fortune")
	public String getDailyFortune() {
		
		return "Today is your lucky day!";
	}

}
