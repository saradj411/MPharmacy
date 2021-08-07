package com.isaProject.isa.Model.DTO;

import java.util.List;
import java.util.Set;

public class ShowDrugsDTO {
    private String name;
    private String drugType;
    private double grade;

    private List<PharmaciesAndPriceDTO> pharmaciesAndPriceDTO;

    public ShowDrugsDTO(){}

    public ShowDrugsDTO(String name, String drugType, double grade, List<PharmaciesAndPriceDTO> pharmaciesAndPriceDTO) {
        this.name = name;
        this.drugType = drugType;
        this.grade = grade;
        this.pharmaciesAndPriceDTO = pharmaciesAndPriceDTO;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public List<PharmaciesAndPriceDTO> getPharmaciesAndPriceDTO() {
        return pharmaciesAndPriceDTO;
    }

    public void setPharmaciesAndPriceDTO(List<PharmaciesAndPriceDTO> pharmaciesAndPriceDTO) {
        this.pharmaciesAndPriceDTO = pharmaciesAndPriceDTO;
    }

    @Override
    public String toString() {
        return "ShowDrugsDTO{" +
                "name='" + name + '\'' +
                ", drugType='" + drugType + '\'' +
                ", grade=" + grade +
                ", pharmaciesAndPriceDTO=" + pharmaciesAndPriceDTO +
                '}';
    }
}
