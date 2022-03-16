package com.crednovo.desafio.controllers;

import java.util.ArrayList;
import java.util.List;
import com.crednovo.desafio.models.Student;
import com.crednovo.desafio.models.Subject;
import com.crednovo.desafio.repository.StudentRepository;
import com.crednovo.desafio.repository.SubjectRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class StudentsController {
	
	@Autowired
	private StudentRepository studentRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
	
	@GetMapping(value="/students")
	public ResponseEntity<?> getStudents() {
		return new ResponseEntity<>(studentRepository.findAll(), HttpStatus.OK);
	}
	
	@GetMapping(value="/students/{id}")
	public Student getStudentById(@PathVariable long id) {
		Student student = studentRepository.findById(id).get();
		return student;
	}
	
	@PostMapping(value="/students")
	public ResponseEntity<?> saveStudent(@RequestBody Student student) {
		studentRepository.save(student);
		return new ResponseEntity<>(student, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/{subjectId}/student/{studentId}")
	public ResponseEntity<?> registerStudent(@PathVariable long subjectId, @PathVariable long studentId) {
		Student student = studentRepository.findById(studentId).get();
		Subject subject = subjectRepository.findById(subjectId).get();
		student.enrollSubjects(subject);
		return new ResponseEntity<>(studentRepository.save(student), HttpStatus.CREATED);
	}
}
