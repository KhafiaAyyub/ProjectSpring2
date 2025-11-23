package com.example.springboot2.service;

import java.util.List;

import org.springframework.data.domain.Page;

import com.example.springboot2.entity.Student;

public interface StudentService {

	Student createStudent(Student student);
	List<Student> getAllStudents();
	Student getById(Long id);
	Student updateStudent(Long id, Student student);
	void deleteStudent(Long id);


	//Spring Data JPA
	List<Student> findByName(String name);
	Student findByEmail(String email);
	List<Student> findByAgeGreaterThan(int age);
	List<Student> findByNameContaining(String prefix);
	
	//JPQL
	List<Student> searchByExactName(String name);
	List<Student> searchByNameLike(String keyword);
	List<Student> sortByNameAsc();
	Long totalStudentsCount();

	//Pagination
	Page<Student> searchStudents(String keyword, int page, int size, String sortBy);


}
