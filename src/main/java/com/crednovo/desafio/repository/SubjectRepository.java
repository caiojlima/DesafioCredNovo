package com.crednovo.desafio.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.crednovo.desafio.models.Subject;

public interface SubjectRepository extends JpaRepository <Subject, Integer> {

}
