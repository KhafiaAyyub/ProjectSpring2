package com.example.springboot2.repository;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
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

	//http://localhost:8080/api/students/search/prefix/ra
//	SELECT * FROM student WHERE name LIKE %prefix%
	List<Student> findByNameContaining(String prefix);

	
	
	//JPQL - Java Persistence Query Language
	// BUT it uses Entity names, NOT table names
	
	
	//JPQL @Query Annotation - When you want custom SQL-like queries..
	@Query("SELECT s FROM Student s WHERE s.age > :age")
	List<Student> getStudentsOlderThan(int age);
	//Hibernate converts this into SQL.

	
	//@Param("name") -> connects method parameter → query parameter
	@Query("SELECT s FROM Student s WHERE s.name = :name")
	List<Student> searchByExactName(@Param("name") String name);

	
	//LIKE
	@Query("SELECT s FROM Student s WHERE s.name LIKE %:keyword%")
	List<Student> searchByNameLike(@Param("keyword") String keyword);

	//ORDER BY
	@Query("SELECT s FROM Student s ORDER BY s.name ASC")
	List<Student> sortByNameAsc();

	//COUNT
	@Query("SELECT COUNT(s) FROM Student s")
	Long totalStudentsCount();

	
	//Pagination -     
	Page<Student> findByNameContaining(String name, Pageable pageable);

	
	

}

//JpaRepository gives all CRUD methods
//No need to write boilerplate SQL
// this class will talk to database