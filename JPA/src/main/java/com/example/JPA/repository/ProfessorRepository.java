package com.example.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPA.entity.Professor;

public interface ProfessorRepository extends JpaRepository<Professor, Long> { }

