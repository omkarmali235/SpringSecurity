package com.omkar.SpringSecurity.controller;


import java.util.ArrayList;
import java.util.List;

import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.omkar.SpringSecurity.model.Student;

import jakarta.servlet.http.HttpServletRequest;

@RestController
public class StudentController {

	private List<Student> students = new ArrayList<>(List.of(
			new Student(1,"Omkar",60),
			new Student(2,"Rucha",65)
	));
	
	@GetMapping("/students")
	public List<Student> getStudents(){
		return students;
	}
	
	@PostMapping("/students")
	public Student addStudents(@RequestBody Student student) {
		students.add(student);
		return student;
	}
	
	@GetMapping("/csrf")
	public CsrfToken getCsrfToken(HttpServletRequest req) {
		return (CsrfToken)req.getAttribute("_csrf");
	}
}
