package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.DrugFormat;


public class DrugDTO {
    private String name;

    private String code;

    private boolean recipeNeed;

    private String drugType;

    private DrugFormat format;

    private String manufacturer;

    public DrugDTO(){}


    public DrugDTO(String name, String code, boolean recipeNeed, String drugType, DrugFormat format, String manufacturer) {
        this.name = name;
        this.code = code;
        this.recipeNeed = recipeNeed;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }

    public boolean isRecipeNeed() {
        return recipeNeed;
    }

    public String getDrugType() {
        return drugType;
    }

    public DrugFormat getFormat() {
        return format;
    }

    public String getManufacturer() {
        return manufacturer;
    }


    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public void setRecipeNeed(boolean recipeNeed) {
        this.recipeNeed = recipeNeed;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public void setFormat(DrugFormat format) {
        this.format = format;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }
}
