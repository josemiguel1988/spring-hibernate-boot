//Practice Activity #7 - Inversion of Control and Dependency Injection with Java Code
package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
//@ComponentScan("com.luv2code.springdemo")
@PropertySource("classpath:football.properties")
public class FootballConfig {
	
	//define bean for our sad fortune service
	@Bean
	public FortuneService awesomeFortuneService() {
		return new AwesomeFortuneService();
	}
	
	@Bean
	public Coach footballCoach() {
		return new FootballCoach(awesomeFortuneService());
	}
	
    //define bean for our swim coach AND inject dependency	
}
