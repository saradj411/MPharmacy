package com.isaProject.isa.Model.Users;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;

@Entity
public class PharmacyAdmin extends User{

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = true, unique = false)
    private Pharmacy pharmacy;
    /*
        Napomena: Jedna apoteka može da ima više administratora, a jedan
        administrator može biti administrator samo jedne apoteke.
    */
}
