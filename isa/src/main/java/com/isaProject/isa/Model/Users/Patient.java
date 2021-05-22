package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Complaint;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@DiscriminatorValue("PATIENT")
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})

public class Patient extends User{

    @Column(nullable = true)
    private int penalty;

    @Column(nullable = true)
    private int points;

    //kategorija korisnika (npr. Regular, Silver, Gold).
    @Column(nullable = true)
    private String loyaltyCategory;

    //Lijekovi na koje je alergican
    @ManyToMany
    @JoinTable(name = "allergies", joinColumns = @JoinColumn(name="patientId" ,  referencedColumnName  = "idUser"),
            inverseJoinColumns = @JoinColumn(name = "drugId", referencedColumnName = "idDrug"))
    private Set<Drug> allergies = new HashSet<Drug>();


    @OneToMany(mappedBy = "patient")
    @JsonManagedReference
    private Set<DrugReservation> drugReservation=new HashSet<DrugReservation>();

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Examination> examinations = new HashSet<Examination>();

    public Patient() {
    }

    public Patient(Integer idUser, String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, int penalty, int points, String loyaltyCategory, Set<Drug> allergies, Set<DrugReservation> drugReservation, Set<Examination> examinations) {
        super(idUser, name, surname, email, password, address, phoneNumber, city, country);
        this.penalty = penalty;
        this.points = points;
        this.loyaltyCategory = loyaltyCategory;
        this.allergies = allergies;
        this.drugReservation = drugReservation;
        this.examinations = examinations;
    }

    public int getPenalty() {
        return penalty;
    }

    public void setPenalty(int penalty) {
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

    /*
    //zalbe
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Complaint> complaints = new ArrayList<Complaint>();
    */

}
//posjeta,
