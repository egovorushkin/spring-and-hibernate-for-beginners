package com.luv2code.springdemo;

public class MyApp {

	public static void main(String[] args) {
		
		// create the object
		Coach theCoach = new TrackCoach();
		
		// use the coach
		System.out.println(theCoach.getDailyWorkout());
	}

}
