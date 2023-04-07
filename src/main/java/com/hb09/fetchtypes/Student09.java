package com.hb09.fetchtypes;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Student09 {
	
	@Id
	private int id;
	
	@Column(name="student_name", nullable=false)
	private String name;
	
	private int grade;
	
	// child tablelarda da yapilan degisiklerin uygulanmasini saglar cascade
	//FetchType.EAGER - FetchType.LAZY veri yukleme tipleri
	@OneToMany(mappedBy="student", orphanRemoval=true, cascade = CascadeType.ALL,fetch=FetchType.EAGER)
	private List<Book09> bookList = new ArrayList<>();
	
	

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

	public List<Book09> getBookList() {
		return bookList;
	}



	@Override
	public String toString() {
		return "Student09 [id=" + id + ", name=" + name + ", grade=" + grade + ", bookList=" + bookList + "]";
	}

	




}
