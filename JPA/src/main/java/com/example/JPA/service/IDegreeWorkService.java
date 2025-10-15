package com.example.JPA.service;

import java.util.List;

import com.example.JPA.entity.DegreeWork;
import com.example.JPA.infra.dto.DegreeWorkRequest;

public interface IDegreeWorkService {
    DegreeWork createDegreeWork(DegreeWorkRequest request);
    List<DegreeWork> getAllDegreeWorks();
    DegreeWork getDegreeWorkById(Long id);
}
