package com.hb04.bi_onetoone;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave04 {

	public static void main(String[] args) {
		
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student04.class).addAnnotatedClass(Diary2.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Student04 student1 = new Student04();
		student1.setId(1001);
		student1.setName("John Coffee");
		student1.setGrade(10);
		
		Student04 student2 = new Student04();
		student2.setId(1002);
		student2.setName("James Bond");
		student2.setGrade(11);
		
		Student04 student3 = new Student04();
		student3.setId(1003);
		student3.setName("Tony Stark");
		student3.setGrade(9);
		
		Diary2 diary1 = new Diary2();
		diary1.setId(101);
		diary1.setName("John`s Diary");
		diary1.setStudent(student1);
		
		Diary2 diary2 = new Diary2();
		diary2.setId(102);
		diary2.setName("James` Diary");
		diary2.setStudent(student2);
		
		Diary2 diary3 = new Diary2();
		diary3.setId(103);
		diary3.setName("No One`s Diary");
		
		Transaction tx = session.beginTransaction();
		
		session.save(student1);
		session.save(student2);
		session.save(student3);
		
		session.save(diary1);
		session.save(diary2);
		session.save(diary3);
		
		tx.commit();
		
		session.close();
		sf.close();
	}

}
