package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;

import javax.persistence.*;
import java.time.LocalDate;

public class DrugReservationDTO {

    //private Integer quantity;
    //private Integer idPharmacyDrug;
    private Integer patient;


    private Integer drug;

    private Integer pharmacy;

    private LocalDate pickUpDate;

    public DrugReservationDTO(Integer patient, Integer drug, Integer pharmacy, LocalDate pickUpDate) {
        this.patient = patient;
        this.drug = drug;
        this.pharmacy = pharmacy;
        this.pickUpDate = pickUpDate;
    }

    public DrugReservationDTO() {
    }

    /*public DrugReservationDTO(Integer idPharmacyDrug, Integer patient, Integer drug, Integer pharmacy, LocalDate pickUpDate) {
        this.idPharmacyDrug = idPharmacyDrug;
        this.patient = patient;
        this.drug = drug;
        this.pharmacy = pharmacy;
        this.pickUpDate = pickUpDate;
    }*/

    public Integer getPatient() {
        return patient;
    }

    public void setPatient(Integer patient) {
        this.patient = patient;
    }

    public Integer getDrug() {
        return drug;
    }

    public void setDrug(Integer drug) {
        this.drug = drug;
    }

    public Integer getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Integer pharmacy) {
        this.pharmacy = pharmacy;
    }

    public LocalDate getPickUpDate() {
        return pickUpDate;
    }

    public void setPickUpDate(LocalDate pickUpDate) {
        this.pickUpDate = pickUpDate;
    }

    /*public Integer getIdPharmacyDrug() {
        return idPharmacyDrug;
    }

    public void setIdPharmacyDrug(Integer idPharmacyDrug) {
        this.idPharmacyDrug = idPharmacyDrug;
    }*/
}
