package com.isaProject.isa.Model.DTO;

public class DrugGradeDTO {

    private Integer idPatient;

    private Integer idDrug;

    private String name;

    private Integer grade;

    public DrugGradeDTO() {
    }

    public DrugGradeDTO(Integer idPatient, Integer idDrug, String name, Integer grade) {
        this.idPatient = idPatient;
        this.idDrug = idDrug;
        this.name = name;
        this.grade = grade;
    }

    public DrugGradeDTO(Integer idPatient, String name, Integer grade) {
        this.idPatient = idPatient;
        this.name = name;
        this.grade = grade;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(Integer idDrug) {
        this.idDrug = idDrug;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
