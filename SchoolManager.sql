DROP DATABASE IF EXISTS SchoolManager;

CREATE DATABASE SchoolManager;

USE SchoolManager;

CREATE TABLE alunos (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    age INT NOT NULL
) ENGINE=INNODB;

CREATE TABLE professores (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    age INT NOT NULL
) ENGINE=INNODB;

CREATE TABLE materias (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
) ENGINE=INNODB;

CREATE TABLE professor_materia (
	id_professor INT NOT NULL,
    id_materia INT NOT NULL,
    FOREIGN KEY (id_professor) REFERENCES professores(id),
    FOREIGN KEY (id_materia) REFERENCES materias(id)
) ENGINE=INNODB;

CREATE TABLE aluno_materia (
	id_aluno INT NOT NULL,
    id_materia INT NOT NULL,
    FOREIGN KEY (id_aluno) REFERENCES aluno(id),
    FOREIGN KEY (id_materia) REFERENCES materias(id)
) ENGINE=INNODB;