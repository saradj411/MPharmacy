package com.isaProject.isa.Model.Pharmacy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Pharmacist;

import javax.persistence.*;

@Entity

public class PharmacyComplaint extends Complaint{

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm",nullable = true)
    //@JsonManagedReference
    private Pharmacy pharmacy;

    public PharmacyComplaint(){}


    public PharmacyComplaint(Integer idComplaint, String text, Boolean isAnswered, ComplaintAnswer answer, Patient patient, Pharmacy pharmacy) {
        super(idComplaint, text, isAnswered, answer, patient);
        this.pharmacy = pharmacy;
    }

    public PharmacyComplaint( String text, Boolean isAnswered, ComplaintAnswer answer, Patient patient, Pharmacy pharmacy) {
        super(text, isAnswered, answer, patient);
        this.pharmacy = pharmacy;
    }
}
