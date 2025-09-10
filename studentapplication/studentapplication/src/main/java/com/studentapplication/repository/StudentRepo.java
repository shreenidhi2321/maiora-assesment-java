package com.studentapplication.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.studentapplication.entity.Student;

@Repository
public interface StudentRepo extends JpaRepository<Student, Long> {
	  
	
	 
	  public List<Student> findByAgeBetween(Integer minAge, Integer maxAge);

}
