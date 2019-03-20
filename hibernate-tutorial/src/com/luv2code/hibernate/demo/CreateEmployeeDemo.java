package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class CreateEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernateemp.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();

		
		
		
		try {
			//create a student object
			System.out.println("Creating new employees objects...");
			
			Employee emp1 = new Employee("José", "Loureiro", "EUROHELP");
			Employee emp2 = new Employee("Sófia", "Gomes", "EUROHELP");
			Employee emp3 = new Employee("Cátia", "Ribeiro", "EUROHELP");
			Employee emp4 = new Employee("José", "Azevedo", "EUROHELP");
			Employee emp5 = new Employee("Maria", "Antonieta", "EUROHELP");
			
			//start a transaction
			//create session
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			//save the student object
			System.out.println("Saving employees...");
			session.save(emp1);
			session.save(emp2);
			session.save(emp3);
			session.save(emp4);
			session.save(emp5);
			
			//commit transaction
			session.getTransaction().commit();
			
			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
