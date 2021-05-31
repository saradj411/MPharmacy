package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.Drug;

public class TherapyDTO {

        Drug drug;

        Integer quantity;

    public TherapyDTO(Drug drug, Integer quantity) {
        this.drug = drug;
        this.quantity = quantity;
    }

    public TherapyDTO() {
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Drug getDrug() {
        return drug;
    }

    public Integer getQuantity() {
        return quantity;
    }
}
