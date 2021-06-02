package com.isaProject.isa.Model.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExaminationFrontDTO {
    private Integer idPatient;
    private Integer idStaff;
    private Integer idPharm;
    private LocalDate date;
    private LocalTime start;
    private LocalTime end;
    private double price;
    private String report;
    private String name;
    private Integer numberOfDay;

    public ExaminationFrontDTO() {
    }

    public ExaminationFrontDTO(Integer idPatient, Integer idStaff, Integer idPharm, LocalDate date, LocalTime start, LocalTime end, double price, String report, String name, Integer numberOfDay) {
        this.idPatient = idPatient;
        this.idStaff = idStaff;
        this.idPharm = idPharm;
        this.date = date;
        this.start = start;
        this.end = end;
        this.price = price;
        this.report = report;
        this.name = name;
        this.numberOfDay = numberOfDay;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public Integer getIdPharm() {
        return idPharm;
    }

    public void setIdPharm(Integer idPharm) {
        this.idPharm = idPharm;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStart() {
        return start;
    }

    public void setStart(LocalTime start) {
        this.start = start;
    }

    public LocalTime getEnd() {
        return end;
    }

    public void setEnd(LocalTime end) {
        this.end = end;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(Integer numberOfDay) {
        this.numberOfDay = numberOfDay;
    }
}
