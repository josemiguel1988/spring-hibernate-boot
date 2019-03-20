package com.luv2code.springdemo;

public class BaseballCoach implements Coach{
	
	//define a private field for the dependency
	private FortuneService fortuneService;
	
	//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
	private FortuneServiceRandom fortuneServiceRandom;
	
	//define a constructor for dependency injection
	//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
	public BaseballCoach(FortuneService theFortuneService,FortuneServiceRandom thefortuneServiceRandom) {
		this.fortuneService = theFortuneService;
		this.fortuneServiceRandom = thefortuneServiceRandom;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Spend 30 minutes on batting practice";
		
	}

	@Override
	public String getDailyFortune() {
		return this.fortuneService.getFortune();
	}

	@Override
	public String getNewDailyFortune() {
		return this.fortuneServiceRandom.getFortune();
	}

}
