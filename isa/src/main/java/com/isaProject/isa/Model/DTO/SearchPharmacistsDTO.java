package com.isaProject.isa.Model.DTO;

public class SearchPharmacistsDTO {

    private  String name;
    private String surame;

    public SearchPharmacistsDTO() {
    }

    public SearchPharmacistsDTO(String name, String surame) {
        this.name = name;
        this.surame = surame;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurame() {
        return surame;
    }

    public void setSurame(String surame) {
        this.surame = surame;
    }
}
