package com.crednovo.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crednovo.desafio.models.Teacher;

public interface TeacherRepository extends JpaRepository <Teacher, Integer> {

}
	