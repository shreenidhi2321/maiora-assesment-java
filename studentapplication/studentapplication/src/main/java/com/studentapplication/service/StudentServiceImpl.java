package com.studentapplication.service;

import java.time.LocalDate;
import java.time.Period;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.studentapplication.entity.Student;
import com.studentapplication.repository.StudentRepo;

@Service
public class StudentServiceImpl implements StudentService {
	
	@Autowired
	private StudentRepo studentrepo;

	

	@Override
	public Student createStudent(Student student) {
		student.setAge(null);
		return studentrepo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		
		return studentrepo.findAll();
				
	}

	@Override
	public Student calculateAndUpdateAge(Long studentId) {
		Student student=studentrepo.findById(studentId)
				.orElseThrow(()->  new RuntimeException("Student not found"));
		int age =Period.between(student.getDob(), LocalDate.now()).getYears();
		student.setAge(age);
		return studentrepo.save(student);
	}
	
	@Override
	public List<Student> getStudentsByAgeBetween(Integer minAge, Integer maxAge) {
		
		return studentrepo.findByAgeBetween(minAge, maxAge);
	}

}
