package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;

@Entity
@Table
public class PharmacyDrugs {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "drugId", referencedColumnName = "idDrug", nullable = false)
   // @JsonManagedReference
    private Drug drug;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = false)
    //@JsonManagedReference
    private Pharmacy pharmacy;

    @Column
    private int quantity;
}
