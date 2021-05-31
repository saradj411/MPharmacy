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
    @JoinColumn(name = "supplier", referencedColumnName = "idUser")
    //@JsonManagedReference
    private Supplier supplier;


    public Integer getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Integer idOffer) {
        this.idOffer = idOffer;
    }

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public Date getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public DrugOrder getDrugOrder() {
        return drugOrder;
    }

    public void setDrugOrder(DrugOrder drugOrder) {
        this.drugOrder = drugOrder;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }


    public Offer(Integer idOffer, OfferStatus offerStatus, double price, Date deliveryDate, DrugOrder drugOrder, Supplier supplier) {
        this.idOffer = idOffer;
        this.offerStatus = offerStatus;
        this.price = price;
        this.deliveryDate = deliveryDate;
        this.drugOrder = drugOrder;
        this.supplier = supplier;
    }

    public Offer() {
    }
}
