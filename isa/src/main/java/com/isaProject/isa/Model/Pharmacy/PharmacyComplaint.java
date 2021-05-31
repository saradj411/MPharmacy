package com.isaProject.isa.Model.Pharmacy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Users.Pharmacist;

import javax.persistence.*;

@Entity

public class PharmacyComplaint extends Complaint{

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm",nullable = true)
    //@JsonManagedReference
    private Pharmacy pharmacy;
}
