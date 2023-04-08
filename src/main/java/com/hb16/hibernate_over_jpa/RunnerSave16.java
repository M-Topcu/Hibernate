package com.hb16.hibernate_over_jpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class RunnerSave16 {
	
	public static void main(String[] args) {
		
		Student16 student1 = new Student16();
        student1.setName("John Coffee");
        student1.setmathGrade(100);
        
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("studentunit");
        EntityManager em = emf.createEntityManager();
        
        em.getTransaction().begin();
        
        em.persist(student1); //save ile ayni
        
        
        em.getTransaction().commit();
        em.close();
        emf.close();
        
	}
}
