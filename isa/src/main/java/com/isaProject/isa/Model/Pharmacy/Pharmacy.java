package com.isaProject.isa.Model.Pharmacy;


import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Users.PharmacyAdmin;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Pharmacy {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idPharm;
    @Column
    private String name;
    @Column
    private String address;
    @Column
    private String description;
    @Column
    private String freeExamination;

    //prosečnu ocenu apoteke,
    @Column
    private double avgGrade;


    @OneToMany(mappedBy = "pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<PharmacyAdmin> pharmacyAdmins = new HashSet<PharmacyAdmin>();

    //cenovnik lekova
    @OneToMany(mappedBy = "pharmacy", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<DrugPricelist> drugPricelist = new HashSet<DrugPricelist>();



    //spisak (Collection) dermatologa, farmaceuta, lekova
    //cenovnik lekova i pregleda
   //adresu apoteke (dodatno prikaz adrese na mapi),
   //listu svih termina za preglede kod dermatologa koje može da zakaže,


}
