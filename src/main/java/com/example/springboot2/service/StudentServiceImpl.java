package com.example.springboot2.service;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
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


	//Spring Data JPA

	@Override
	public List<Student> findByName(String name) {
		return  repo.findByName(name);
	}

	@Override
	public Student findByEmail(String email) {
		return repo.findByEmail(email);
	}

	@Override
	public List<Student> findByAgeGreaterThan(int age) {
		return repo.findByAgeGreaterThan(age);

	}

	//findByNameContaining() -  performs LIKE %keyword% search
	@Override
	public List<Student> findByNameContaining(String prefix) {
		return repo.findByNameContaining(prefix);

	}


	//JPQL

	@Override
	public List<Student> searchByExactName(String name) {
		return repo.searchByExactName(name);
	}

	@Override
	public List<Student> searchByNameLike(String keyword) {
		return repo.searchByNameLike(keyword);

	}

	@Override
	public List<Student> sortByNameAsc() {
		return repo.sortByNameAsc();

	}

	@Override
	public Long totalStudentsCount() {
		return repo.totalStudentsCount();

	}

	//Pagination
	//Pageable -> page number + page size + sorting
	
	
	@Override
	public Page<Student> searchStudents(String keyword, int page, int size, String sortBy) {
		Pageable pageable = PageRequest.of(page, size, Sort.by(sortBy)); //This builds the pagination object

		return repo.findByNameContaining(keyword, pageable);
	}

}
