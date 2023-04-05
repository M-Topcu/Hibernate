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
		System.out.println("=======================================");
		System.out.println(student.getDiary());
		System.out.println("=======================================");
		System.out.println(diary);
		System.out.println("=======================================");
		
		
		String hqlQuery1 = "SELECT s.name, d.name FROM Student04 s INNER JOIN FETCH Diary2 d on s.id=d.student";
		// Fetch yazinca diary de getiriyor
		List<Object[]> resultList1 = session.createQuery(hqlQuery1).getResultList();
		
		for (Object[] objects : resultList1) {
			System.out.println(Arrays.toString(objects));
		}
		
		System.out.println("=======================================");
		
		//lambda ile
		resultList1.forEach(oa->{
			System.out.println(Arrays.toString(oa));
		});
		
		System.out.println("=======================================");
		
		//Left Join
		String hqlQuery2 = "SELECT s.name, d.name FROM Student04 s LEFT JOIN FETCH Diary2 d on s.id=d.student";
		List<Object[]> resultList2 = session.createQuery(hqlQuery2).getResultList();
		resultList2.forEach(oa->{System.out.println(Arrays.toString(oa));});
		
		System.out.println("=======================================");
		
		// RIGHT JOIN
		String hqlQuery3 = "SELECT s.name, d.name FROM Student04 s RIGHT JOIN FETCH Diary2 d on s.id=d.student";
		List<Object[]> resultList3 = session.createQuery(hqlQuery3).getResultList();
		resultList3.forEach(oa->{System.out.println(Arrays.toString(oa));});
		
		System.out.println("=======================================");
		
		//FULL JOIN
		String hqlQuery4 = "SELECT s.name, d.name FROM Student04 s FULL JOIN FETCH Diary2 d on s.id=d.student";
		List<Object[]> resultList4 = session.createQuery(hqlQuery4).getResultList();
		resultList4.forEach(oa->{System.out.println(Arrays.toString(oa));});
		
		System.out.println("=======================================");
		
		//HQL ile bu sekilde de olur,
		String hqlQuery5 = "FROM Student04 s INNER JOIN FETCH s.diary";
		List<Student04> resultList5 = session.createQuery(hqlQuery5,Student04.class).getResultList();
		resultList5.forEach(st->{System.out.println(st);});
		
		System.out.println("=======================================");
		
		//Diary classtan cagirarak da ayni seyi yapabiliriz
		String hqlQuery6 = "FROM Diary2 d INNER JOIN FETCH d.student";
		List<Diary2> resultList6 = session.createQuery(hqlQuery6,Diary2.class).getResultList();
		resultList6.forEach(d->{System.out.println(d);});
		
		
		tx.commit();
		
		session.close();
		
		sf.close();

	}

}