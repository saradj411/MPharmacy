package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.OrderItem;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Model.Examination.Therapy;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class CreateExaminationDTO {

    private Date date;


    private LocalTime startTime;


    private LocalTime endTime;


    private double price;

    //inf o pregledu
    private String report;

    private Integer idPharm;


    //@JsonBackReference
    private Integer idPatient;

    //@JsonBackReference
    private Integer idStaff;

    private String name;

    private Set<TherapyDTO> therapy = new HashSet<TherapyDTO>();//************


    //kod dermatologa, kod farmaceuta

    @Enumerated(EnumType.STRING)
    private ExaminationType type;

    //CREATED,SCHEDULED,CANCELED,FINISHED,EXPIRED

    @Enumerated(EnumType.STRING)
    private ExaminationStatus status;



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

    public String getReport() {
        return report;
    }

    public Integer getIdPharm() {
        return idPharm;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public ExaminationType getType() {
        return type;
    }

    public ExaminationStatus getStatus() {
        return status;
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

    public void setReport(String report) {
        this.report = report;
    }

    public void setIdPharm(Integer idPharm) {
        this.idPharm = idPharm;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public void setType(ExaminationType type) {
        this.type = type;
    }

    public void setStatus(ExaminationStatus status) {
        this.status = status;
    }

    public CreateExaminationDTO() {
    }

    public CreateExaminationDTO(Date date, LocalTime startTime, LocalTime endTime, double price, String report, Integer idPharm, Integer idPatient, Integer idStaff, ExaminationType type, ExaminationStatus status) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.report = report;
        this.idPharm = idPharm;
        this.idPatient = idPatient;
        this.idStaff = idStaff;
        this.type = type;
        this.status = status;
    }

    public CreateExaminationDTO(Date date, LocalTime startTime, LocalTime endTime, double price, String report, Integer idPharm, Integer idPatient, Integer idStaff, String name, Set<TherapyDTO> therapy, ExaminationType type, ExaminationStatus status) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.report = report;
        this.idPharm = idPharm;
        this.idPatient = idPatient;
        this.idStaff = idStaff;
        this.name = name;
        this.therapy = therapy;
        this.type = type;
        this.status = status;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<TherapyDTO> getTherapy() {
        return therapy;
    }

    public void setTherapy(Set<TherapyDTO> therapy) {
        this.therapy = therapy;
    }
}
