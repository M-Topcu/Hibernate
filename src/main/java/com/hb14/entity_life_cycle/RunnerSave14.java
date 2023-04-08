package com.hb14.entity_life_cycle;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class RunnerSave14 {
	public RunnerSave14() {
    }
	
	public static void main(String[] args) {
		
		Student14 student1 = new Student14();
        student1.setName("John Coffee");
        student1.setmathGrade(10);
        
        Student14 student2 = new Student14();
        student2.setName("James Bond");
        student2.setmathGrade(11);
        
        Student14 student3 = new Student14();
        student3.setName("Tony Stark");
        student3.setmathGrade(9);
        
        Configuration con = (new Configuration()).configure("hibernate.cfg.xml").addAnnotatedClass(Student14.class);
        SessionFactory sf = con.buildSessionFactory();
        Session session = sf.openSession();
        
        Transaction tx = session.beginTransaction();
        
        session.save(student1);
        //save edilene kadar tranciebt, edililnce persistence state
        
        student1.setName("Updated in persistent state");
        
        //detached
        session.evict(student1);
        
        //detached oldugu icin hemen calismaz, gozu ustunde degildir persistance`in
        student1.setName("Updated in detached state");
        // detached olunca db`e gondermedigi icin save edene kadar, John Coffee olarak ekliyor
        
        session.merge(student1); // tekrar persistence
        //session.update(student1) de ayni islevi gorur
        
        tx.commit();
        session.close();
        sf.close();
	}
}
