package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Dermatologist extends Staff implements  Serializable{

    //apoteke u kojima je zaposlen
    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(name = "dermatologists_in_pharmacies",
            joinColumns = @JoinColumn(name = "dermatologistId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm"))
    private Set<Pharmacy> pharmacies = new HashSet<>();

    /*
        Prilikom dodavanja dermatologa, definiše radno vreme u apoteci,
        pri čemu vodi računa da mu se radno vreme ne poklapa sa drugim apotekama u kojima je zaposlen,
        Jedan dermatolog može biti zaposlen u više apoteka.
    */

    public Dermatologist(Integer id, String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, double avgGrade, Set<WorkTime> workTime, Set<Examination> examinations, Set<Vacation> vacation, Set<Pharmacy> pharmacies) {
        super(id, name, surname, email, password, address, phoneNumber, city, country, avgGrade, workTime, examinations, vacation);
        this.pharmacies = pharmacies;
    }
    public Dermatologist(){
        super();
    }
    public Set<Pharmacy> getPharmacies() {
        return pharmacies;
    }

    public void setPharmacies(Set<Pharmacy> pharmacies) {
        this.pharmacies = pharmacies;
    }
}
