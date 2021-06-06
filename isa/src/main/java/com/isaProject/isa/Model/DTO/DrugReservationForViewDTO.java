package com.isaProject.isa.Model.DTO;

import java.time.LocalDate;

public class DrugReservationForViewDTO {


    private String patientName;

    private String patientSurname;

    private String drugName;


    private Integer quantity;

    private LocalDate dateOfReservation;

    public String getPatientName() {
        return patientName;
    }

    public void setPatientName(String patientName) {
        this.patientName = patientName;
    }

    public String getPatientSurname() {
        return patientSurname;
    }

    public void setPatientSurname(String patientSurname) {
        this.patientSurname = patientSurname;
    }

    public String getDrugName() {
        return drugName;
    }

    public void setDrugName(String drugName) {
        this.drugName = drugName;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public LocalDate getDateOfReservation() {
        return dateOfReservation;
    }

    public void setDateOfReservation(LocalDate dateOfReservation) {
        this.dateOfReservation = dateOfReservation;
    }


    public DrugReservationForViewDTO(String patientName, String patientSurname, String drugName, Integer quantity, LocalDate dateOfReservation) {
        this.patientName = patientName;
        this.patientSurname = patientSurname;
        this.drugName = drugName;
        this.quantity = quantity;
        this.dateOfReservation = dateOfReservation;
    }
}
