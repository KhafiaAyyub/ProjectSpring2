package com.example.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot2.entity.Student;
import com.example.springboot2.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	//It will store  object of StudentRepository.
	private final StudentRepository repo ;

	//Spring Dependency Injection
	//
	public StudentServiceImpl(StudentRepository repo) {
		this.repo = repo;
	}

	@Override
	public Student createStudent(Student student) {
		return repo.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		return repo.findAll();
	}

	@Override
	public Student getById(Long id) {  //if not found ->> throw exception
		return repo.findById(id).orElseThrow(() -> new RuntimeException("Student not found") );
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		Student existing = getById(id); //first find the existing object -> then update the values
		existing.setName(student.getName());
		existing.setAge(student.getAge());
		existing.setEmail(student.getEmail());
		return repo.save(existing);

	}

	@Override
	public void deleteStudent(Long id) {
		repo.deleteById(id);

	}

}
