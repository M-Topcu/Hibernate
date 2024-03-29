package com.hb05.manytoone;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch05 {

	public static void main(String[] args) {
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student05.class).addAnnotatedClass(University.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student05 student = session.get(Student05.class, 1001);
		
		System.out.println(student.getUniversite()); // University [id=1, name=TPE Tech]
		
		System.out.println("-----------------------------------------------------");
		
		// University id`si 1 olan butun ogrencileri getir
		String hqlQuery1 = "FROM Student05 s where s.university.id=1";
		
		List<Student05> resultList1 = session.createQuery(hqlQuery1,Student05.class).getResultList();
		
		resultList1.forEach(s->System.out.println(s));
		
		
		tx.commit();
		session.close();
		sf.close();
		

	}

}
