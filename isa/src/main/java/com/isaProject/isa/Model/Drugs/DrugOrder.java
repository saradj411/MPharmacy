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
    @JoinColumn(name = "admin", referencedColumnName = "id")
    @JsonBackReference
    private PharmacyAdmin pharmacyAdmin;

    @OneToMany(mappedBy = "drugOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<Offer> offers = new HashSet<Offer>();//*****************

    public Integer getIdOrder() {
        return idOrder;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Date getTimeLimit() {
        return timeLimit;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public PharmacyAdmin getPharmacyAdmin() {
        return pharmacyAdmin;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTimeLimit(Date timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public void setPharmacyAdmin(PharmacyAdmin pharmacyAdmin) {
        this.pharmacyAdmin = pharmacyAdmin;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

    public DrugOrder(Integer idOrder, Integer quantity, Date timeLimit, Boolean processed, Set<OrderItem> orderItems, PharmacyAdmin pharmacyAdmin, Set<Offer> offers) {
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.timeLimit = timeLimit;
        this.processed = processed;
        this.orderItems = orderItems;
        this.pharmacyAdmin = pharmacyAdmin;
        this.offers = offers;
    }
    public DrugOrder(Integer idOrder,Date timeLimit, Boolean processed, Set<OrderItem> orderItems, PharmacyAdmin pharmacyAdmin, Set<Offer> offers) {
        this.idOrder = idOrder;
        this.timeLimit = timeLimit;
        this.processed = processed;
        this.orderItems = orderItems;
        this.pharmacyAdmin = pharmacyAdmin;
        this.offers = offers;
    }

    public DrugOrder(){

    }
}


