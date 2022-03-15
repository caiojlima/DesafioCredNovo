package com.crednovo.desafio.controllers;

import java.util.List;
import com.crednovo.desafio.models.Student;
import com.crednovo.desafio.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class StudentsController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping(value="/students")
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
	
	@GetMapping(value="/students/{id}")
	public Student getStudentById(@PathVariable long id) {
		Student student = studentRepository.findById(id).get();
		return student;
	}
	
	@PostMapping(value="/students")
	public Student saveStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return student;
	}
	
}
