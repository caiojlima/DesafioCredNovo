package com.crednovo.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crednovo.desafio.models.Student;

public interface StudentRepository extends JpaRepository <Student, Integer> {

}