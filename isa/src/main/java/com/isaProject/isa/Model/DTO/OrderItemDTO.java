package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.Drug;

public class OrderItemDTO {
    private Integer quantity;
    private Drug drug;

    public OrderItemDTO() {
    }

    public OrderItemDTO(Integer quantity, Drug drug) {
        this.quantity = quantity;
        this.drug = drug;
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
}
