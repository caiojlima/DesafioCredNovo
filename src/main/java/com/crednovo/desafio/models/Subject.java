package com.crednovo.desafio.models;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.*;

import com.fasterxml.jackson.annotation.JsonIgnore;

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
		joinColumns = @JoinColumn(name = "subject_id"),
		inverseJoinColumns = @JoinColumn(name = "teacher_id")
			)
	private List<Teacher> teachers = new ArrayList<>();
	
	@JsonIgnore
	@ManyToMany(mappedBy="subjects")
	private List<Student> students = new ArrayList<>();

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
