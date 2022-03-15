package com.crednovo.desafio.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Student {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long studentId;
	
	@Column
	private String name;
	
	@Column
	private String age;
	
	@ManyToMany
	@JoinTable(
		name="student_subject",
		uniqueConstraints = @UniqueConstraint(columnNames = { "studentId", "subjectId" }),
		joinColumns = @JoinColumn(name = "studentId"),
		inverseJoinColumns = @JoinColumn(name = "subjectId")
			)
	private List<Subject> subjects;
	
	public long getId() {
		return studentId;
	}
	
	public void setId(long studentId) {
		this.studentId = studentId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getAge() {
		return age;
	}
	
	public void setAge(String age) {
		this.age = age;
	}
	
}
