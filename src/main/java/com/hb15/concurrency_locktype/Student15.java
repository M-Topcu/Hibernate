package com.hb15.concurrency_locktype;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Version;

@Entity
public class Student15 {

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
	@Column(name = "student_name",nullable = false)
    private String name;
    
    private int mathGrade;
    
    @Version
    private Long version;

    public Student15() {
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getmathGrade() {
        return this.mathGrade;
    }

    public void setmathGrade(int mathGrade) {
    	this.mathGrade=mathGrade;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String toString() {
        return "Student15 [id=" + id + ", name=" + name + ", mathGrade=" + mathGrade + "]";
    }
}
