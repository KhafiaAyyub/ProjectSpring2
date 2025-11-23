package com.example.springboot2.controller;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.entity.Student;
import com.example.springboot2.service.StudentService;

@RestController  // controller + response and Return JSON responses automatically
@RequestMapping("/api/students")  //All api starts with this
public class StudentController {

	private final StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	@PostMapping
	public Student createStudent(@RequestBody Student student) {
		return service.createStudent(student);
	}

	@GetMapping
	public List<Student> getAll() {
		return service.getAllStudents();
	}

	@GetMapping("/{id}")
	public Student getOne(@PathVariable Long id) {
		return service.getById(id);
	}

	@PutMapping("/{id}")
	public Student update(@PathVariable Long id, @RequestBody Student student) {
		return service.updateStudent(id, student);
	}

	@DeleteMapping("/{id}")
	public String delete(@PathVariable Long id) {
		service.deleteStudent(id);
		return "Deleted Successfully";
	}

}

//RequestBody → PUT JSON inside the body
//PathVariable → id in url used
//RequestEntity = request (headers + body + URL + method)