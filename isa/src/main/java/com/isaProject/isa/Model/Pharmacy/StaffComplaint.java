package com.isaProject.isa.Model.Pharmacy;

import com.isaProject.isa.Model.Users.Staff;

import javax.persistence.*;

@Entity
@Table
public class StaffComplaint extends Complaint{

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "staffId", referencedColumnName = "idUser",nullable = true)
    private Staff staff;
}
