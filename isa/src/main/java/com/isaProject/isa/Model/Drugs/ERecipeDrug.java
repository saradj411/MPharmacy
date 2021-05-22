package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;

@Entity
@Table
public class ERecipeDrug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "erecipeId", referencedColumnName = "idRecipe")
    @JsonBackReference
    private ERecipe eRecipe;
}
/*
● Listu koja će sadržati za svaki prepisani lek:
○ Šifru leka
○ Naziv leka
○ Količinu
 */