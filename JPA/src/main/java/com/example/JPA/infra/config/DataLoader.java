package com.example.JPA.infra.config;

import com.example.JPA.entity.*;
import com.example.JPA.entity.enums.EstadoDegreeWork;
import com.example.JPA.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataLoader implements CommandLineRunner {

    @Autowired
    private StudentRepository studentRepository;

    @Autowired
    private ProfessorRepository professorRepository;

    @Autowired
    private DegreeWorkRepository degreeWorkRepository;

    @Override
    public void run(String... args) throws Exception {

        // ----- Estudiantes -----
        Student student1 = new Student();
        student1.setNombres("Juan Carlos");
        student1.setApellidos("Cardenas Muñoz");
        student1.setCodigoEstudiante("11736344");

        Student student2 = new Student();
        student2.setNombres("María Fernanda");
        student2.setApellidos("López Rojas");
        student2.setCodigoEstudiante("11891234");

        studentRepository.saveAll(List.of(student1, student2));

        // ----- Profesores -----
        Professor director = new Professor();
        director.setNombres("Julio Ariel");
        director.setApellidos("Hurtado Alegría");
        director.setDepartamento("Ingeniería de Sistemas");

        Professor coDirector1 = new Professor();
        coDirector1.setNombres("Carolina");
        coDirector1.setApellidos("Mina Ríos");
        coDirector1.setDepartamento("Ingeniería Electrónica");

        Professor coDirector2 = new Professor();
        coDirector2.setNombres("Luis Eduardo");
        coDirector2.setApellidos("Chávez Patiño");
        coDirector2.setDepartamento("Telecomunicaciones");

        professorRepository.saveAll(List.of(director, coDirector1, coDirector2));

        // ----- Trabajo de Grado -----
        DegreeWork degreeWork = new DegreeWork();
        degreeWork.setTitle("Modelo de medición de habilidades en arquitectos de software");
        degreeWork.setModality("Investigación");
        degreeWork.setCreationDate("2025-10-15");
        degreeWork.setGeneralObjective("Analizar y medir las competencias clave en arquitectos de software mediante métricas específicas.");
        degreeWork.setSpecificObjectives(List.of(
                "Identificar las habilidades más relevantes en la arquitectura de software.",
                "Diseñar un modelo de evaluación basado en métricas de desempeño.",
                "Validar el modelo mediante casos de estudio reales."
        ));
        degreeWork.setEstadoP(EstadoDegreeWork.FORMATO_A);

        degreeWork.setStudent1(student1);
        degreeWork.setStudent2(student2);
        degreeWork.setDirector(director);
        degreeWork.setCoDirector1(coDirector1);
        degreeWork.setCoDirector2(coDirector2);

        degreeWorkRepository.save(degreeWork);

        System.out.println("Datos de prueba cargados correctamente en la base de datos H2.");
    }
}
