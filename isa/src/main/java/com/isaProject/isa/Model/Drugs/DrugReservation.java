package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table
//@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class DrugReservation implements Serializable {
       @Id
       @GeneratedValue(strategy = GenerationType.AUTO)
       private Integer idReservation;

       //da li je preuzet lijek
       @Column
       private Boolean isPickedUp;

       //da li je otkazan
       @Column(name = "cancelled", nullable = true)
       private Boolean cancelled;

       @Column
       private Boolean expired;

       @Column
       private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientId", referencedColumnName = "id", nullable = true, unique = false)
    //@JsonManagedReference
    private Patient patient;

   // @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    //@JsonManagedReference
    @JoinColumn(name = "drugId", referencedColumnName = "idDrug", nullable = true, unique = false)
    private Drug drug;

   //@JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = true, unique = false)
    //@JsonManagedReference
    private Pharmacy pharmacy;


    @Column
    private LocalDate dateOfReservation;

    //do kog datuma će preuzeti lek
    @Column
    private LocalDate pickUpDate;

 public DrugReservation() {
 }

 public DrugReservation(Integer idReservation, Boolean isPickedUp, Boolean cancelled, Integer quantity, Patient patient, Drug drug, Pharmacy pharmacy, LocalDate dateOfReservation, LocalDate pickUpDate) {
  this.idReservation = idReservation;
  this.isPickedUp = isPickedUp;
  this.cancelled = cancelled;
  this.quantity = quantity;
  this.patient = patient;
  this.drug = drug;
  this.pharmacy = pharmacy;
  this.dateOfReservation = dateOfReservation;
  this.pickUpDate = pickUpDate;
 }

 public Integer getIdReservation() {
  return idReservation;
 }

 public void setIdReservation(Integer idReservation) {
  this.idReservation = idReservation;
 }

 public Boolean getPickedUp() {
  return isPickedUp;
 }

 public void setPickedUp(Boolean pickedUp) {
  isPickedUp = pickedUp;
 }

 public Boolean getCancelled() {
  return cancelled;
 }

 public void setCancelled(Boolean cancelled) {
  this.cancelled = cancelled;
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

 public Pharmacy getPharmacy() {
  return pharmacy;
 }

 public void setPharmacy(Pharmacy pharmacy) {
  this.pharmacy = pharmacy;
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

 public Patient getPatient() {
  return patient;
 }

 public void setPatient(Patient patient) {
  this.patient = patient;
 }

 public Boolean getExpired() {
  return expired;
 }

 public void setExpired(Boolean expired) {
  this.expired = expired;
 }

    /* 3.19. Postupak rezervacije leka
Korisnik pretragom pronalazi lek i bira iz koje apoteke rezerviše lek. Prilikom
rezervacije, bira do kog datuma će preuzeti lek.
Svaka potvrda koja se šalje korisniku na mail sadrži jedinstveni broj rezervacije.

     */
}
