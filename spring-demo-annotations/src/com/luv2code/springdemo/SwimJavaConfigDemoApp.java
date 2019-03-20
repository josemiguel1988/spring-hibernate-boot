package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		// read spring configuration file
		AnnotationConfigApplicationContext context= new AnnotationConfigApplicationContext(SportConfig.class);
				
		// get the bean from spring container
		//Coach theCoach = context.getBean("swimCoach",Coach.class);
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		
		
		//call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		
		//call a method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		//call or new swim methods ... has the props values injected
		System.out.println("email: " + theCoach.getEmail());
		System.out.println("team: " + theCoach.getTeam());
		
		// close the context
		context.close();
	}

}
