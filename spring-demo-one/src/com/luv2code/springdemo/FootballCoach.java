package com.luv2code.springdemo;

import java.util.Random;

public class FootballCoach implements Coach {

	private FortuneService fortuneService;
	private String[] fortune = { "Today is your day!", "Today is not your day, don't worry!", "You are the best!"};
	final Random random = new Random();

	public FootballCoach() {
		
	}
	
	public FootballCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}

	@Override
	public String getDailyWorkout() {
		return "Shots on goal 1 hour";
	}

	@Override
	public String getDailyFortune() {
		return fortune[random.nextInt(fortune.length)];
	}

}
