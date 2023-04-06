package com.hb07.bi_onetomany;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch07 {

	public static void main(String[] args) {
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student07.class).addAnnotatedClass(Book07.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
//		Student07 student = session.get(Student07.class, 1001);
//		
//		student.getBookList().forEach(System.out::println); // lamdanin daha da kisasi
//		
//		System.out.println("------------------------------------------------");
//		
//		//ogrencinin bilgilerini getirelim
//		String sqlQuery1= "SELECT s.student_name, b.name FROM Student07 s INNER JOIN book07 b ON s.id=b.student_id";
//		List<Object[]> resultList1 = session.createSQLQuery(sqlQuery1).getResultList();
//		
//		resultList1.forEach(r->System.out.println(Arrays.toString(r)));
//		
//		System.out.println("------------------------------------------------");
//		
//		//HQL ile
//		String hqlQuery1 = "Select s.name, b.name FROM Student07 s INNER JOIN FETCH Book07 b ON s.id=b.student";
//		List<Object[]> resultList2 = session.createQuery(hqlQuery1).getResultList();
//		resultList2.forEach(r->System.out.println(Arrays.toString(r)));
		
//		String sqlQuery2 = "DELETE FROM book07";
//		int numOfRec = session.createSQLQuery(sqlQuery2).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec);
		
//		String sqlQuery3 = "DELETE FROM student07";
//		int numOfRec2 = session.createSQLQuery(sqlQuery3).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec2);
		
		
//		String hqlQuery3 = "DELETE FROM Book07";
//		int numOfRec4 = session.createQuery(hqlQuery3).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec4);
//		
//		String hqlQuery2 = "DELETE FROM Student07";
//		int numOfRec3 = session.createQuery(hqlQuery2).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec3);
//		
		
		
		tx.commit();
		session.close();
		sf.close();
		

	}

}
