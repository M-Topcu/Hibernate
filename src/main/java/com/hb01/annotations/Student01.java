 package com.hb01.annotations;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

//Bu annotationu koydugumuz class veritabaninda bir tabloya karsilik gelir
@Entity
//Eger olusacak tablo ismi degistirilmek istenirse name attribute ile bir tablo ismi verilir
@Table(name="t_student01")
public class Student01 {

	//primary key olusmasini sagliyor
	@Id
	//Column(name="std_id) ile isim verilebilir
	private int id;
	
	//length default=255, nullable default=true, unique default=false
	// column annotationu zorunlu degildir ama customize etmek icin gerekli
	@Column(name="student_name",length = 100, nullable=false,unique = false)
	private String name;
	
	//veritabani tablosunda grade adinda bir kolon olusturulmaz
	//@Transient
	private int grade;
	
	// Large Object ile buyuk boyutlu datalar tutulabilir
	// @Lob
	// private byte[] image;

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
		return "Student01 [id=" + id + ", name=" + name + ", grade=" + grade + "]";
	}
	
	
	
}
