 package com.hb02.embeddable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;


@Entity
@Table(name="t_student02")
public class Student02{

	@Id
	private int id;
	
	
	@Column(name="student_name",length = 100, nullable=false)
	private String name;
	
	
	//@Transient
	private int grade;
	
	@Embedded  // olmasa da calisir
	private Adress adress;
	
	
	
	public Adress getAdress() {
		return adress;
	}

	public void setAdress(Adress adress) {
		this.adress = adress;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

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
		return "Student02 [id=" + id + ", name=" + name + ", grade=" + grade + "adress=" + adress + "]";
	}
	
	
	
}
