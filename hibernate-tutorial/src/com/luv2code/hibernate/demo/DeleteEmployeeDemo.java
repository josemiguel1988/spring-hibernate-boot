package com.luv2code.hibernate.demo;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.luv2code.hibernate.demo.entity.Employee;

public class DeleteEmployeeDemo {

	public static void main(String[] args) {
		
		// create session factory
		SessionFactory factory = new Configuration()
									.configure("hibernateemp.cfg.xml")
									.addAnnotatedClass(Employee.class)
									.buildSessionFactory();

		
		//create session
		
		
		try {
			int empId = 2;
			//start a transaction
			Session session = factory.getCurrentSession();
			session.beginTransaction();
			
			System.out.println("Getting employee with id: " + empId);
			
			Employee myEmp = session.get(Employee.class,empId);
			
			System.out.println("Deleting student: " + myEmp);
			session.delete(myEmp);
			
			
			//System.out.println("Deleting employee id=2");
			//session.createQuery("delete from Employee where id=2").executeUpdate();
			
			//commit transaction
			session.getTransaction().commit();

			System.out.println("Done!");
			
		} finally {
			factory.close();
		}
	}

}
