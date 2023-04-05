package com.hb06.uni_onetomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch06 {

	public static void main(String[] args) {
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student06.class).addAnnotatedClass(Book06.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student06 student = session.get(Student06.class, 1001);
		
		System.out.println(student);
		
		System.out.println("------------------------------------------");
		
		//Bir ogrenci id`si ile kitaplari cekme
		String hqlQuery1 = "FROM Book06 WHERE id=101";
		Book06 book = session.createQuery(hqlQuery1,Book06.class).uniqueResult();
		
		System.out.println(book);
		
		System.out.println("------------------------------------------");
		
		//student`in her bir book`unun ismini yazdirin
		student.getBookList().forEach(b->System.out.println(b.getName()));
		
		System.out.println("------------------------------------------");
		
		
		tx.commit();
		session.close();
		sf.close();
		

	}

}
