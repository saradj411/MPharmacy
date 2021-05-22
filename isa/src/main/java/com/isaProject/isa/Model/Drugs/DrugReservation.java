package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class DrugReservation {
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
    private Integer quantity;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name = "patientId", referencedColumnName = "idUser", nullable = true, unique = false)
    @JsonBackReference
    private Patient patient;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonBackReference
    @JoinColumn(name = "drugId", referencedColumnName = "idDrug", nullable = true, unique = false)
    private Drug drug;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = true, unique = false)
    @JsonBackReference
    private Pharmacy pharmacy;


    @Column
    private Date dateOfReservation;

    //do kog datuma će preuzeti lek
    @Column
    private Date pickUpDate;

    /* 3.19. Postupak rezervacije leka
Korisnik pretragom pronalazi lek i bira iz koje apoteke rezerviše lek. Prilikom
rezervacije, bira do kog datuma će preuzeti lek.
Svaka potvrda koja se šalje korisniku na mail sadrži jedinstveni broj rezervacije.

     */
}
