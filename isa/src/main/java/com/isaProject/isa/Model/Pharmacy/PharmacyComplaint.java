package com.isaProject.isa.Model.Pharmacy;

import com.isaProject.isa.Model.Users.Pharmacist;

import javax.persistence.*;

@Entity
@Table
public class PharmacyComplaint extends Complaint{

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm",nullable = true)
    private Pharmacy pharmacy;
}
