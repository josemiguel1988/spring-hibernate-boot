package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class ReadEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
								.configure("hibernateemp.cfg.xml")
								.addAnnotatedClass(Employee.class)
								.buildSessionFactory();

		
		
		
		try {
			//create a student object
			System.out.println("Creating new employee object...");
			
			Employee emp = new Employee("Toni", "Kroos", "Real Madrid");
			
			//create session
			Session session = factory.getCurrentSession();
			//start a transaction
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving the employee...");
			System.out.println(emp);
			session.save(emp);
			
			//commit transaction
			session.getTransaction().commit();
			
			//MY NEW CODE
			
			//find out the student's id: primary key
			System.out.println("Saved Employee. Generated id: " + emp.getId());
			
			//now get a new session and start transaction
			session = factory.getCurrentSession();
			session.beginTransaction();
			
			//retrieve student based on the id: primary key
			System.out.println("\nGetting employee with id: " + emp.getId());
			
			Employee emp1 = session.get(Employee.class, emp.getId());
			System.out.println("Get complete: " + emp1);
			//commit the transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
