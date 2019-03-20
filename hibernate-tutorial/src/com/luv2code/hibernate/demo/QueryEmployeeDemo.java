package com.luv2code.hibernate.demo;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class QueryEmployeeDemo {

	@SuppressWarnings("unchecked")
	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernateemp.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();

		
		
		
		try {
			//create session
			Session session = factory.getCurrentSession();
			//start a transaction
			session.beginTransaction();
			
			//query students
			List<Employee> theEmployees = session.createQuery("from Employee").getResultList();
			
			//display the students
			displayEmployees(theEmployees);
			
			//query students: lastName='Doe'
			theEmployees = session.createQuery("from Employee e where e.company='EUROHELP' ").getResultList();
			
			//display the students
			System.out.println("\n\nEmployees from EUROHELP");
			displayEmployees(theEmployees);
			
			theEmployees = session.createQuery("from Employee e where e.company='Real Madrid' ").getResultList();
			System.out.println("\n\nEmployees from Real Madrid");
			displayEmployees(theEmployees);
			
			
			theEmployees = session.createQuery("from Employee e where e.company='Juventus' ").getResultList();
			System.out.println("\n\nEmployees from Juventus");
			displayEmployees(theEmployees);
			
			
			theEmployees = session.createQuery("from Employee e where e.company='Google' ").getResultList();
			System.out.println("\n\nEmployees from Google");
			displayEmployees(theEmployees);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

	private static void displayEmployees(List<Employee> theEmployees) {
		for(Employee tempEmp : theEmployees) {
			System.out.println(tempEmp);
		}
	}

}
