package com.isaProject.isa.Model.DTO;

import java.time.LocalTime;
import java.util.Date;

public class ScheduleAnExaminationDTO {


    private Date date;

    private LocalTime startTime;

    private LocalTime endTime;

    private double price;

    private String pharmacyName;

    private Integer idPatient;

    public Date getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public double getPrice() {
        return price;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }



    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public ScheduleAnExaminationDTO(Date date, LocalTime startTime, LocalTime endTime, double price, String pharmacyName, Integer idPatient) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.pharmacyName = pharmacyName;
        this.idPatient = idPatient;
    }

    public ScheduleAnExaminationDTO() {
    }
}
