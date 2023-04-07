package com.hb09.fetchtypes;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerFetch09 {

	public static void main(String[] args) {
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student09.class).addAnnotatedClass(Book09.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
//		Student09 student1 = session.get(Student09.class,1001);
//		session.delete(student1); // kitaplar da gitti ogrenci gidince

		Student09 student2 = session.get(Student09.class, 1002);

		// EAGER
/*		Hibernate: 
    select
        student09x0_.id as id1_1_0_,
        student09x0_.grade as grade2_1_0_,
        student09x0_.student_name as student_3_1_0_,
        booklist1_.student_id as student_3_0_1_,
        booklist1_.id as id1_0_1_,
        booklist1_.id as id1_0_2_,
        booklist1_.name as name2_0_2_,
        booklist1_.student_id as student_3_0_2_ 
    from
        Student09 student09x0_ 
    left outer join
        Book09 booklist1_ 
            on student09x0_.id=booklist1_.student_id 
    where
        student09x0_.id=?
*/
		
		//LAZY
/*Hibernate: 
    select
        student09x0_.id as id1_1_0_,
        student09x0_.grade as grade2_1_0_,
        student09x0_.student_name as student_3_1_0_ 
    from
        Student09 student09x0_ 
    where
        student09x0_.id=?
*/
		
		// eagerdan lazy ye dondurduk tekrar ve foreach yaptik
		
		for (Book09 book : student2.getBookList()) {
			System.out.println(book);
		}
		// query calisti
		
		List<Book09> bookList = student2.getBookList();
		//Query calismadi cunku lazy, tablodaki bilgi lazim olunca calisir sadece
		
		System.out.println(bookList.size());
		// Query calisti
		
		tx.commit();
		session.close();
		
		/*lazy
		 * Fetch Type lazy oldugu icin session close edilince LazyInitializaitonException throw eder
		for (Book09 book : student2.getBookList()) {
			System.out.println(book);
		}
		*/
		
		//eager
		for (Book09 book : student2.getBookList()) {
			System.out.println(book);
		}
		// calisti, student objesinin memorysinde duruyor
		
		
		sf.close();
		

	}

}
