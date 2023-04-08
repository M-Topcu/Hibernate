package com.hb11.criteriaapi;

import java.util.List;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;
import org.hibernate.query.Query;

public class RunnerFetch11 {

	public static void main(String[] args) {
		
/*
 * 		CRUD (Create - Read - Update - Delete)
 * 		C-> session.save
 * 		R-> session.get, sql, hql (select)
 * 		U-> session.update - update querys
 * 		D-> session.delete, sql, hql
 */
		
		Configuration con = new
				Configuration().configure("hibernate.cfg.xml").
				addAnnotatedClass(Student11.class);
		
		SessionFactory sf = con.buildSessionFactory();
		
		Session session = sf.openSession();
		
		Transaction tx = session.beginTransaction();
		
//		Student11 student = session.get(Student11.class,1L); // 1L long oldugunu belirtiyor
//		student.setName("Updated " + student.getName());
//		session.update(student);
		
//		String hqlQuery1 = "UPDATE Student11 s SET s.name='Updated with HQL' WHERE s.id=11";
//		int numOfRec1 = session.createQuery(hqlQuery1).executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec1);
		
//		String hqlQuery2 = "FROM Student11 s WHERE s.mathGrade<50";
//		List<Student11> resultList1 = session.createQuery(hqlQuery2,Student11.class).getResultList();
//		for (Student11 students : resultList1) {
//			students.setMathGrade(50);
//			session.update(students);
//		}
		
//		int sMathGrade=80;
//		int lMathGrade=75;
//		
//		String hqlQuery3 = "UPDATE Student11 s SET s.mathGrade=:sMath WHERE s.mathGrade<:lMath";
//		
//		Query query = session.createQuery(hqlQuery3);
//		
//		query.setParameter("sMath",sMathGrade);
//		query.setParameter("lMath",lMathGrade);
//		
//		int numOfRec2 = query.executeUpdate();
//		System.out.println("Effected Row Count: " + numOfRec2);
		
//		int mathGrade = 90;
//		
//		String hqlQuery4 = "SELECT SUM(s.mathGrade) FROM Student11 s WHERE s.mathGrade>:grade";
//		Query query = session.createQuery(hqlQuery4);
//		query.setParameter("grade", mathGrade);
//		
//		Long sumMathGrade = (Long) query.uniqueResult();
//		System.out.println("Total Math Grade: " + sumMathGrade);
		
		CriteriaBuilder cb = session.getCriteriaBuilder();
		CriteriaQuery<Student11> criteriaQuery = cb.createQuery(Student11.class);
		Root<Student11> root = criteriaQuery.from(Student11.class);
//		criteriaQuery.select(root);
//		
//		Query<Student11> query1 = session.createQuery(criteriaQuery);
//		List<Student11> resultList2 = query1.getResultList();
//		
//		resultList2.forEach(s->System.out.println(s));
		

		
//		criteriaQuery.select(root).where(cb.equal(root.get("name"),"Student Name 6"));
//		
//		Query<Student11> query2 = session.createQuery(criteriaQuery);
//		List<Student11> resultList3 = query2.getResultList();
//		resultList3.forEach(s->System.out.println(s));
		
		
		
//		criteriaQuery.select(root).where(cb.greaterThan(root.get("mathGrade"),80));
//		Query<Student11> query3 = session.createQuery(criteriaQuery);
//		List<Student11> resultList4 = query3.getResultList();
//		resultList4.forEach(System.out::println);
		
		
		
//		criteriaQuery.select(root).where(cb.lessThan(root.get("mathGrade"),90));
//		Query<Student11> query4 = session.createQuery(criteriaQuery);
//		List<Student11> resultList5 = query4.getResultList();
//		resultList5.forEach(System.out::println);
		
		
		
		Predicate predicateForId = cb.equal(root.get("id"), 1L);
		Predicate predicateForMathGerade = cb.greaterThan(root.get("mathGerade"),75);
		
//		Predicate predicateStd = cb.or(predicateForId,predicateForMathGerade);
		Predicate predicateStd = cb.and(predicateForId,predicateForMathGerade);
		
		criteriaQuery.where(predicateStd);
		Query<Student11> query5 = session.createQuery(criteriaQuery);
		List<Student11> resultList6 = query5.getResultList();
		resultList6.forEach(System.out::println);
		
		
		tx.commit();
		session.close();
		sf.close();
		

	}

}
