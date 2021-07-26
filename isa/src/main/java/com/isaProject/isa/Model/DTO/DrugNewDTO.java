package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.DrugFormat;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;

public class DrugNewDTO {


    private String name;

    private String password;
    private String drugType;

    @Enumerated(EnumType.STRING)
    private DrugFormat format;

    private String manufacturer;
    private Integer quantity;
    private Integer idPharm;

    public DrugNewDTO(String name, String password, String drugType, DrugFormat format, String manufacturer, Integer quantity, Integer idPharm) {
        this.name = name;
        this.password = password;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
        this.idPharm = idPharm;
    }


    public DrugNewDTO() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public DrugFormat getFormat() {
        return format;
    }

    public void setFormat(DrugFormat format) {
        this.format = format;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Integer getIdPharm() {
        return idPharm;
    }

    public void setIdPharm(Integer idPharm) {
        this.idPharm = idPharm;
    }
}
