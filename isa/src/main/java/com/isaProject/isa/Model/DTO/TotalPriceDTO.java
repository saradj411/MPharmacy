package com.isaProject.isa.Model.DTO;

import java.util.List;

public class TotalPriceDTO
{
    private PharmacyDrugsDTO pharmacyDrugsDTOList;
    private double totalPrice;
    public  TotalPriceDTO(){}

    public PharmacyDrugsDTO getPharmacyDrugsDTOList() {
        return pharmacyDrugsDTOList;
    }

    public void setPharmacyDrugsDTOList(PharmacyDrugsDTO pharmacyDrugsDTOList) {
        this.pharmacyDrugsDTOList = pharmacyDrugsDTOList;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Override
    public String toString() {
        return "TotalPriceDTO{" +
                "pharmacyDrugsDTOList=" + pharmacyDrugsDTOList +
                ", totalPrice=" + totalPrice +
                '}';
    }


}
