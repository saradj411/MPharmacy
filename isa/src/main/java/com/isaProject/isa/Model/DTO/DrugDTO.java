package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugFormat;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import lombok.NoArgsConstructor;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

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
    private Integer points;
    private Set<Integer> alternativeDrugs;

    public String getCode() {
        return code;
    }

    public Set<Integer> getAlternativeDrugs() {
        return alternativeDrugs;
    }

    public void setAlternativeDrugs(Set<Integer> alternativeDrugs) {
        this.alternativeDrugs = alternativeDrugs;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public DrugFormat getFormat() {
        return format;
    }

    public void setFormat(DrugFormat format) {
        this.format = format;
    }

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Integer getIdPharm() {
        return idPharm;
    }

    public void setIdPharm(Integer idPharm) {
        this.idPharm = idPharm;
    }

    public DrugDTO(){}

    public DrugDTO(String name, String code, String drugType, DrugFormat format, String manufacturer, Integer quantity, Integer idPharm, Integer points,
                   Set<Integer> alternativeDrugs) {
        this.name = name;
        this.code = code;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.idPharm = idPharm;
        this.points = points;
        this.alternativeDrugs = alternativeDrugs;
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

    public DrugDTO(String name, String code, boolean recipeNeed, String drugType, DrugFormat format, String manufacturer,Integer points, Set<Integer> alternativeDrugs) {
        this.name = name;
        this.code = code;
        this.recipeNeed = recipeNeed;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
        this.points = points;
        this.alternativeDrugs = alternativeDrugs;
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
