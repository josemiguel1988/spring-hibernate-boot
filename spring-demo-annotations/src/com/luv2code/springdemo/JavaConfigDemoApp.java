package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration file
		ClassPathXmlApplicationContext context= new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// get the bean from spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		// call the method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//Practice Activity #4 - Inversion of Control with Java Annotations
		Coach hCoach = context.getBean("hockeyCoach", Coach.class);
		
		System.out.println(hCoach.getDailyWorkout());
		
		/****/
		//@Scope Annotation test
		//Coach tennisCoach = context.getBean("tennisCoach", Coach.class);
		//Coach alphaCoach = context.getBean("tennisCoach", Coach.class);
		
		//boolean result = (theCoach == tennisCoach);
		
		//print out the results
		//System.out.println("\nPointing to the same object: " + result);
		//System.out.println("\nMemory location for theCoach: " + theCoach);
		//System.out.println("\nMemory location for theCoach: " + alphaCoach + "\n");
		/****/
		
		// close the context
		context.close();
	}

}
