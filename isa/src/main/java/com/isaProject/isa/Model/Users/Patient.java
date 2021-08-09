package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient extends User implements Serializable {


    @Column(nullable = true)
    private Integer penalty;

    @Column(nullable = true)
    private int points;

    //kategorija korisnika (npr. Regular, Silver, Gold).
    @Column(nullable = true)
    private String loyaltyCategory;

    //Lijekovi na koje je alergican
    //@JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "allergies", joinColumns = @JoinColumn(name="patientId" ,  referencedColumnName  = "id"),
            inverseJoinColumns = @JoinColumn(name = "drugId", referencedColumnName = "idDrug"))
    private Set<Drug> allergies = new HashSet<Drug>();

    @JsonIgnore
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER)
    //@JsonBackReference
    private Set<DrugReservation> drugReservation=new HashSet<DrugReservation>();

    @JsonIgnore
    @OneToMany(mappedBy = "patient", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<Examination> examinations = new HashSet<Examination>();
/*
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonManagedReference
    private Set<ERecipe> erecipes = new HashSet<ERecipe>();
*/
    //apoteke na koje je pretplacen
    @JsonIgnore
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "action_patient_pharmacy",
            joinColumns = @JoinColumn(name = "patientId", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm"))
    private Set<Pharmacy> actionPharmacies = new HashSet<>();

    public Patient() {
    }

    public Patient(Integer id, String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, Integer penalty, int points, String loyaltyCategory, Set<Drug> allergies, Set<DrugReservation> drugReservation, Set<Examination> examinations) {
        super(id, name, surname, email, password, address, phoneNumber, city, country);
        this.penalty = penalty;
        this.points = points;
        this.loyaltyCategory = loyaltyCategory;
        this.allergies = allergies;
        this.drugReservation = drugReservation;
        this.examinations = examinations;
    }

    public Patient(Integer id, String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, Integer penalty, int points, String loyaltyCategory, Set<Drug> allergies, Set<DrugReservation> drugReservation, Set<Examination> examinations, Set<Pharmacy> actionPharmacies) {
        super(id, name, surname, email, password, address, phoneNumber, city, country);
        this.penalty = penalty;
        this.points = points;
        this.loyaltyCategory = loyaltyCategory;
        this.allergies = allergies;
        this.drugReservation = drugReservation;
        this.examinations = examinations;
        this.actionPharmacies = actionPharmacies;
    }

    public  Patient(Integer id, String name, String surname, String email, String password, String address, String phoneNumber, String city, String country)
    {
        super(id, name, surname, email, password, address, phoneNumber, city, country);
        this.penalty = 0;
        this.points = 0;
        this.loyaltyCategory = "NONE";
        this.allergies = null;
        this.drugReservation = null;
        this.examinations = null;
        this.actionPharmacies = null;



    }

    public Integer getPenalty() {
        return penalty;
    }

    public void setPenalty(Integer penalty) {
        this.penalty = penalty;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public String getLoyaltyCategory() {
        return loyaltyCategory;
    }

    public void setLoyaltyCategory(String loyaltyCategory) {
        this.loyaltyCategory = loyaltyCategory;
    }

    public Set<Drug> getAllergies() {
        return allergies;
    }

    public void setAllergies(Set<Drug> allergies) {
        this.allergies = allergies;
    }

    public Set<DrugReservation> getDrugReservation() {
        return drugReservation;
    }

    public void setDrugReservation(Set<DrugReservation> drugReservation) {
        this.drugReservation = drugReservation;
    }

    public Set<Examination> getExaminations() {
        return examinations;
    }

    public void setExaminations(Set<Examination> examinations) {
        this.examinations = examinations;
    }

    public Set<Pharmacy> getActionPharmacies() {
        return actionPharmacies;
    }

    public void setActionPharmacies(Set<Pharmacy> actionPharmacies) {
        this.actionPharmacies = actionPharmacies;
    }


/*
    public Set<ERecipe> getErecipes() {
        return erecipes;
    }

    public void setErecipes(Set<ERecipe> erecipes) {
        this.erecipes = erecipes;
    }
*/
    /*
    //zalbe
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Complaint> complaints = new ArrayList<Complaint>();
    */

}
//posjeta,
