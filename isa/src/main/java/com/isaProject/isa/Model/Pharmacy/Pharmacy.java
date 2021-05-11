package com.isaProject.isa.Model.Pharmacy;


import javax.persistence.*;

@Entity
@Table(name = "pharmacy")
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String description;
    @Column
    private String freeExamination;
    //spisak (Collection) dermatologa, farmaceuta, lekova
    //cenovnik lekova i pregleda
}
