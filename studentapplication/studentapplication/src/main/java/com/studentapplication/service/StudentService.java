package com.studentapplication.service;

import java.util.List;

import com.studentapplication.entity.Student;

public interface StudentService {
	
	  public Student createStudent(Student student);
	  public List<Student> getAllStudents();
	  public Student calculateAndUpdateAge(Long studentId);
	  public List<Student> getStudentsByAgeBetween(Integer minAge, Integer maxAge);

}
