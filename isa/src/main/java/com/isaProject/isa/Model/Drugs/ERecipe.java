package com.isaProject.isa.Model.Drugs;


import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Set<ERecipeDrug> eRecipeDrug = new HashSet<ERecipeDrug>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm")
    @JsonManagedReference
    private Pharmacy pharmacy;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "patientId", referencedColumnName = "idUser")
    @JsonManagedReference
    private Patient patient;

    @Column
    private ERecipeStatus status;
}
/*
-eRecept (nov, obrađen, odbijen)

 */