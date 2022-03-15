package com.crednovo.desafio.controllers;

import java.util.List;
import com.crednovo.desafio.models.Teacher;
import com.crednovo.desafio.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TeachersController {
	
	@Autowired
	private TeacherRepository teacherRepository;
		
	@GetMapping(value="/teachers")
	public List<Teacher> getTeachers() {
		return teacherRepository.findAll();
	}
	
	@GetMapping(value="/teachers/{id}")
	public Teacher getTeacherById(@PathVariable long id) {
		return teacherRepository.findById(id).get();
	}
	
	@PostMapping(value="/teachers")
	public ResponseEntity<?> saveTeacher(@RequestBody Teacher teacher) {
		teacherRepository.save(teacher);
		return new ResponseEntity<>(teacher, HttpStatus.CREATED);
	}

}
