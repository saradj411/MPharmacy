package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Vacation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date start;

    @Column
    private Date end;

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "idUser", nullable = false)
    @JsonBackReference
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = false)
    @JsonBackReference
    private Pharmacy pharmacy;

}
