package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationDemoApp {

	public static void main(String[] args) {

		// read spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");

		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach", Coach.class);

		// call a method from the bean
		System.out.println(theCoach.getDailyWorkout());

		// call a method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());

		// close the container
		context.close();

	}

}
