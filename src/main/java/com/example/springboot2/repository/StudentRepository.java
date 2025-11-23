package com.example.springboot2.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.example.springboot2.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

	//JPA reads method name → converts to SQL
	//Spring Data JPA allows auto-generated SQL from method names.
	List<Student> findByName(String name);
	// SELECT * FROM student WHERE name = 'Khafia';

	Student findByEmail(String email);

	List<Student> findByAgeGreaterThan(int age);

//	SELECT * FROM student WHERE name LIKE %prefix%
	List<Student> findByNameContaining(String prefix);

	//JPQL @Query Annotation - When you want custom SQL-like queries..
	@Query("SELECT s FROM Student s WHERE s.age > :age")
	List<Student> getStudentsOlderThan(int age);
	//Hibernate converts this into SQL.


}

//JpaRepository gives all CRUD methods
//No need to write boilerplate SQL
// this class will talk to database