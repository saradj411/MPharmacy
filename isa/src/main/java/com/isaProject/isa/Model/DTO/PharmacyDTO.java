package com.isaProject.isa.Model.DTO;

import javax.persistence.Column;

public class PharmacyDTO {

    private String name;

    private String address;

    private String city;

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private  String country;

    private String description;

    public Integer getIdPharmacyAdmin() {
        return idPharmacyAdmin;
    }

    public void setIdPharmacyAdmin(Integer idPharmacyAdmin) {
        this.idPharmacyAdmin = idPharmacyAdmin;
    }

    private Integer idPharmacyAdmin;

    public PharmacyDTO(String name, String address, String city, String country, String description, double avgGrade, Integer idPharmacyAdmin) {
        this.name = name;
        this.address = address;
        this.city = city;
        this.country = country;
        this.description = description;
        this.avgGrade = avgGrade;
        this.idPharmacyAdmin = idPharmacyAdmin;
    }

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

    @Override
    public String toString() {
        return "PharmacyDTO{" +
                "name='" + name + '\'' +
                ", address='" + address + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", description='" + description + '\'' +
                ", idPharmacyAdmin=" + idPharmacyAdmin +
                ", avgGrade=" + avgGrade +
                '}';
    }
}

