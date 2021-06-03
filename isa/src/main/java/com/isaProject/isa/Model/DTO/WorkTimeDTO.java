package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Staff;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalTime;
import java.util.Date;

public class WorkTimeDTO {




    private Date date;


    private LocalTime startTime;


    private LocalTime endTime;


    private Staff staff;

    private Pharmacy pharmacy;



    public Date getDate() {
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

    public void setDate(Date date) {
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

    public  WorkTimeDTO() {}
    public WorkTimeDTO(Date date, LocalTime startTime, LocalTime endTime, Staff staff, Pharmacy pharmacy) {
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.staff = staff;
        this.pharmacy = pharmacy;
    }


}
