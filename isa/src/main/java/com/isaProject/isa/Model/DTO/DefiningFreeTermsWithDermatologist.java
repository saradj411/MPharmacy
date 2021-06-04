package com.isaProject.isa.Model.DTO;

import javax.persistence.Column;
import java.time.LocalDate;
import java.time.LocalTime;


public class DefiningFreeTermsWithDermatologist {


    private LocalDate date;


    private LocalTime startTime;


    private LocalTime endTime;


    private double price;

    private String pharmName;

    private Integer idDerm;

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

    public String getPharmName() {
        return pharmName;
    }

    public void setPharmName(String pharmName) {
        this.pharmName = pharmName;
    }

    public Integer getIdDerm() {
        return idDerm;
    }

    public void setIdDerm(Integer idDerm) {
        this.idDerm = idDerm;
    }

    public DefiningFreeTermsWithDermatologist(LocalDate date, LocalTime startTime, LocalTime endTime, double price, String pharmName, Integer idDerm) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.pharmName = pharmName;
        this.idDerm = idDerm;
    }

    public DefiningFreeTermsWithDermatologist() {
    }
}
