package com.luv2code.aopdemo;

import java.util.logging.Logger;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.luv2code.aopdemo.service.TrafficFortuneService;

public class AroundHandleExceptionDemoApp {

	public static void main(String[] args) {
		
		Logger myLogger = Logger.getLogger(AroundHandleExceptionDemoApp.class.getName());	 

		// read spring config java class
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DemoConfig.class);

		// get the bean from spring container
		TrafficFortuneService theFortuneService = context.getBean("trafficFortuneService", TrafficFortuneService.class);
		
		myLogger.info("\nMain Program: AroundWithLoggerDemoApp");
		
		myLogger.info("Calling getFortune");
		
		boolean tripWire = true;
		
		
		String data = theFortuneService.getFortune(tripWire);
		
		myLogger.info("\nMy  fortune is: " + data);
		
		myLogger.info("Finished");


		// close the context
		context.close();
	}
}
