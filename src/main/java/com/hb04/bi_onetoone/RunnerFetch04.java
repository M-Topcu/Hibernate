package com.hb04.bi_onetoone;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch04 {

	public static void main(String[] args) {
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student04.class).addAnnotatedClass(Diary2.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		// Student fetch ediyoruz bir id ile
		Student04 student = session.get(Student04.class, 1001);
		
		// Diary fetch ediyoruz
		Diary2 diary = session.get(Diary2.class, 101);
		
		System.out.println(student);
		System.out.println("==================================");
		System.out.println(student.getDiary());
		System.out.println("==================================");
		System.out.println(diary);
		System.out.println("==================================");
		
		
		String hqlQuery = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary2 d on s.id=d.student";
		// Fetch yazinca diary de getiriyor
		List<Object[]> resultList1 = session.createQuery(hqlQuery).getResultList();
		
		for (Object[] objects : resultList1) {
			System.out.println(Arrays.toString(objects));
		}
		
		System.out.println("==================================");
		
		//lambda ile
		resultList1.forEach(oa->{
			System.out.println(Arrays.toString(oa));
		});
		
		
		tx.commit();
		
		session.close();
		
		sf.close();

	}

}