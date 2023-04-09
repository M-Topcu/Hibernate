package com.hb10.idgenerationstrategy;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Student10 extends BaseEntity{
	
	//Default olarak auto, HIBERNATE belirler
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	//Hibernate: create sequence hibernate_sequence start 1 increment 1 =>  auto
	// Tamamen veritabaninin id olusturma strategysine guvenir, Consol autputu da yok => IDENTITY
	//Hibernate: create sequence hibernate_sequence start 1 increment 1 => SEQUENCE
	//create table hibernate_sequences => tablo olusturup oraya koysu sirayi => TABLE
	
	//Sequence - Identity farki: birinde hibernate otomatik verir birinde database
	
//	@GeneratedValue(generator = "sequence", strategy = GenerationType.SEQUENCE)
//	@SequenceGenerator(name = "sequence", sequenceName = "student_seq", initialValue = 1000, allocationSize = 10)
//	private Long id;
	//Sequence`in ozelliklerini belirledik. allocationSize her defasinda hibernate`in db`den aldigi miktari
	//gosteriyor. Db allocationSize kadar artiriyor bir sonraki insert`de
	
	
//	@GeneratedValue(generator="UUID")
//	@GenericGenerator(name="UUID",strategy="uuid2")
//	private String id;
//	//8689bee0-9dba-485a-bb5a-aeea7a443815 =>bu sekilde id olusturuyor
//	//8-4-4-4-12*8=128 bitlik data
	
	
	
	@Column(name="student_name", nullable=false)
	private String name;
	
	private int grade;
	
	

	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public int getGrade() {
		return grade;
	}



	public void setGrade(int grade) {
		this.grade = grade;
	}

	
	@Override
	public String toString() {
		return "Student10 [id=" + getId() + ", name=" + name + ", grade=" + grade + "]";
	}

	




}
