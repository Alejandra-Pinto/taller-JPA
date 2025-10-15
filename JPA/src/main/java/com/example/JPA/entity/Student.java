package com.example.JPA.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Student extends User {
    private String codigoEstudiante;

    @OneToMany(mappedBy = "student1")
    private List<DegreeWork> degreeWorksAsStudent1;

    @OneToMany(mappedBy = "student2")
    private List<DegreeWork> degreeWorksAsStudent2;

    public String getCodigoEstudiante() { return codigoEstudiante; }
    public void setCodigoEstudiante(String codigoEstudiante) { this.codigoEstudiante = codigoEstudiante; }

}
