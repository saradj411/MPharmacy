package com.isaProject.isa.Model.Users;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Pharmacist extends Staff {

    //apoteka u kojoj je zaposlen
    @ManyToOne
    @JoinColumn(name = "pharmacistPharmacy", referencedColumnName = "idPharm", nullable = true)
    private Pharmacy pharmacy;

    /*
        Prilikom kreiranja farmaceuta,definiše radno vreme,
        Jedan farmaceut može biti zaposlen samo u jednoj apoteci.
    */
}