package com.sb.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sb.entity.Student;
import com.sb.service.StudentService;

@RestController
@RequestMapping("/student")
public class StudentController {

	@Autowired
	private StudentService studentService;

	// build add student restApi

	@PostMapping("/save")
	public ResponseEntity<Student> createStudent(@RequestBody Student student) {
		Student student1 = studentService.addStudent(student);
		return new ResponseEntity<>(student1, HttpStatus.CREATED);
	}

	// build student get restApi

	@GetMapping("/{id}")
	public ResponseEntity<Student> getStudent(@PathVariable Long id) {
		Student student = studentService.getStudentById(id);
		return new ResponseEntity<>(student, HttpStatus.OK);
	}
	
	//build get all student restApi
	
	@GetMapping
	public ResponseEntity<List<Student>> getAllStudent(){
		List<Student> listStudents=studentService.getAllStudent();
		return new ResponseEntity<>(listStudents,HttpStatus.OK);
	}

	// build update student restApi

	@PutMapping("/{id}")
	public ResponseEntity<Student> updateSTudent(@PathVariable Long id, @RequestBody Student student) {
		student.setId(id);
		Student updatedStudent = studentService.updateStudent(student);
		return new ResponseEntity<>(updatedStudent, HttpStatus.OK);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable Long id){
		studentService.deleteStudentById(id);
		return new ResponseEntity<>("Student deleted successfully",HttpStatus.OK);
	}
	
	

}
