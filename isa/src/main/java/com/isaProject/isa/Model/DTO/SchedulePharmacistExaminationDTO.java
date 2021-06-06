package com.isaProject.isa.Model.DTO;

import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
public class SchedulePharmacistExaminationDTO {
    private LocalDate date;

    private LocalTime startTime;


    private double price;

    private Integer pharmacy;

    private Integer patient;

    private Integer staff;

    public SchedulePharmacistExaminationDTO(LocalDate date, LocalTime startTime, double price, Integer pharmacy, Integer patient, Integer staff) {
        this.date = date;
        this.startTime = startTime;
        this.pharmacy = pharmacy;
        this.patient = patient;
        this.staff = staff;
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


    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Integer getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Integer pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public Integer getStaff() {
        return staff;
    }

    public void setStaff(Integer staff) {
        this.staff = staff;
    }
}
