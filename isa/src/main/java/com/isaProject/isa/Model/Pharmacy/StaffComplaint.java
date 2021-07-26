package com.isaProject.isa.Model.Pharmacy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;

import javax.persistence.*;

@Entity
public class StaffComplaint extends Complaint{

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "staffId", referencedColumnName = "id",nullable = true)
    @JsonManagedReference
    private Staff staff;

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public StaffComplaint(){}

    public StaffComplaint(String text, Boolean isAnswered, ComplaintAnswer answer, Patient patient, Staff staff) {
        super(text, isAnswered, answer, patient);
        this.staff = staff;
    }

    public StaffComplaint(Staff staff) {
        this.staff = staff;
    }

    public StaffComplaint(Integer idComplaint, String text, Boolean isAnswered, ComplaintAnswer answer, Patient patient, Staff staff) {
        super(idComplaint, text, isAnswered, answer, patient);
        this.staff = staff;
    }

}
