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

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "drugId", referencedColumnName = "idDrug")
   // @JsonManagedReference
    private Drug drug;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm")
    //@JsonManagedReference
    private Pharmacy pharmacy;

    @Column
    private int quantity;

    public PharmacyDrugs() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public PharmacyDrugs(Integer id, Drug drug, Pharmacy pharmacy, int quantity) {
        this.id = id;
        this.drug = drug;
        this.pharmacy = pharmacy;
        this.quantity = quantity;
    }
}
