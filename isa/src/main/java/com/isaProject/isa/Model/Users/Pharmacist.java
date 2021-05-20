package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
@DiscriminatorValue("PHARMACIST")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

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