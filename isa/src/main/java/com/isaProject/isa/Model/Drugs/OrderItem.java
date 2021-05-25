package com.isaProject.isa.Model.Drugs;


import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class OrderItem {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idItem;

    @Column
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "drugId", referencedColumnName = "idDrug")
    @JsonBackReference
    private Drug drug;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "orderId", referencedColumnName = "idOrder")
    @JsonBackReference
    private DrugOrder drugOrder;

    public Integer getIdItem() {
        return idItem;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public Drug getDrug() {
        return drug;
    }

    public DrugOrder getDrugOrder() {
        return drugOrder;
    }

    public void setIdItem(Integer idItem) {
        this.idItem = idItem;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public void setDrugOrder(DrugOrder drugOrder) {
        this.drugOrder = drugOrder;
    }

    public OrderItem(Integer idItem, Integer quantity, Drug drug, DrugOrder drugOrder) {
        this.idItem = idItem;
        this.quantity = quantity;
        this.drug = drug;
        this.drugOrder = drugOrder;
    }

    public OrderItem(Integer quantity, Drug drug, DrugOrder drugOrder) {
        this.quantity = quantity;
        this.drug = drug;
        this.drugOrder = drugOrder;
    }
}
