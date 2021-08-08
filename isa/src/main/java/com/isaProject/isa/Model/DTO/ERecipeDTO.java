package com.isaProject.isa.Model.DTO;


public class ERecipeDTO {

    private Integer idDrug;
    private Integer idWhoCreate;
    private String drugName;
    private Integer idPatient;
    private Integer quantity;

    public ERecipeDTO(){}

    public ERecipeDTO(Integer idDrug, Integer idWhoCreate, String drugName, Integer idPatient, Integer quantity) {
        this.idDrug = idDrug;
        this.idWhoCreate = idWhoCreate;
        this.drugName = drugName;
        this.idPatient = idPatient;
        this.quantity = quantity;
    }

    public Integer getIdWhoCreate() {
        return idWhoCreate;
    }

    public void setIdWhoCreate(Integer idWhoCreate) {
        this.idWhoCreate = idWhoCreate;
    }

    public Integer getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(Integer idDrug) {
        this.idDrug = idDrug;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "ERecipeDTO{" +
                "idDrug=" + idDrug +
                ", idWhoCreate=" + idWhoCreate +
                ", drugName='" + drugName + '\'' +
                ", idPatient=" + idPatient +
                ", quantity=" + quantity +
                '}';
    }
}

