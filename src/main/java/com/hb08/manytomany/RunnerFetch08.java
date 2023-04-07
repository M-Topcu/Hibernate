package com.hb08.manytomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch08 {

	public static void main(String[] args) {
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student08.class).addAnnotatedClass(Book08.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
		Student08 student = session.get(Student08.class,1001);
		
		System.out.println(student.getBookList());
		
		System.out.println("--------------------------------------------------");
		
		Book08 book = session.get(Book08.class,101);
		
		System.out.println(book.getStudents());
		
		System.out.println("--------------------------------------------------");
		
		// Istege gore alanlar secilirken JOIN FETCH kullanilmadi
		String hqlQuery1 = "SELECT s.name, b.name FROM Student08 s JOIN s.bookList b";
		List<Object[]> resultList1 = session.createQuery(hqlQuery1).getResultList();
		resultList1.forEach(oa->System.out.println(Arrays.toString(oa)));
		
		System.out.println("--------------------------------------------------"); 
		
		
		
		
		tx.commit();
		session.close();
		sf.close();
		

	}

}
