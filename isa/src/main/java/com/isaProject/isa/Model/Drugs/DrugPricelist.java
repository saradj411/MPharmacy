package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.*;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import org.hibernate.annotations.Cascade;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
public class DrugPricelist implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPricelist;


    //@JsonIgnore
    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "drugId", referencedColumnName = "idDrug", nullable = true, unique = false)
    //@JsonManagedReference
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idDrug")
    //@JsonIdentityReference(alwaysAsId = true)

    private Drug drug;

    @Column
    private double price;

    @Column
    private LocalDate start;

    @Column
    private LocalDate end;

    //@JsonIgnore
    @ManyToOne//(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = true, unique = false)

    //@JsonManagedReference
    //@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPharm")
    //@JsonIdentityReference(alwaysAsId = true)

    private Pharmacy pharmacy;

    public DrugPricelist(Integer idPricelist, Drug drug, double price, LocalDate start, LocalDate end, Pharmacy pharmacy) {
        this.idPricelist = idPricelist;
        this.drug = drug;
        this.price = price;
        this.start = start;
        this.end = end;
        this.pharmacy = pharmacy;
    }

    public DrugPricelist() {
    }

    public Integer getIdPricelist() {
        return idPricelist;
    }

    public void setIdPricelist(Integer idPricelist) {
        this.idPricelist = idPricelist;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    /* Postupak definisanja i izmene cenovnika
    Administrator apoteke ima mogućnost definisanja cenovnika za apoteku. Za
    svaki lek se navodi cena kao i period važenja cene.

    Prilikom generisanja
    izveštaja o prihodima apoteke, u obzir se uzima cena leka za datum prodaje.
    Izmena cenovnika ne sme da utiče na stare izveštaje.*/
}
