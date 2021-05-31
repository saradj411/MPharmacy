package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Users.Supplier;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Offer {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOffer;

    @Column
    @Enumerated(EnumType.STRING)
    private OfferStatus offerStatus;

    @Column
    private double price;

    //rok isporuke
    @Column
    private Date deliveryDate;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", referencedColumnName = "idOrder")
    //@JsonManagedReference
    private DrugOrder drugOrder;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier", referencedColumnName = "id")
    @JsonBackReference
    private Supplier supplier;

}
