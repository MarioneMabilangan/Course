package com.example.EntitatCourse.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.example.EntitatCourse.entities.Student;

public interface StudentRepository extends CrudRepository<Student, Long>{
	public List<Student> findAll();
}
