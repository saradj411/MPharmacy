package com.isaProject.isa.Model.Drugs;

import javax.persistence.*;

@Entity
public class Ingredient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column
    private String name;

    @ManyToOne
    @JoinColumn(name = "specId", referencedColumnName = "idSpec")
    private Specification specification;



}
