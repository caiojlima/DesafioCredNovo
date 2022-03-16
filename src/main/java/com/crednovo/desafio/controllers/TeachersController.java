package com.crednovo.desafio.controllers;

import java.util.List;

import com.crednovo.desafio.models.Student;
import com.crednovo.desafio.models.Subject;
import com.crednovo.desafio.models.Teacher;
import com.crednovo.desafio.repository.SubjectRepository;
import com.crednovo.desafio.repository.TeacherRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PathVariable;

@RestController
public class TeachersController {
	
	@Autowired
	private TeacherRepository teacherRepository;
	
	@Autowired
	private SubjectRepository subjectRepository;
		
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
	
	@PutMapping(value="subject/{subjectId}/teacher/{teacherId}")
	public ResponseEntity<?> registerTeacher(@PathVariable long subjectId, @PathVariable long teacherId) {
		Teacher teacher = teacherRepository.findById(teacherId).get();
		Subject subject = subjectRepository.findById(subjectId).get();
		teacher.enrollSubjects(subject);
		return new ResponseEntity<>(teacherRepository.save(teacher), HttpStatus.OK);
	}
	
	@DeleteMapping(value="subject/{subjectId}/teacher/{teacherId}")
	public ResponseEntity<?> deleteSubject(@PathVariable long subjectId, @PathVariable long teacherId) {
		Teacher teacher = teacherRepository.findById(teacherId).get();
		Subject subject = subjectRepository.findById(subjectId).get();
		teacher.deleteSubjects(subject);
		teacherRepository.save(teacher);
		return new ResponseEntity<>(HttpStatus.NO_CONTENT);
	}
}
