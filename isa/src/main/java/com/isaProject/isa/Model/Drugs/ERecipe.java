package com.isaProject.isa.Model.Drugs;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class ERecipe {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idRecipe;

    //● Šifru
    @Column
    private String code;

    //● Ime i prezime korisnika za kojeg se izdaje recept
    @Column
    private String name;

    @Column
    private String surname;

    //● Datum izdavanja
    @Column
    private Date dateOfIssue;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<ERecipeDrug> eRecipeDrug = new HashSet<ERecipeDrug>();

    @JsonIgnore
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm")
    //@JsonBackReference
    private Pharmacy pharmacy;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    @JsonBackReference
    private Patient patient;

    @Column
    @Enumerated(EnumType.STRING)
    private ERecipeStatus status;

    public ERecipe(Integer idRecipe, String code, String name, String surname, Date dateOfIssue, Set<ERecipeDrug> eRecipeDrug, Pharmacy pharmacy, Patient patient, ERecipeStatus status) {
        this.idRecipe = idRecipe;
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.dateOfIssue = dateOfIssue;
        this.eRecipeDrug = eRecipeDrug;
        this.pharmacy = pharmacy;
        this.patient = patient;
        this.status = status;
    }

    public ERecipe() {
    }

    public Integer getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(Integer idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public Date getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(Date dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Set<ERecipeDrug> geteRecipeDrug() {
        return eRecipeDrug;
    }

    public void seteRecipeDrug(Set<ERecipeDrug> eRecipeDrug) {
        this.eRecipeDrug = eRecipeDrug;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public ERecipeStatus getStatus() {
        return status;
    }

    public void setStatus(ERecipeStatus status) {
        this.status = status;
    }
}
/*
-eRecept (nov, obrađen, odbijen)

 */