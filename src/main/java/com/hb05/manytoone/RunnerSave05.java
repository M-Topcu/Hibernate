package com.hb05.manytoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave05 {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		Configuration con = new Configuration().configure("hibernate.cfg.xml");
				//addAnnotatedClass(University.class).addAnnotatedClass(Student05.class);
		// Bunu eklemeden hibernate.cfg.xml uzerinden halledebiliyoruz
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Student05 student1 = new Student05();
		student1.setId(1001);
		student1.setName("John Coffee");
		student1.setGrade(10);
		
		Student05 student2 = new Student05();
		student2.setId(1002);
		student2.setName("James Bond");
		student2.setGrade(11);
		
		Student05 student3 = new Student05();
		student3.setId(1003);
		student3.setName("Tony Stark");
		student3.setGrade(9);
		
		University universite = new University();
		universite.setId(1);
		universite.setName("TPE Tech");
		
		student1.setUniversite(universite);
		student2.setUniversite(universite);
		student3.setUniversite(universite);

		
		Transaction tx = session.beginTransaction();
		
		session.save(universite);
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		tx.commit();
		session.close();
		sf.close();

	}

}
