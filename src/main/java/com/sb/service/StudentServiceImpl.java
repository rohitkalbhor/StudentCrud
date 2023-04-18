package com.sb.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sb.entity.Student;
import com.sb.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepository studentRepository;

	@Override
	public Student addStudent(Student student) {
		Student student1=studentRepository.save(student);
		return student1;
	}

	@Override
	public Student getStudentById(Long id) {
		Optional<Student> student= studentRepository.findById(id);
		return student.get();
		
	}

	@Override
	public Student updateStudent(Student student) {
		Student existingStudent=studentRepository.findById(student.getId()).get();
		existingStudent.setName(student.getName());
		existingStudent.setAddress(student.getAddress());
		existingStudent.setEmail(student.getEmail());
		existingStudent.setContact(student.getContact());
		
		Student updatedStudent=studentRepository.save(existingStudent);
		return updatedStudent;
	}

	@Override
	public List<Student> getAllStudent() {
		List<Student> list=studentRepository.findAll();
		return list;
	}

	@Override
	public void deleteStudentById(Long id) {
		studentRepository.deleteById(id);
		
	}

}
