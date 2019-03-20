package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class HelloSpringApp {

	public static void main(String[] args) {
		
		// load the spring configuration file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// retrieve bean from spring container
		Coach theBCoach = context.getBean("myBCoach",Coach.class);
		
		// call methods on the bean
		System.out.println(theBCoach.getDailyWorkout());
		
		//call our new method for fortunes
		System.out.println(theBCoach.getDailyFortune());
		
		//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
		System.out.println(theBCoach.getNewDailyFortune());
		
		
		Coach theTCoach = context.getBean("myTCoach",Coach.class);
		
		// call methods on the bean
		System.out.println(theTCoach.getDailyWorkout());
		
		//call our new method for fortunes
		System.out.println(theTCoach.getDailyFortune());
		
		//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
		System.out.println(theTCoach.getNewDailyFortune());
		
		// Practice Activity #1 - Inversion of Control with XML Configuration
		Coach theFCoach = context.getBean("myFootballCoach", Coach.class);
		
		// call methods on the bean
		System.out.println(theFCoach.getDailyWorkout());
		
		//call our new method for fortunes
		System.out.println(theFCoach.getDailyFortune());
		
		//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
		System.out.println(theFCoach.getNewDailyFortune());
		
		// close the context
		context.close();

	}

}
