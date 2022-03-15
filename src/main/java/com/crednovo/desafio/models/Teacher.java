package com.crednovo.desafio.models;

import java.util.List;
import javax.persistence.*;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long teacherId;
	
	@Column
	private String name;
	
	@Column
	private String age;
	
	@ManyToMany
	@JoinTable(
		name="teacher_subject",
		uniqueConstraints = @UniqueConstraint(columnNames = { "teacherId", "subjectId" }),
		joinColumns = @JoinColumn(name = "teacherId"),
		inverseJoinColumns = @JoinColumn(name = "subjectId")
			)
	private List<Subject> subjects;
	
	public long getId() {
		return teacherId;
	}
	
	public void setId(long teacherId) {
		this.teacherId = teacherId;
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
