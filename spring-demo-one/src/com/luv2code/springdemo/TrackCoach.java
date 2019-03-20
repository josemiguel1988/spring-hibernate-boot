package com.luv2code.springdemo;

public class TrackCoach implements Coach {
	
	private FortuneService fortuneService;
	
	//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
	private FortuneServiceRandom fortuneServiceRandom;
	
	//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
	public TrackCoach(FortuneService fortuneService,FortuneServiceRandom thefortuneServiceRandom) {
		this.fortuneService = fortuneService;
		this.fortuneServiceRandom = thefortuneServiceRandom;
	}

	public TrackCoach() {
	}

	@Override
	public String getDailyWorkout() {
		
		return "Run a hard 5k";
		
	}

	@Override
	public String getDailyFortune() {
		return "Just do It: " + this.fortuneService.getFortune();
	}
	
	//<!-- Practice Activity #2 - Dependency Injection with XML Configuration -->
	@Override
	public String getNewDailyFortune() {
		return this.fortuneServiceRandom.getFortune();
	}
	
	// add an init method
	public void doMyStartupStuff() {
		System.out.println("Track Coach: inside method doMyStartupStuff");
	}
	
	// add a destroy method 
	public void doMyCleanupStuff() {
		System.out.println("Track Coach: inside method doMyCleanupStuff");
	}

}
