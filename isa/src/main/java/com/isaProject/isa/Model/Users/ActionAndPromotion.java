package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class ActionAndPromotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAction;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    //Administrator apoteke u slobodnoj formi definiše akciju, odnosno promociju.
    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm")
    @JsonBackReference
    private Pharmacy pharmacy;

}
