package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Users.PharmacyAdmin;

import javax.persistence.*;
import java.time.LocalDate;
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
    //@Temporal(TemporalType.DATE)
    private LocalDate timeLimit;//********************

    //statusu narudžbenice (čeka ponude, obrađena)
    @Column
    private Boolean processed;//ceka ponude=faalse//*********************

    @OneToMany(mappedBy = "drugOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();//************

    //PROMJENA MERGEEEEEE
    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "admin", referencedColumnName = "id", nullable = true, unique = false)
    @JsonManagedReference
    private PharmacyAdmin pharmacyAdmin;//***********

    /*@ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "admin", referencedColumnName = "id")
    @JsonBackReference
    private PharmacyAdmin pharmacyAdmin;
*/

    @OneToMany(mappedBy = "drugOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<Offer> offers = new HashSet<Offer>();//*****************


    public DrugOrder(Integer idOrder, Integer quantity, LocalDate timeLimit, Boolean processed, Set<OrderItem> orderItems, PharmacyAdmin pharmacyAdmin, Set<Offer> offers) {
        this.idOrder = idOrder;
        this.quantity = quantity;
        this.timeLimit = timeLimit;
        this.processed = processed;
        this.orderItems = orderItems;
        this.pharmacyAdmin = pharmacyAdmin;
        this.offers = offers;
    }
    public DrugOrder(Integer idOrder,LocalDate timeLimit, Boolean processed, Set<OrderItem> orderItems, PharmacyAdmin pharmacyAdmin, Set<Offer> offers) {
            this.idOrder = idOrder;
        this.timeLimit = timeLimit;
        this.processed = processed;
        this.orderItems = orderItems;
        this.pharmacyAdmin = pharmacyAdmin;
        this.offers = offers;
    }

    public DrugOrder(){

    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalDate timeLimit) {
        this.timeLimit = timeLimit;
    }

    public Boolean getProcessed() {
        return processed;
    }

    public void setProcessed(Boolean processed) {
        this.processed = processed;
    }

    public Set<OrderItem> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(Set<OrderItem> orderItems) {
        this.orderItems = orderItems;
    }

    public PharmacyAdmin getPharmacyAdmin() {
        return pharmacyAdmin;
    }

    public void setPharmacyAdmin(PharmacyAdmin pharmacyAdmin) {
        this.pharmacyAdmin = pharmacyAdmin;
    }

    public Set<Offer> getOffers() {
        return offers;
    }

    public void setOffers(Set<Offer> offers) {
        this.offers = offers;
    }

}


