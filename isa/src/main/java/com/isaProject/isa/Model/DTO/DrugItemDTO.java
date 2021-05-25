package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.DrugFormat;

public class DrugItemDTO {

    private Integer id;
    private String name;
    private String code;
    private String manufacturer;
    private int quantity;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getCode() {
        return code;
    }


    public String getManufacturer() {
        return manufacturer;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCode(String code) {
        this.code = code;
    }


    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public DrugItemDTO(Integer id, String name, String code, String manufacturer, int quantity) {
        this.id = id;
        this.name = name;
        this.code = code;
        this.manufacturer = manufacturer;
        this.quantity = quantity;
    }


}
