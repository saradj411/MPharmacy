package com.isaProject.isa.Model.DTO;

import javax.persistence.Column;

public class PharmacyDTO {

    private String name;

    private String address;

    private String description;

    private double avgGrade;


    public PharmacyDTO() {
    }

    public PharmacyDTO(String name, String address, String description, double avgGrade) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.avgGrade = avgGrade;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }
}

