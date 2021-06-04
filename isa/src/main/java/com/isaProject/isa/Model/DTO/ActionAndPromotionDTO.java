package com.isaProject.isa.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.util.Date;

public class ActionAndPromotionDTO {


    private Date startDate;


    private Date endDate;

    //Administrator apoteke u slobodnoj formi definiše akciju, odnosno promociju.

    private String text;


    private String pharmacyName;


    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public ActionAndPromotionDTO(Date startDate, Date endDate, String text, String pharmacyName) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.text = text;
        this.pharmacyName = pharmacyName;
    }

    public ActionAndPromotionDTO() {
    }
}
