package com.isaProject.isa.Model.Pharmacy;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Users.PharmacyAdmin;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class  Pharmacy implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPharm;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String description;

    //prosečnu ocenu apoteke,
    @Column
    private double avgGrade;


//proba za grane eeeee


///
///fsds

//proba za grane



    @OneToMany(mappedBy = "pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<PharmacyAdmin> pharmacyAdmins = new HashSet<PharmacyAdmin>();

    //cenovnik lekova
    @OneToMany(mappedBy = "pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference

    private Set<DrugPricelist> drugPricelist = new HashSet<DrugPricelist>();


    @OneToMany(mappedBy = "pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<Examination> examinations = new HashSet<Examination>();

    public Integer getIdPharm() {
        return idPharm;
    }

    public void setIdPharm(Integer idPharm) {
        this.idPharm = idPharm;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getAvgGrade() {
        return avgGrade;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }


    //spisak (Collection) dermatologa, farmaceuta, lekova
    //cenovnik lekova i pregleda
   //adresu apoteke (dodatno prikaz adrese na mapi),
   //listu svih termina za preglede kod dermatologa koje može da zakaže,


    public void setPharmacyAdmins(Set<PharmacyAdmin> pharmacyAdmins) {
        this.pharmacyAdmins = pharmacyAdmins;
    }

    public void setDrugPricelist(Set<DrugPricelist> drugPricelist) {
        this.drugPricelist = drugPricelist;
    }

    public void setExaminations(Set<Examination> examinations) {
        this.examinations = examinations;
    }

    public Set<PharmacyAdmin> getPharmacyAdmins() {
        return pharmacyAdmins;
    }

}
