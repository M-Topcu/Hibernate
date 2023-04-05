package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave06 {

	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Book06.class).addAnnotatedClass(Student06.class);

		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Student06 student1 = new Student06();
		student1.setId(1001);
		student1.setName("John Coffee");
		student1.setGrade(10);
		
		Student06 student2 = new Student06();
		student2.setId(1002);
		student2.setName("James Bond");
		student2.setGrade(11);
		
		Student06 student3 = new Student06();
		student3.setId(1003);
		student3.setName("Tony Stark");
		student3.setGrade(9);
		
	
		Transaction tx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		tx.commit();
		session.close();
		sf.close();

	}

}
