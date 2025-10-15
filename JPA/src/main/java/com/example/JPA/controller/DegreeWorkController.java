package com.example.JPA.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.Optional;

import com.example.JPA.entity.*;
import com.example.JPA.repository.*;

import java.util.List;

@RestController
@RequestMapping("/api/degreeworks")
public class DegreeWorkController {
    private final DegreeWorkRepository degreeWorkRepo;
    private final StudentRepository studentRepo;

    public DegreeWorkController(DegreeWorkRepository degreeWorkRepo, StudentRepository studentRepo) {
        this.degreeWorkRepo = degreeWorkRepo;
        this.studentRepo = studentRepo;
    }

    @GetMapping
    public List<DegreeWork> getAll() {
        return degreeWorkRepo.findAll();
    }
    @GetMapping("/{id}")
    public Optional<DegreeWork> getById(@PathVariable Long id) {
        return degreeWorkRepo.findById(id);
    }

    @GetMapping
    public List<Student> getAllStudent() {
        return studentRepo.findAll();
    }
}
