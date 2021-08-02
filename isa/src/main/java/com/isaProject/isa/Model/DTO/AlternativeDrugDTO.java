package com.isaProject.isa.Model.DTO;

public class AlternativeDrugDTO {

    private Integer idDrug;
    private String name;

    public  AlternativeDrugDTO(){}
    public AlternativeDrugDTO(Integer idDrug, String name) {
        this.idDrug = idDrug;
        this.name = name;
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
}
