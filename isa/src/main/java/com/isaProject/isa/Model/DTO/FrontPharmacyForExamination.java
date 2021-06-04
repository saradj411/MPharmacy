package com.isaProject.isa.Model.DTO;

import org.apache.tomcat.jni.Local;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;

public class FrontPharmacyForExamination {

    private Integer idPharm;
    private String name;
    private String addres;
    private Double avgGrade;
    private Double priceConsultation;
    private LocalDate date;
    private LocalTime time;

    private Integer idStaff;

    public FrontPharmacyForExamination(String name, String addres, Double avgGrade, Double priceConsultation, Integer idStaff) {
        this.name = name;
        this.addres = addres;
        this.avgGrade = avgGrade;
        this.priceConsultation = priceConsultation;
        this.idStaff = idStaff;
    }

    public FrontPharmacyForExamination(String name, String addres, Double avgGrade, Double priceConsultation) {
        this.name = name;
        this.addres = addres;
        this.avgGrade = avgGrade;
        this.priceConsultation = priceConsultation;
    }


    public FrontPharmacyForExamination(Integer idPharm, String name, String addres, Double avgGrade, Double priceConsultation) {
        this.idPharm = idPharm;
        this.name = name;
        this.addres = addres;
        this.avgGrade = avgGrade;
        this.priceConsultation = priceConsultation;
    }

    public FrontPharmacyForExamination(Integer idPharm, Integer idStaff) {
        this.idPharm = idPharm;
        this.idStaff = idStaff;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddres() {
        return addres;
    }

    public void setAddres(String addres) {
        this.addres = addres;
    }

    public Double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(Double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public Double getPriceConsultation() {
        return priceConsultation;
    }

    public void setPriceConsultation(Double priceConsultation) {
        this.priceConsultation = priceConsultation;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }

    public Integer getIdPharm() {
        return idPharm;
    }

    public void setIdPharm(Integer idPharm) {
        this.idPharm = idPharm;
    }
}
