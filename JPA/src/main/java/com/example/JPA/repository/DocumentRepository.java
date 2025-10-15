package com.example.JPA.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.JPA.entity.Document;

public interface DocumentRepository extends JpaRepository<Document, Long> {
}