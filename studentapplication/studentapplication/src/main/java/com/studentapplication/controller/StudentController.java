package com.studentapplication.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.studentapplication.entity.Student;
import com.studentapplication.service.StudentService;

@RestController
@RequestMapping("/api/students")
public class StudentController {
	@Autowired
	StudentService studenservice;
	
	@GetMapping("/ping")
	public ResponseEntity<String> ping() {
	    return ResponseEntity.ok("pong");
	}
	
	@PostMapping("/createStudent")
	public ResponseEntity<Student> createStudent(@RequestBody Student student){
		
		return ResponseEntity.ok(studenservice.createStudent(student));
	}
	
	@GetMapping("/getAllStudents")
	public ResponseEntity<List<Student>> getAllStudents(){
		return ResponseEntity.ok(studenservice.getAllStudents());
	}
	
	@PutMapping("/{id}/calculateAge")
	public ResponseEntity<Student> calculateAge(@PathVariable Long id){
		return ResponseEntity.ok(studenservice.calculateAndUpdateAge(id));
		
	}
	
	@GetMapping("/agerange")
	public ResponseEntity<List<Student>> getStudentsByAgeRange(@RequestParam int minAge, @RequestParam int maxAge){
		return ResponseEntity.ok(studenservice.getStudentsByAgeBetween(minAge, maxAge));
		
	}
	

}
