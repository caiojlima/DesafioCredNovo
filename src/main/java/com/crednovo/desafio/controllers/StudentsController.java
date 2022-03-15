package com.crednovo.desafio.controllers;

import java.util.List;

import com.crednovo.desafio.models.Student;
import com.crednovo.desafio.repository.StudentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class StudentsController {
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping(value="/students")
	public List<Student> getStudents() {
		return studentRepository.findAll();
	}
}
