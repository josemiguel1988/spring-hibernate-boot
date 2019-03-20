//Practice Activity #7 - Inversion of Control and Dependency Injection with Java Code
package com.luv2code.springdemo;

public class AwesomeFortuneService implements FortuneService {

	@Override
	public String getFortune() {
		return "Today is a awesome day";
	}

}
