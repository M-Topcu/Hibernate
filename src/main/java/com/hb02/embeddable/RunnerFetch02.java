package com.hb02.embeddable;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class RunnerFetch02 {

	public static void main(String[] args) {
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student02.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Student02 student = session.get(Student02.class, 1002);

		System.out.println(student);
		System.out.println(student.getAdress());

		
		session.close();
		
		sf.close();

	}

}
