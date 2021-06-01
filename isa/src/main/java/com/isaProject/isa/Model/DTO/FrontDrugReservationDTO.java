package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;

import javax.persistence.*;
import java.time.LocalDate;

public class FrontDrugReservationDTO {

    private Integer idReservation;

    private Integer quantity;

    private String drugName;

    private String pharmacyName;

    private LocalDate dateOfReservation;

    private LocalDate pickUpDate;

    public FrontDrugReservationDTO(Integer idReservation, Integer quantity, String drugName, String pharmacyName, LocalDate dateOfReservation, LocalDate pickUpDate) {
        this.idReservation = idReservation;
        this.quantity = quantity;
        this.drugName = drugName;
        this.pharmacyName = pharmacyName;
        this.dateOfReservation = dateOfReservation;
        this.pickUpDate = pickUpDate;
    }

    public FrontDrugReservationDTO() {
    }

    public Integer getIdReservation() {
        return idReservation;
    }

    public void setIdReservation(Integer idReservation) {
        this.idReservation = idReservation;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public LocalDate getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(LocalDate dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }
}
