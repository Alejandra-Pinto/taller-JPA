package com.example.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPA.entity.Student;

public interface StudentRepository extends JpaRepository<Student, Long> { }