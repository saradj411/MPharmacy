package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("PHARMACY_ADMIN")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class PharmacyAdmin extends User {

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "adminPharmacy", referencedColumnName = "idPharm", nullable = true, unique = false)
    private Pharmacy pharmacy;

    @OneToMany(mappedBy = "pharmacyAdmin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
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
}
