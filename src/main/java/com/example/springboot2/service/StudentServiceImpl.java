package com.example.springboot2.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.springboot2.entity.Student;
import com.example.springboot2.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService{

	private final StudentRepository repo ;
	
	 public StudentServiceImpl(StudentRepository repo) {
	        this.repo = repo;
	    }
	
	@Override
	public Student createStudent(Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student getById(Long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Student updateStudent(Long id, Student student) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteStudent(Long id) {
		// TODO Auto-generated method stub
		
	}

}
