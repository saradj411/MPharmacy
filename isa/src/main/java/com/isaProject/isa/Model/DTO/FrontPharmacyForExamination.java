package com.isaProject.isa.Model.DTO;

public class FrontPharmacyForExamination {

    private String name;
    private String addres;
    private Double avgGrade;
    private Double priceConsultation;

    private Integer idStaff;

    public FrontPharmacyForExamination(String name, String addres, Double avgGrade, Double priceConsultation, Integer idStaff) {
        this.name = name;
        this.addres = addres;
        this.avgGrade = avgGrade;
        this.priceConsultation = priceConsultation;
        this.idStaff = idStaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public Double getPriceConsultation() {
        return priceConsultation;
    }

    public void setPriceConsultation(Double priceConsultation) {
        this.priceConsultation = priceConsultation;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }
}
