package com.sb.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.sb.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long>{

	

}
