package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeDemoApp {

	public static void main(String[] args) {

		// read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach chessCoach = context.getBean("theChessCoach", Coach.class);

		// call a method from the bean
		System.out.println(chessCoach.getDailyWorkout());

		// call a method to get the daily fortune
		System.out.println(chessCoach.getDailyFortune());

		// close the container
		context.close();

	}

}
