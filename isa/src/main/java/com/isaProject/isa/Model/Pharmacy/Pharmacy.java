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

    @Column
    private Double consultationPrice;

    // dodato za mapuuuu

    @Column
    private String town;

    @Column
    private String street;

    @Column
    private Integer number;

    @Column
    private Integer postalCode;

    @Column
    private String country;


    //DODATO
    @Column
    private String city;


    @OneToMany(mappedBy = "pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<PharmacyAdmin> pharmacyAdmins = new HashSet<PharmacyAdmin>();

    //cenovnik lekova
    @OneToMany(mappedBy = "pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<DrugPricelist> drugPricelist = new HashSet<DrugPricelist>();


    @OneToMany(mappedBy = "pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonBackReference
    private Set<Examination> examinations = new HashSet<Examination>();

    public Pharmacy(){}

    public Pharmacy(Integer idPharm, String name, String address, String description, double avgGrade, Double consultationPrice, String city, String country, Set<PharmacyAdmin> pharmacyAdmins, Set<DrugPricelist> drugPricelist, Set<Examination> examinations) {
        this.idPharm = idPharm;
        this.name = name;
        this.address = address;
        this.description = description;
        this.avgGrade = avgGrade;
        this.consultationPrice = consultationPrice;
        this.city = city;
        this.country = country;
        this.pharmacyAdmins = pharmacyAdmins;
        this.drugPricelist = drugPricelist;
        this.examinations = examinations;
    }

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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Set<DrugPricelist> getDrugPricelist() {
        return drugPricelist;
    }

    public Set<Examination> getExaminations() {
        return examinations;
    }

    public Pharmacy(String name, String address, String description, double avgGrade, String city, String country,Set<PharmacyAdmin> pharmacyAdmins) {
        this.name = name;
        this.address = address;
        this.description = description;
        this.avgGrade = avgGrade;
        this.city = city;
        this.country = country;
        this.pharmacyAdmins = pharmacyAdmins;
        this.examinations = null;
        this.drugPricelist = null;
    }

    public Pharmacy(Integer idPharm, String name, String address, String description, double avgGrade, String city, String country, Set<PharmacyAdmin> pharmacyAdmins, Set<DrugPricelist> drugPricelist, Set<Examination> examinations) {
        this.idPharm = idPharm;
        this.name = name;
        this.address = address;
        this.description = description;
        this.avgGrade = avgGrade;
        this.city = city;
        this.country = country;
        this.pharmacyAdmins = pharmacyAdmins;
        this.drugPricelist = drugPricelist;
        this.examinations = examinations;
    }

    public String getTown() {
        return town;
    }

    public void setTown(String town) {
        this.town = town;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }


    public Double getConsultationPrice() {
        return consultationPrice;
    }

    public void setConsultationPrice(Double consultationPrice) {
        this.consultationPrice = consultationPrice;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getPostalCode() {
        return postalCode;
    }

    public void setPostalCode(Integer postalCode) {
        this.postalCode = postalCode;
    }
}
