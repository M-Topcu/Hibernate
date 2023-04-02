package com.hb03.onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave03 {

	public static void main(String[] args) {
		
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student03.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		
		Transaction tx = session.beginTransaction();
		
		
		tx.commit();
		
		session.close();
		sf.close();
	}

}
