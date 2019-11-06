package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {

		// read spring configuration java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(MyLoggerConfig.class,
				SportConfig.class);

		// get the bean from spring container
		SwimCoach theCoach = context.getBean("swimCoach", SwimCoach.class);

		// call a method from the bean
		System.out.println(theCoach.getDailyWorkout());

		// call a method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());

		// call our new swim coach methods ... has the props values injected
		System.out.println("email: " + theCoach.getEmail());

		System.out.println("team: " + theCoach.getTeam());

		// close the container
		context.close();

	}

}
