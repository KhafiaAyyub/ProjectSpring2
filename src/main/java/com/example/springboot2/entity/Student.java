package com.example.springboot2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity   //tells hibernate that this class represents a datatable table
@Table(name="students") //table name
public class Student {

	@Id //primary key
    @GeneratedValue(strategy = GenerationType.IDENTITY)  //auto increment
    private Long id;

    @Column(nullable = false) //cannot be empty
    private String name;

    private int age;

    private String email;
	
	
}
