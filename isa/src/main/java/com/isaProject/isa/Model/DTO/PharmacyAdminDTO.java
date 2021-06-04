package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.Column;
import java.util.HashSet;
import java.util.Set;

public class PharmacyAdminDTO {

    private String name;

    private String surname;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private String city;

    private String country;

    private Integer idPharm;

    private double avgGrade;

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }



    public PharmacyAdminDTO() {
    }

    public PharmacyAdminDTO(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country,double avgGrade, Integer idPharm) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.avgGrade = avgGrade;
        this.idPharm = idPharm;
    }

    public PharmacyAdminDTO(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, double avgGrade) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.avgGrade = avgGrade;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getIdPharm() {
        return idPharm;
    }

    public void setIdPharm(Integer idPharm) {
        this.idPharm = idPharm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getAddress() {
        return address;
    }

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

}
