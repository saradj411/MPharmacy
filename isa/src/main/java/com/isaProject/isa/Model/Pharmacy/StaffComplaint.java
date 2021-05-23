package com.isaProject.isa.Model.Pharmacy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Users.Staff;

import javax.persistence.*;

@Entity
@Table
public class StaffComplaint extends Complaint{

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "staffId", referencedColumnName = "idUser",nullable = true)
    @JsonManagedReference
    private Staff staff;
}
