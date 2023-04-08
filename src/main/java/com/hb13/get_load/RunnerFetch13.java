package com.hb13.get_load;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch13 {

	public static void main(String[] args) {

		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student13.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();

/* veri varsa:

		System.out.println("Start to execute get method");
		Student13 student1 = session.get(Student13.class,1L);
		System.out.println("Finish to execute get method");
		System.out.println("Student ID: " + student1.getId());
		System.out.println("Student Get Name: " + student1.getName());
		
		System.out.println("-------------------------------------------------");
		
		System.out.println("Start to execute load method");
		Student13 student2 = session.load(Student13.class,2L);
		System.out.println("Finish to execute load method");
		System.out.println("Student ID: " + student2.getId());
		System.out.println("Student Load Name: " + student2.getName());
		//isim gerekli olana kadar query calismadi
*/
		
/*
 		//DB`de olmayan id`ler ile get-load methodlarinin davranisini gorme
 		System.out.println("Start to execute get method");
		Student13 student1 = session.get(Student13.class,5L);
		
		if(student1!=null) {
			System.out.println("Finish to execute get method");
			System.out.println("Student ID: " + student1.getId());
			System.out.println("Student Get Name: " + student1.getName());
		}
		
		System.out.println("-------------------------------------------------");
		
		System.out.println("Start to execute load method");
		Student13 student2 = session.load(Student13.class,10L);
		
		if(student2!=null) {
			System.out.println("Finish to execute load method");
			System.out.println("Student ID: " + student2.getId());
			System.out.println("Student Load Name: " + student2.getName());
		}
*/
		
		
		tx.commit();
		session.close();
		sf.close();
		

	}

}
