package com.hb08.manytomany;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Book08 {
	
	@Id
	private int id;
	
	private String name;
	
	
	// Asagidaki iki satir cift tarafli many-to-many icin gerekli. Tek taraflida komple yazmiyoruz bu 2 satiri
	@ManyToMany(mappedBy = "bookList")
	private List<Student08> students = new ArrayList<Student08>();
	
	
	

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

	public List<Student08> getStudents() {
		return students;
	}
	
	
	
	public void setStudents(List<Student08> students) {
		this.students = students;
	}


	@Override
	public String toString() {
		return "Book08 [id=" + id + ", name=" + name + "]";
	}
	
}
