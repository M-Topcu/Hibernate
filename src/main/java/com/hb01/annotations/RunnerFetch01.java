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
		
//		Donecek kaydin tek bir kayit olduguna eminsek uniqueResult() kullanilabilir
		String sqlQuery2 = "SELECT * FROM t_student01 WHERE student_name='John Coffee'";
		Object[] uniqueResult1 = (Object[]) session.createSQLQuery(sqlQuery2).uniqueResult();
		
		System.out.println(Arrays.toString(uniqueResult1));
		System.out.println(uniqueResult1[0]+" : "+uniqueResult1[1]+" : "+ uniqueResult1[2]);
		
//		HQL ile unique result sorgulama
		String hqlQuery2= "From Student01 where name='John Coffee'";
		Student01 uniqueResult2= session.createQuery(hqlQuery2,Student01.class).uniqueResult();
		System.out.println(uniqueResult2); // Student01 classinda toString methodu yapmistik
		
		//HQL ile Alias kullanma ornegi
		String hqlQuery3 = "From Student01 std where std.name='John Coffee'"; //std ogrenci objesinin ismi, std.name de isim
		Student01 uniqueResult3= session.createQuery(hqlQuery3,Student01.class).uniqueResult();
		System.out.println(uniqueResult3);
		
		// HQL ile belirli degiskenleri alma
		// grade degeri 10 olan ogrencileri getir
		String hqlQuery4 = "SELECT  s.id, s.name FROM Student01 s WHERE s.grade=10";
		// Select * ile baslayan sorgularda HQL ile direkt Fromdan baslayarak yazabiliriz.
		//Ancak spesifik kolon, daha dogrusu veriable cagiracaksak select gerekli
		
		List<Object[]> resultList3 = session.createQuery(hqlQuery4).getResultList();
		
		for (Object[] objects : resultList3) {
			System.out.println(Arrays.toString(objects));
		}
		
		
		String hqlQuery5 = "From Student01 s order by s.id desc";
		List<Student01> resultList4 = session.createQuery(hqlQuery5,Student01.class).getResultList();
		
		for (Student01 st01 : resultList4) {
			System.out.println(st01);
		}
		
		
		tx.commit();
		
		session.close();
		
		sf.close();

	}

}
