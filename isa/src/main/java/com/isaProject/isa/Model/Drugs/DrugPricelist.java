package com.isaProject.isa.Model.Drugs;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class DrugPricelist {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPricelist;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "drugId", referencedColumnName = "idDrug", nullable = true, unique = false)
    private Drug drug;

    @Column
    private double price;

    @Column
    private Date start;

    @Column
    private Date end;

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = true, unique = false)
    private Pharmacy pharmacy;

    /* Postupak definisanja i izmene cenovnika
    Administrator apoteke ima mogućnost definisanja cenovnika za apoteku. Za
    svaki lek se navodi cena kao i period važenja cene.

    Prilikom generisanja
    izveštaja o prihodima apoteke, u obzir se uzima cena leka za datum prodaje.
    Izmena cenovnika ne sme da utiče na stare izveštaje.*/
}
