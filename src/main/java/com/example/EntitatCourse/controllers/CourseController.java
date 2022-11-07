package com.example.EntitatCourse.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.EntitatCourse.entities.Course;
import com.example.EntitatCourse.entities.CourseMaterial;
import com.example.EntitatCourse.repositories.CourseMaterialRepository;
import com.example.EntitatCourse.repositories.CourseRepository;

@RestController
@RequestMapping("/prova")
public class CourseController {

	@Autowired
	CourseRepository courseRepository;
	@Autowired
	CourseMaterialRepository cmRep;
	
	@GetMapping("cursos/{id}")
	public ResponseEntity<?> getCurs(@PathVariable long id) {
		Course curs = courseRepository.findById(id).orElse(null);
		if(curs == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(curs);
		}
	}
	
	@GetMapping("cursos")
	public ResponseEntity<?> getCursos(){
		List<Course> cursos = courseRepository.findAll();
		
		if(cursos.isEmpty()){
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(cursos);
		}
	}
	
	@GetMapping("cursosmaterial/{id}")
	public ResponseEntity<?> getCursmaterial(@PathVariable long id) {
		CourseMaterial cursm = cmRep.findById(id).orElse(null);
		if(cursm == null) {
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(cursm);
		}
	}
	
	@GetMapping("cursosmaterial")
	public ResponseEntity<?> getCursosmaterial(){
		List<CourseMaterial> cursosm = cmRep.findAll();
		
		if(cursosm.isEmpty()){
			return ResponseEntity.notFound().build();
		}else {
			return ResponseEntity.ok(cursosm);
		}
	}
}
