package com.isaProject.isa.Model.DTO;

public class PharmacyGradeDTO {
    private Integer idPatient;

    private Integer idPharmacy;

    private String name;

    private Integer grade;

    public PharmacyGradeDTO() {
    }

    public PharmacyGradeDTO(Integer idPatient, Integer idPharmacy, String name, Integer grade) {
        this.idPatient = idPatient;
        this.idPharmacy = idPharmacy;
        this.name = name;
        this.grade = grade;
    }

    public PharmacyGradeDTO(Integer idPatient, String name, Integer grade) {
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

    public Integer getIdPharmacy() {
        return idPharmacy;
    }

    public void setIdPharmacy(Integer idPharmacy) {
        this.idPharmacy = idPharmacy;
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
