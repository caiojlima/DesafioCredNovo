DROP DATABASE IF EXISTS schoolManager;

CREATE DATABASE schoolManager;

USE schoolManager;

CREATE TABLE student (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    age INT NOT NULL
) ENGINE=INNODB;

CREATE TABLE teacher (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL,
    age INT NOT NULL
) ENGINE=INNODB;

CREATE TABLE `subject` (
	id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(30) NOT NULL
) ENGINE=INNODB;

CREATE TABLE teacher_subject (
	teacher_id INT NOT NULL,
    subject_id INT NOT NULL,
    FOREIGN KEY (teacher_id) REFERENCES teacher(id),
    FOREIGN KEY (subject_id) REFERENCES `subject`(id)
) ENGINE=INNODB;

CREATE TABLE student_subject (
	student_id INT NOT NULL,
    subject_id INT NOT NULL,
    FOREIGN KEY (student_id) REFERENCES student(id),
    FOREIGN KEY (subject_id) REFERENCES `subject`(id)
) ENGINE=INNODB;