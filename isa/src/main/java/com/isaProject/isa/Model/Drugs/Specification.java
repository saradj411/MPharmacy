package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSpec;

    //kontraindikacija
    @Column
    private String contraindications;

    //sastav lijeka
    @Column
    private String structure;

    //preporučeni unos terapije na dnevnom nivou
    @Column
    private Integer recommendedDose;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drugCode", referencedColumnName = "code")
    private Drug drug;

    @OneToMany(mappedBy = "specification", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JsonManagedReference
    private Set<Ingredient> ingredients=new HashSet<Ingredient>();



}
