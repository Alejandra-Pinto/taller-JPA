package com.example.JPA.service;

import org.springframework.stereotype.Service;

import com.example.JPA.entity.*;
import com.example.JPA.infra.dto.DegreeWorkRequest;
import com.example.JPA.repository.*;

import java.util.List;

@Service
public class DegreeWorkService implements IDegreeWorkService {

    private final DegreeWorkRepository degreeRepo;
    private final StudentRepository studentRepo;
    private final ProfessorRepository professorRepo;
    private final NotificationServiceClient notificationClient; // nuevo cliente Feign

    public DegreeWorkService(
            DegreeWorkRepository degreeRepo,
            StudentRepository studentRepo,
            ProfessorRepository professorRepo,
            NotificationServiceClient notificationClient
    ) {
        this.degreeRepo = degreeRepo;
        this.studentRepo = studentRepo;
        this.professorRepo = professorRepo;
        this.notificationClient = notificationClient;
    }

    @Override
    public DegreeWork createDegreeWork(DegreeWorkRequest request) {
        DegreeWork dw = new DegreeWork();
        dw.setTitle(request.getTitle());
        dw.setModality(request.getModality());
        dw.setCreationDate(request.getCreationDate());
        dw.setGeneralObjective(request.getGeneralObjective());
        dw.setSpecificObjectives(request.getSpecificObjectives());
        dw.setEstadoP(request.getEstadoP());

        // Asociaciones
        dw.setStudent1(studentRepo.findById(request.getStudent1Id()).orElseThrow());
        if (request.getStudent2Id() != null)
            dw.setStudent2(studentRepo.findById(request.getStudent2Id()).orElse(null));

        dw.setDirector(professorRepo.findById(request.getDirectorId()).orElseThrow());
        dw.setCoDirector1(professorRepo.findById(request.getCoDirector1Id()).orElseThrow());
        if (request.getCoDirector2Id() != null)
            dw.setCoDirector2(professorRepo.findById(request.getCoDirector2Id()).orElse(null));

        // Guardar trabajo de grado
        DegreeWork saved = degreeRepo.save(dw);

        //  Enviar notificación sincrónicamente al microservicio Notification
        notificationClient.sendDegreeWork(saved);

        return saved;
    }

    @Override
    public List<DegreeWork> getAllDegreeWorks() {
        return degreeRepo.findAll();
    }

    @Override
    public DegreeWork getDegreeWorkById(Long id) {
        return degreeRepo.findById(id).orElse(null);
    }
}