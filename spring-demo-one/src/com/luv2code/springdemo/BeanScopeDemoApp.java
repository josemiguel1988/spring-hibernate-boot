package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class BeanScopeDemoApp {

	public static void main(String[] args) {
		
		//load the spring configuration file
		
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beanScope-applicationContext.xml");
		
		//retrieve bean from spring container
		Coach theCoach = context.getBean("myCoach", Coach.class);
		Coach alphaCoach = context.getBean("myCoach", Coach.class);
		
		boolean result = (theCoach == alphaCoach);
		
		//print out the results
		System.out.println("\nPointing to the same object: " + result);
		System.out.println("\nMemory location for theCoach: " + theCoach);
		System.out.println("\nMemory location for theCoach: " + alphaCoach + "\n");
		
		
		//Practice Activity #3 - Bean Scopes with XML Configuration
		Coach theBCoach = context.getBean("myBCoach", Coach.class);
		Coach alphaBCoach = context.getBean("myBCoach", Coach.class);
		
		boolean resultbaseball = (theBCoach == alphaBCoach);
		
		System.out.println("\nPointing to the same object: " + resultbaseball);
		System.out.println("\nMemory location for theBCoach: " + theBCoach);
		System.out.println("\nMemory location for alphaBCoach: " + alphaBCoach + "\n");

		Coach theFCoach = context.getBean("myFCoach", Coach.class);
		Coach alphaFCoach = context.getBean("myFCoach", Coach.class);
		
		boolean resultfootball = (theFCoach == alphaFCoach);
		
		System.out.println("\nPointing to the same object: " + resultfootball);
		System.out.println("\nMemory location for theBCoach: " + theFCoach);
		System.out.println("\nMemory location for alphaBCoach: " + alphaFCoach + "\n");
		
		//close the context
		context.close();
		
	}

}
