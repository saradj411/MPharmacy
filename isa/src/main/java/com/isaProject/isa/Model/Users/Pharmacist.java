package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.Set;

@Entity
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Pharmacist extends Staff implements Serializable {

    //apoteka u kojoj je zaposlen
    @ManyToOne
    @JoinColumn(name = "pharmacistPharmacy", referencedColumnName = "idPharm", nullable = true)
    @JsonBackReference(value="user-movement")
        //@JsonManagedReference(value="pharmacist-person")
    private Pharmacy pharmacy;

    /*
        Prilikom kreiranja farmaceuta,definiše radno vreme,
        Jedan farmaceut može biti zaposlen samo u jednoj apoteci.
    */

    public Pharmacist(Integer id, String name, String surname, String email,String password, String address, String phoneNumber, String city, String country, double avgGrade, Set<WorkTime> workTime, Set<Examination> examinations, Set<Vacation> vacation, Pharmacy pharmacy) {
        super(id, name, surname, email, password, address, phoneNumber, city, country, avgGrade, workTime, examinations, vacation);
        this.pharmacy = pharmacy;
    }

    public Pharmacist(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
    public Pharmacist() {
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}