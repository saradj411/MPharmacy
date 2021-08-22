package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.Drug;

public class DrugInfoDTO {

    private Drug drug;
    private Integer quantity;
    private double price;

    public DrugInfoDTO(){
    }
    public DrugInfoDTO(Drug drug, Integer quantity, double price) {
        this.drug = drug;
        this.quantity = quantity;
        this.price = price;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "DrugInfoDTO{" +
                "drug=" + drug.getName() +
                ", quantity=" + quantity +
                ", price=" + price +
                '}';
    }
}
