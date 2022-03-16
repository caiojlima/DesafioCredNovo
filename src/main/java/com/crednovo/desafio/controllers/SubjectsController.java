package com.crednovo.desafio.controllers;

import com.crednovo.desafio.models.Student;
import com.crednovo.desafio.models.Subject;
import com.crednovo.desafio.repository.StudentRepository;
import com.crednovo.desafio.repository.SubjectRepository;
import java.util.List;

import javax.validation.Valid;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@RestController
public class SubjectsController {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@Autowired
	private StudentRepository studentRepository;
	
	@GetMapping(value="/subjects")
	public List<Subject> getSubjects() {
		return subjectRepository.findAll();
	}
	
	@PostMapping(value="/subjects")
	@ResponseBody
	public ResponseEntity<?> saveSubject(@RequestBody @Valid Subject subject) {
		subjectRepository.save(subject);
		return new ResponseEntity<>(subject, HttpStatus.CREATED);
	}

}
