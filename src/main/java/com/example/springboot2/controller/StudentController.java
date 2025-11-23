package com.example.springboot2.controller;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.springboot2.entity.Student;
import com.example.springboot2.service.StudentService;

import jakarta.validation.Valid;

@RestController  // controller + response and Return JSON responses automatically
@RequestMapping("/api/students")  //All api starts with this
public class StudentController {

	private final StudentService service;

	public StudentController(StudentService service) {
		this.service = service;
	}

	//	@Valid -> It triggers validation before calling service layer.
	@PostMapping
	public Student createStudent(@Valid @RequestBody Student student) {
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

	//Spring Data JPA
	@GetMapping("/search/name/{name}")
	public List<Student> findByName(@PathVariable String name) {
		return service.findByName(name);
	}

	@GetMapping("/search/email/{email}")
	public Student findByEmail(@PathVariable String email) {
		return service.findByEmail(email);
	}

	@GetMapping("/search/age/{age}")
	public List<Student> findByAgeGreater(@PathVariable int age) {
		return service.findByAgeGreaterThan(age);
	}

	@GetMapping("/search/prefix/{k}")
	public List<Student> findByKeyword(@PathVariable String k) {
		return service.findByNameContaining(k);
	}


	//JPQL

	//GET http://localhost:8080/api/students/jpql/exact/khafia
	@GetMapping("/jpql/exact/{name}")
	public List<Student> exactName(@PathVariable String name) {
		return service.searchByExactName(name);
	}

	@GetMapping("/jpql/like/{keyword}")
	public List<Student> likeSearch(@PathVariable String keyword) {
		return service.searchByNameLike(keyword);
	}

	@GetMapping("/jpql/sort")
	public List<Student> sortAsc() {
		return service.sortByNameAsc();
	}
	//GET http://localhost:8080/api/students/jpql/count
	@GetMapping("/jpql/count")
	public Long countStudents() {
		return service.totalStudentsCount();
	}


	//Pagination
	
	@GetMapping("/search")
	public Page<Student> search(
	        @RequestParam String keyword,
	        @RequestParam int page,
	        @RequestParam int size,
	        @RequestParam String sortBy) {

	    return service.searchStudents(keyword, page, size, sortBy);
	}

//to test - http://localhost:8080/api/students/search?keyword=a&page=0&size=5&sortBy=name

//select * from student where name like '%a%' order by name as limit 5 offset 0;






}

//RequestBody → PUT JSON inside the body
//PathVariable → id in url used
//RequestEntity = request (headers + body + URL + method)