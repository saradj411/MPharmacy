package com.isaProject.isa.Model.DTO;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class FreeExaminationsForRepresentationDTO {

    private LocalDate date;

    private LocalTime startTime;

    private LocalTime endTime;

    private double price;

    private String pharmacyName;

    private String name;

    private String surname;

    private Integer id;


    public FreeExaminationsForRepresentationDTO() {
    }

    public Integer getId() {
        return id;
    }

    public FreeExaminationsForRepresentationDTO(LocalDate date, LocalTime startTime, LocalTime endTime, double price, String pharmacyName, String name, String surname, Integer id) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.pharmacyName = pharmacyName;
        this.name = name;
        this.surname = surname;
        this.id = id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getPharmacyName() {
        return pharmacyName;
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

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public FreeExaminationsForRepresentationDTO(LocalDate date, LocalTime startTime, LocalTime endTime, double price, String pharmacyName, String name, String surname) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.pharmacyName = pharmacyName;
        this.name = name;
        this.surname = surname;
    }
}
