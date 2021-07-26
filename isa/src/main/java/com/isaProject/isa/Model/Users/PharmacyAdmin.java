package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.*;
import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RestController;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;


@Entity
//@DiscriminatorValue("PHARMACY_ADMIN")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class PharmacyAdmin extends User {


    private static final long serialVersionUID = 1L;

    //@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "adminPharmacy", referencedColumnName = "idPharm", nullable = true, unique = false)
    @JsonBackReference
    /*@JsonIdentityInfo(generator = ObjectIdGenerators.PropertyGenerator.class, property = "idPharm")
    @JsonIdentityReference(alwaysAsId = true)
    */
    private Pharmacy pharmacy;


    @JsonIgnore
    @OneToMany(mappedBy = "pharmacyAdmin", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<DrugOrder> drugOrder=new HashSet<DrugOrder>();



    public PharmacyAdmin() {
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public Set<DrugOrder> getDrugOrder() {
        return drugOrder;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public PharmacyAdmin(Pharmacy pharmacy, Set<DrugOrder> drugOrder) {
        this.pharmacy = pharmacy;
        this.drugOrder = drugOrder;
    }

    public void setDrugOrder(Set<DrugOrder> drugOrder) {
        this.drugOrder = drugOrder;
    }
/*
        Napomena: Jedna apoteka može da ima više administratora, a jedan
        administrator može biti administrator samo jedne apoteke.
    */


    public PharmacyAdmin(Integer id, String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, Pharmacy pharmacy, Set<DrugOrder> drugOrder) {
        super(id, name, surname, email, password, address, phoneNumber, city, country);
        this.pharmacy = pharmacy;
        this.drugOrder = drugOrder;
    }
}
