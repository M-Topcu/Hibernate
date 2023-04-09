package com.hb12.caching;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch12 {

	public static void main(String[] args) {

		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student12.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
/*
		Student12 student1 = session.get(Student12.class,1L); // sorgu var
		
		System.out.println("Second get for id 1");
		Student12 student2 = session.get(Student12.class,1L);// sorgu yok
		// First caching ile 1 idli studenti hafizaya aldi
		
		session.clear();
		
		System.out.println("Third get for id 1");
		Student12 student3 = session.get(Student12.class,1L);// sorgu var
*/
		
		String hqlQuery1 = "FROM Student12 s WHERE s.id=1";
		Query<Student12> query1 = session.createQuery(hqlQuery1,Student12.class);
		query1.setCacheable(true); // true vermezsek query cache`lenebilir olmaz
		
		Student12 student1 = query1.uniqueResult();
		
		System.out.println(student1);
		
		System.out.println("-------------------------------------------------");
		
		String hqlQuery2 = "FROM Student12 s WHERE s.id=1";
		Query<Student12> query2 = session.createQuery(hqlQuery2,Student12.class);
		query2.setCacheable(true);
		
		Student12 student2 = query2.uniqueResult();
		
		System.out.println(student2); //2. kez query calismadi, seconddan aldi
		
		
		tx.commit();
		session.close();
/*		
 		//Second level cache`i gostermek icin yaptik
		Session session2 = sf.openSession();
		Transaction tx2 = session2.beginTransaction();
		
		System.out.println("Fourth get for id 1");
		Student12 student4 = session2.get(Student12.class,1L);

		tx2.commit();
		session2.close();
*/
		sf.close();
		

	}

}
