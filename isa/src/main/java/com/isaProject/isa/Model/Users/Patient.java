package com.isaProject.isa.Model.Users;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Complaint;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
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
    private Set<DrugReservation> drugReservation=new HashSet<DrugReservation>();

    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Examination> examinations = new HashSet<Examination>();

    /*
    //zalbe
    @OneToMany(mappedBy = "patient", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Complaint> complaints = new ArrayList<Complaint>();
    */

}
//posjeta,
