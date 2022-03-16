package com.crednovo.desafio.models;

import java.util.HashSet;
import java.util.Set;
import javax.persistence.*;

@Entity
public class Teacher {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	
	@Column
	private String name;
	
	@Column
	private String age;
	
	@ManyToMany
	@JoinTable(
		name="teacher_subject",
		joinColumns = @JoinColumn(name = "teacher_id"),
		inverseJoinColumns = @JoinColumn(name = "subject_id")
	)
	private Set<Subject> subjects = new HashSet<Subject>();

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

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public Set<Subject> getSubjects() {
		return subjects;
	}

	public void setSubjects(Set<Subject> subjects) {
		this.subjects = subjects;
	}
	
	public void enrollSubjects(Subject subject) {
		subjects.add(subject);
	}
	
	public void deleteSubjects(Subject subject) {
		subjects.remove(subject);
	}
	
}
