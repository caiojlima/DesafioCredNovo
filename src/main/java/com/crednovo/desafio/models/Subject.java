package com.crednovo.desafio.models;

import java.util.List;

import javax.persistence.*;

@Entity
public class Subject {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
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
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public List<Teacher> getTeachers() {
		return teachers;
	}

	public void setTeachers(List<Teacher> teachers) {
		this.teachers = teachers;
	}

	public List<Student> getStudents() {
		return students;
	}

	public void setStudents(List<Student> students) {
		this.students = students;
	}
	
}
