package com.sb.service;

import java.util.List;

import com.sb.entity.Student;

public interface StudentService {

	Student addStudent(Student student);

	Student getStudentById(Long id);

	Student updateStudent(Student student);

	List<Student> getAllStudent();

	void deleteStudentById(Long id);

}
