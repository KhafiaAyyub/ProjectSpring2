package com.example.springboot2.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
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

    @NotBlank(message = "Name cannot be empty") //field must NOT be empty
    @Column(nullable = false) //cannot be empty
    private String name;

    @NotNull(message = "Age is required") //cannot be null
    @Min(value = 1, message = "Age must be greater than 0")
    private int age;

    @Email(message = "Invalid email format")
    @NotBlank(message = "Email is required")
    private String email;
	
	
}
