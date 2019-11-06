package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component("theChessCoach")
public class ChessCoach implements Coach {

	@Autowired
	@Qualifier("myFortuneService")
	private FortuneService fortuneService;
	
	public ChessCoach() {
		System.out.println(">> ChessCoach: inside constructor");
	}

	@Override
	public String getDailyWorkout() {
		return "Chess is a best game";
	}

	@Override
	public String getDailyFortune() {
		System.out.println(">> ChessCoach: inside getDailyFortune() method");
		return fortuneService.getFortune();
	}

}
