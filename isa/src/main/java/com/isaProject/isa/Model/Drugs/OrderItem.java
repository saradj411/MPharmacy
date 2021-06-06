package com.isaProject.isa.Model.Drugs;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;

@Entity
@Table
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idItem;

    @Column
    private Integer quantity;



    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "drugId", referencedColumnName = "idDrug", nullable = true, unique = false)
    @JsonBackReference
    private Drug drug;

    public OrderItem(Integer quantity, Drug drug) {
        this.quantity = quantity;
        this.drug = drug;
    }

    public OrderItem() {
    }

    @ManyToOne(cascade = CascadeType.MERGE, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", referencedColumnName = "idOrder", nullable = true, unique = false)
    @JsonBackReference
    private DrugOrder drugOrder;

    public Integer getIdItem() {
        return idItem;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public DrugOrder getDrugOrder() {
        return drugOrder;
    }

    public void setDrugOrder(DrugOrder drugOrder) {
        this.drugOrder = drugOrder;
    }
}
