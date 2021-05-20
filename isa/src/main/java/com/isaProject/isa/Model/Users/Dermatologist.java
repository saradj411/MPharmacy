package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("DERMATOLOGIST")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Dermatologist extends Staff{

    //apoteke u kojima je zaposlen
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "dermatologists_in_pharmacies",
            joinColumns = @JoinColumn(name = "dermatologistId", referencedColumnName = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm"))
    private Set<Pharmacy> pharmacies = new HashSet<>();

    /*
        Prilikom dodavanja dermatologa, definiše radno vreme u apoteci,
        pri čemu vodi računa da mu se radno vreme ne poklapa sa drugim apotekama u kojima je zaposlen,
        Jedan dermatolog može biti zaposlen u više apoteka.
    */
}
