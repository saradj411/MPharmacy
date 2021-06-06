package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.DrugFormat;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;

@NoArgsConstructor
public class DrugDTO implements Serializable {
    private String name;

    private String code;

    private boolean recipeNeed;
    private String drugType;

    @Enumerated(EnumType.STRING)
    private DrugFormat format;

    private String manufacturer;

    private Integer quantity;

    private Pharmacy pharmacy;
    private Integer idPharm;

    public Integer getIdPharm() {
        return idPharm;
    }

    public void setIdPharm(Integer idPharm) {
        this.idPharm = idPharm;
    }

    public DrugDTO(String name, String code, String drugType, DrugFormat format, String manufacturer, Integer quantity, Integer idPharm) {
        this.name = name;
        this.code = code;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.idPharm = idPharm;
    }

    public DrugDTO(String name, String code, boolean recipeNeed, String drugType, DrugFormat format, String manufacturer) {
        this.name = name;
        this.code = code;
        this.recipeNeed = recipeNeed;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
    }

    public DrugDTO(String name, String code, boolean recipeNeed, String drugType, DrugFormat format, String manufacturer, Integer quantity, Pharmacy pharmacy) {
        this.name = name;
        this.code = code;
        this.recipeNeed = recipeNeed;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.pharmacy = pharmacy;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }


    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }


    public String getName() {
        return name;
    }

    public String Code() {
        return code;
    }

    public boolean isRecipeNeed() {
        return recipeNeed;
    }

    public String getDrugType() {
        return drugType;
    }

    public DrugFormat Format() {
        return format;
    }

    public String getManufacturer() {
        return manufacturer;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void Code(String code) {
        this.code = code;
    }

    public void setRecipeNeed(boolean recipeNeed) {
        this.recipeNeed = recipeNeed;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public void Format(DrugFormat format) {
        this.format = format;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
