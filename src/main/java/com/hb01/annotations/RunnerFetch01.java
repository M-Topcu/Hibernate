package com.hb01.annotations;

import java.util.Arrays;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch01 {

	public static void main(String[] args) {
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").addAnnotatedClass(Student01.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
//		Student01 student1 = session.get(Student01.class, 1001);
//		Student01 student2 = session.get(Student01.class, 1002);
//		Student01 student3 = session.get(Student01.class, 1003);
		
//		System.out.println(student1);
//		System.out.println(student2);
//		System.out.println(student3);
		
//		SQL ORNEGI
//		String sqlQuery = "SELECT * FROM t_student01";
//		List<Object[]> resultList1 = session.createSQLQuery(sqlQuery).getResultList();
		
//		for (Object[] objects : resultList1) {
//			System.out.println(Arrays.toString(objects));
//		}
		
//		HQL ORNEGI 
//		String hqlQuery = "FROM Student01";
//		List<Student01> resultList2 = session.createQuery(hqlQuery,Student01.class).getResultList();
//		
//		for (Student01 student01 : resultList2) {
//			System.out.println((student01));
//		}		
		
		//Donecek kaydin tek bir kayit olduguna eminsek uniqueResult() kullanilabilir
		
		String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name='John Coffee'";
		Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
		
		System.out.println(Arrays.toString(uniqueResult1));
		
		
		
		tx.commit();
		
		session.close();
		
		sf.close();

	}

}
