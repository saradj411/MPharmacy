package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Model.Examination.Therapy;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class FrontCreatedExaminationDTO {

    private Integer idExamination;

    private LocalDate date;


    private LocalTime startTime;

    private LocalTime endTime;

    private double price;

    private String nameStaff;
    private String surnameStaff;
    private Double gradeStaff;

    private String namePharmacy;

    private String report;

    private Therapy therapy;
    //private Staff staff;


    public FrontCreatedExaminationDTO(Integer idExamination, LocalDate date, LocalTime startTime, LocalTime endTime, double price, String nameStaff, String surnameStaff, Double gradeStaff) {
        this.idExamination = idExamination;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.nameStaff = nameStaff;
        this.surnameStaff = surnameStaff;
        this.gradeStaff = gradeStaff;
    }

    public FrontCreatedExaminationDTO(Integer idExamination, LocalDate date, LocalTime startTime, LocalTime endTime, double price, String nameStaff, String surnameStaff, String namePharmacy) {
        this.idExamination = idExamination;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.nameStaff = nameStaff;
        this.surnameStaff = surnameStaff;
        this.namePharmacy = namePharmacy;
    }

    public FrontCreatedExaminationDTO(Integer idExamination, LocalDate date, LocalTime startTime, LocalTime endTime, double price, String nameStaff, String surnameStaff, String namePharmacy, String report, Therapy therapy) {
        this.idExamination = idExamination;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.nameStaff = nameStaff;
        this.surnameStaff = surnameStaff;
        this.namePharmacy = namePharmacy;
        this.report = report;
        this.therapy = therapy;
    }

    public Integer getIdExamination() {
        return idExamination;
    }

    public void setIdExamination(Integer idExamination) {
        this.idExamination = idExamination;
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


    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public String getSurnameStaff() {
        return surnameStaff;
    }

    public void setSurnameStaff(String surnameStaff) {
        this.surnameStaff = surnameStaff;
    }

    public Double getGradeStaff() {
        return gradeStaff;
    }

    public void setGradeStaff(Double gradeStaff) {
        this.gradeStaff = gradeStaff;
    }

    public String getNamePharmacy() {
        return namePharmacy;
    }

    public void setNamePharmacy(String namePharmacy) {
        this.namePharmacy = namePharmacy;
    }

    public String getReport() {
        return report;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }
}
