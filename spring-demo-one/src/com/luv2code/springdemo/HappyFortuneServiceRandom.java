package com.luv2code.springdemo;

import java.util.Random;

public class HappyFortuneServiceRandom implements FortuneServiceRandom{
	
	// create an array of strings
		private String[] data = { 
				"1st",
				"2nd",
				"3rd"
		};
		
		// create a random number generator
		private Random myRandom = new Random();
			
		@Override
		public String getFortune() {
			// pick a random string from the array
			int index = myRandom.nextInt(data.length);
			
			String theFortune = data[index];
			
			return theFortune;
		}
		

}
