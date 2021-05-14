package com.isaProject.isa.Model.Users;

import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
public class PharmacyAdmin extends User{

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = true, unique = false)
    private Pharmacy pharmacy;

    @OneToMany(mappedBy = "pharmacyAdmin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DrugOrder> drugOrder=new HashSet<DrugOrder>();

    /*
        Napomena: Jedna apoteka može da ima više administratora, a jedan
        administrator može biti administrator samo jedne apoteke.
    */
}
