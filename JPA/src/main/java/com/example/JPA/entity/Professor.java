package com.example.JPA.entity;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Professor extends User {
    private String departamento;

    @OneToMany(mappedBy = "director")
    private List<DegreeWork> directedWorks;

    @OneToMany(mappedBy = "coDirector1")
    private List<DegreeWork> coDirectedWorks1;

    @OneToMany(mappedBy = "coDirector2")
    private List<DegreeWork> coDirectedWorks2;

    public String getDepartamento() { return departamento; }
    public void setDepartamento(String departamento) { this.departamento = departamento; }
}
