package com.isaProject.isa.Model.DTO;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DrugOrderDTO {
    private Integer pharmacyAdminEmail;
    private Integer idAdmin;//*********************
    private Date timeLimit;//*******************
    private Set<DrugItemDTO> drugOrderItems = new HashSet<>();//************************
    String idAdminn;
    String timeLimitt;

    public Integer getPharmacyAdminEmail() {
        return pharmacyAdminEmail;
    }

    public Date getTimeLimit() {
        return timeLimit;
    }

    public Set<DrugItemDTO> getDrugOrderItems() {
        return drugOrderItems;
    }

    public void setPharmacyAdminEmail(Integer pharmacyAdminEmail) {
        this.pharmacyAdminEmail = pharmacyAdminEmail;
    }

    public void setTimeLimit(Date timeLimit) {
        this.timeLimit = timeLimit;
    }

    public void setDrugOrderItems(Set<DrugItemDTO> drugOrderItems) {
        this.drugOrderItems = drugOrderItems;
    }

    public DrugOrderDTO(Integer idAdmin, Date timeLimit, Set<DrugItemDTO> drugOrderItems) {//***********************
        this.idAdmin = idAdmin;
        this.timeLimit = timeLimit;
        this.drugOrderItems = drugOrderItems;
    }


    public DrugOrderDTO(Integer idAdmin, Date timeLimit) {
        this.idAdmin = idAdmin;
        this.timeLimit = timeLimit;
        //this.drugOrderItems = drugOrderItems;
    }
    public DrugOrderDTO(String idAdmin, String timeLimit) {
        this.idAdminn = idAdmin;
        this.timeLimitt = timeLimit;
        //this.drugOrderItems = drugOrderItems;
    }



    public DrugOrderDTO(Date timeLimit, Set<DrugItemDTO> drugOrderItems) {
        this.timeLimit = timeLimit;
        this.drugOrderItems = drugOrderItems;
    }

    public Integer getIdAdmin() {
        return idAdmin;
    }

    public void setIdAdmin(Integer idAdmin) {
        this.idAdmin = idAdmin;
    }

    public DrugOrderDTO(Integer pharmacyAdminEmail, Integer idAdmin, Date timeLimit, Set<DrugItemDTO> drugOrderItems) {
        this.pharmacyAdminEmail = pharmacyAdminEmail;
        this.idAdmin = idAdmin;
        this.timeLimit = timeLimit;
        this.drugOrderItems = drugOrderItems;
    }

    public DrugOrderDTO(){

    }
}
