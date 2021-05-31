package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Users.PharmacyAdmin;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class DrugOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrder;

    @Column
    private Integer quantity;

    //do kad se primaju ponude
    @Column
    @Basic
    @Temporal(TemporalType.DATE)
    private Date timeLimit;//********************


    //statusu narudžbenice (čeka ponude, obrađena)
    @Column
    private Boolean processed;//ceka ponude=faalse//*********************

    @OneToMany(mappedBy = "drugOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();//************

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "admin", referencedColumnName = "idUser")
    //@JsonManagedReference
    private PharmacyAdmin pharmacyAdmin;//***********

    @OneToMany(mappedBy = "drugOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<Offer> offers = new HashSet<Offer>();//*****************

}


