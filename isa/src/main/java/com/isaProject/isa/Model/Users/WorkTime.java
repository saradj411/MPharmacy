package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table
public class WorkTime {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private LocalDate date;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "id", nullable = false)
    @JsonBackReference
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = false)
    //@JsonManagedReference
    private Pharmacy pharmacy;

    public WorkTime(Date date, LocalTime startTime, LocalTime endTime, Integer id, Pharmacy p) {
    }

    public Integer getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public Staff getStaff() {
        return staff;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public WorkTime(Integer id, LocalDate date, LocalTime startTime, LocalTime endTime, Staff staff, Pharmacy pharmacy) {
    public  WorkTime(){

    }

    public WorkTime(Date date, LocalTime startTime, LocalTime endTime, Staff staff, Pharmacy pharmacy) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.staff = staff;
        this.pharmacy = pharmacy;
    }
    public WorkTime(Integer id, Date date, LocalTime startTime, LocalTime endTime, Staff staff, Pharmacy pharmacy) {
        this.id = id;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.staff = staff;
        this.pharmacy = pharmacy;
    }




}