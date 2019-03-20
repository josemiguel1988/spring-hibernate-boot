package com.luv2code.aopdemo.aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class MyDemoLoggingAspect {

	// this is where we add all of our related advices for logging
	
	//lets's start with an @Before advice
	
	//match all classes with this method
	//@Before("execution(public void addAccount())")
	//match only method in AccountDAO class
	//@Before("execution(public void com.luv2code.aopdemo.dao.AccountDAO.addAccount())")
	//match method that starts with add
	//@Before("execution(public void add*())")
	//match any return type on method that starts with add
	//@Before("execution(* add*())")
	//match any return type on method that starts with add and have 1 parameter Account
	//@Before("execution(* add*(com.luv2code.aopdemo.Account))")
	//match any return type on method that starts with add and have Account and extra 0 or more parameters 
	//@Before("execution(* add*(com.luv2code.aopdemo.Account,..))")
	//match any return type on method that starts with add and 0 or more parameters 
	//@Before("execution(* add*(..))")
	//match methods in package
	@Before("execution(* com.luv2code.aopdemo.dao.*.*(..))")
	public void beforeAddAccountAdvice() {
		
		System.out.println("\n=====>>> Executing @Before advice on method");
	
	}
}
