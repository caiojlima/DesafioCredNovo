package com.crednovo.desafio.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long subjectId;
	
	@Column
	private String name;
	
	@ManyToMany
	@JoinTable(
		name="teacher_subject",
		uniqueConstraints = @UniqueConstraint(columnNames = { "teacherId", "subjectId" }),
		joinColumns = @JoinColumn(name = "subjectId"),
		inverseJoinColumns = @JoinColumn(name = "teacherId")
			)
	private List<Teacher> teachers;
	
	@ManyToMany
	@JoinTable(
		name="student_subject",
		uniqueConstraints = @UniqueConstraint(columnNames = { "studentId", "subjectId" }),
		joinColumns = @JoinColumn(name = "subjectId"),
		inverseJoinColumns = @JoinColumn(name = "studentId")
			)
	private List<Student> students;
	
	public long getId() {
		return subjectId;
	}
	
	public void setId(long subjectId) {
		this.subjectId = subjectId;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
}
