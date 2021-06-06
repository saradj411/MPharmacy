package com.isaProject.isa.Model.DTO;

public class PharmacistGradeDTO {

    private Integer idPatient;

    private Integer idPharmacist;

    private String name;
    private String surname;

    private Integer grade;


    public PharmacistGradeDTO() {
    }

    public PharmacistGradeDTO(Integer idPatient, Integer idPharmacist, String name, String surname, Integer grade) {
        this.idPatient = idPatient;
        this.idPharmacist = idPharmacist;
        this.name = name;
        this.surname = surname;
        this.grade = grade;
    }

    public PharmacistGradeDTO(Integer idPatient, String name, String surname, Integer grade) {
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

    public Integer getIdPharmacist() {
        return idPharmacist;
    }

    public void setIdPharmacist(Integer idPharmacist) {
        this.idPharmacist = idPharmacist;
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
