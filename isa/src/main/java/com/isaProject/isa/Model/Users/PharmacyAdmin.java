package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("PHARMACY_ADMIN")
@JsonIgnoreProperties()

public class PharmacyAdmin extends User {


    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "adminPharmacy", referencedColumnName = "idPharm", nullable = true, unique = false)
    //@JsonManagedReference
    private Pharmacy pharmacy;


    @OneToMany(mappedBy = "pharmacyAdmin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<DrugOrder> drugOrder=new HashSet<DrugOrder>();



    public PharmacyAdmin() {
    }


    public PharmacyAdmin(Pharmacy pharmacy, Set<DrugOrder> drugOrder) {
        this.pharmacy = pharmacy;
        this.drugOrder = drugOrder;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Set<DrugOrder> getDrugOrder() {
        return drugOrder;
    }

    public void setDrugOrder(Set<DrugOrder> drugOrder) {
        this.drugOrder = drugOrder;
    }
/*
        Napomena: Jedna apoteka može da ima više administratora, a jedan
        administrator može biti administrator samo jedne apoteke.
    */


    public PharmacyAdmin(Integer idUser, String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, Pharmacy pharmacy, Set<DrugOrder> drugOrder) {
        super(idUser, name, surname, email, password, address, phoneNumber, city, country);
        this.pharmacy = pharmacy;
        this.drugOrder = drugOrder;
    }
}
