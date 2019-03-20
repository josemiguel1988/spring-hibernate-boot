// Practice Activity #1 - Inversion of Control with XML Configuration
package com.luv2code.springdemo;

public class FootballCoach implements Coach {
	
	private FortuneService fortuneService;
	//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
	private FortuneServiceRandom fortuneServiceRandom;
	
	//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
	public FootballCoach(FortuneService fortuneService,FortuneServiceRandom thefortuneServiceRandom) {
		System.out.println("Football: inside no-arg constructor");
		this.fortuneService = fortuneService;
		this.fortuneServiceRandom = thefortuneServiceRandom;
	}
	
	@Override
	public String getDailyWorkout() {
		return "Run 30 minutes. Do several sprints and jump barriers for 15 minutes for each activity.";
	}

	@Override
	public String getDailyFortune() {
		return "Football: "+this.fortuneService.getFortune();
	}
	//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
	@Override
	public String getNewDailyFortune() {
		return this.fortuneServiceRandom.getFortune();
	}

}
