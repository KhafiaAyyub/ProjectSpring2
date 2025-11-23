package com.example.springboot2.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.example.springboot2.entity.Student;

@Repository
public interface StudentRepository extends JpaRepository<Student, Long>{

}

//JpaRepository gives all CRUD methods
//No need to write boilerplate SQL
// this class will talk to database