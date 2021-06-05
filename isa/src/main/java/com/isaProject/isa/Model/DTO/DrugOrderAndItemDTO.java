package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Drugs.OfferStatus;
import com.isaProject.isa.Model.Drugs.OrderItem;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class DrugOrderAndItemDTO {

    private Integer idOrder;
    private String pharmacyName;
    private Integer pharmacyId;
    private ArrayList<DrugOrderItemDTO> drugList;
    private LocalDate timeLimit;

    public DrugOrderAndItemDTO(){}

    public DrugOrderAndItemDTO(Integer idOrder, String pharmacyName, Integer pharmacyId, ArrayList<DrugOrderItemDTO> drugList, LocalDate timeLimit) {
        this.idOrder = idOrder;
        this.pharmacyName = pharmacyName;
        this.pharmacyId = pharmacyId;
        this.drugList = drugList;
        this.timeLimit = timeLimit;
    }

    public ArrayList<DrugOrderItemDTO> getDrugList() {
        return drugList;
    }

    public void setDrugList(ArrayList<DrugOrderItemDTO> drugList) {
        this.drugList = drugList;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public Integer getPharmacyId() {
        return pharmacyId;
    }

    public void setPharmacyId(Integer pharmacyId) {
        this.pharmacyId = pharmacyId;
    }



    public LocalDate getTimeLimit() {
        return timeLimit;
    }

    public void setTimeLimit(LocalDate timeLimit) {
        this.timeLimit = timeLimit;
    }

    @Override
    public String toString() {
        return "DrugOrderAndItemDTO{" +
                "idOrder=" + idOrder +
                ", pharmacyName='" + pharmacyName + '\'' +
                ", pharmacyId=" + pharmacyId +
                ", drugList=" + drugList +
                ", timeLimit=" + timeLimit +
                '}';
    }
}
