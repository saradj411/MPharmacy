package com.isaProject.isa.Model.DTO;

import javax.persistence.Column;

public class DermatologistGradeDTO {

    private Integer idPatient;

    private Integer idDermatologist;

   private String name;
   private String surname;

    private Integer grade;

    public DermatologistGradeDTO() {
    }

    public DermatologistGradeDTO(Integer idPatient, Integer idDermatologist, String name, String surname, Integer grade) {
        this.idPatient = idPatient;
        this.idDermatologist = idDermatologist;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }

    public DermatologistGradeDTO(Integer idPatient, String name, String surname, Integer grade) {
        this.idPatient = idPatient;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getIdDermatologist() {
        return idDermatologist;
    }

    public void setIdDermatologist(Integer idDermatologist) {
        this.idDermatologist = idDermatologist;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
