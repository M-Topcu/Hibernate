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
//		int numOfRec3 = session.createQuery(hqlQuery3).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec3);
//		
//		String hqlQuery2 = "DELETE FROM Student07";
//		int numOfRec4 = session.createQuery(hqlQuery2).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec4);

		//Kitap ismine gore kitap silmeyi saglayan bir HQL query yazalim
//		String hqlQuery3 = "DELETE FROM Book07 b WHERE b.name='Johns`s Art Book'";// `` seklinde yaptik
//																			//cunku string sanirdi aksi takdirde
//		int numOfRec5 = session.createQuery(hqlQuery3).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec5);
		
//		String hqlQuery4 = "DELETE FROM Book07 WHERE student=1001";
//		int numOfRec6 = session.createQuery(hqlQuery4).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec6);
		
		// Herhangi bir kitaba sahip olmayan bir ogrenci silme
//		String hqlQuery5 = "DELETE FROM Student07 WHERE id=1001";
//		int numOfRec7 = session.createQuery(hqlQuery5).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec7);
		
//		//Kitaba sahip ogrenciyi silme denemesi
//		String hqlQuery6 = "DELETE FROM Student07 WHERE id=1003";
//		int numOfRec8 = session.createQuery(hqlQuery6).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec8); // exc verdi, foregn keyi var
		// ya once kitabi silcez, ya da Student07 classinda mappedBy = orphanRemoval=true eklicez
		
//		// orphanRemoval yaptiktan sonra hibernate methodu ile silme
//		Student07 student = session.get(Student07.class,1003);
//		session.delete(student);
		
//		Student07 student = session.get(Student07.class,1001);
//		student.getBookList().set(0, null); // kitaplari null oldu, hibernate de tablodan otomatik sildi
		
		
		String hqlQuery7 = "SELECT s FROM Student07 s JOIN Book07 b ON s.id=b.student";
		session.createQuery(hqlQuery7).getResultList();
		
		// Yukaridaki ile ayni sey
		String hqlQuery8 = "SELECT s FROM Student07 s JOIN s.bookList";
		session.createQuery(hqlQuery8).getResultList();
		
		
		
		tx.commit();
		session.close();
		sf.close();
		

	}

}
