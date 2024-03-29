package com.isaProject.isa.Model.Examination;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;

@Entity
@Table
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idExamination;

    @Column
    private LocalDate date;

    @Column
    private Boolean canceled;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @Column
    private double price;

    //inf o pregledu
    @Column
    private String report;

    //isSheduled true znaci zakazan je vec,
    // a false samo je kreiran od strane admina i pacijent ga moze zakazati
    @Column
    private Boolean isScheduled;

//eager
    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm")
    //@JsonManagedReference
    private Pharmacy pharmacy;

    //@JsonIgnore
    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient", referencedColumnName = "id")
    //@JsonBackReference
    private Patient patient;

//    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
//    @JoinColumn(name = "staffId", referencedColumnName = "idUser")
//    //@JsonBackReference
   // @JsonIgnore
    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "staffId", referencedColumnName = "id")
    @JsonBackReference
    private Staff staff;

    //kod dermatologa, kod farmaceuta
    @Column
    @Enumerated(EnumType.STRING)
    private ExaminationType type;

    //CREATED,SCHEDULED,CANCELED,FINISHED,EXPIRED
    @Column
    @Enumerated(EnumType.STRING)
    private ExaminationStatus status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "therapyId", referencedColumnName = "idTherapy")
//@JsonManagedReference
    private Therapy therapy;

    private Integer pointsForExamination;

    public Integer getIdExamination() {
        return idExamination;
    }

    public Boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(Boolean canceled) {
        this.canceled = canceled;
    }

    public LocalDate getDate() {
        return date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public double getPrice() {
        return price;
    }

    public String getReport() {
        return report;
    }

    public Boolean getScheduled() {
        return isScheduled;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public Patient getPatient() {
        return patient;
    }

    public Staff getStaff() {
        return staff;
    }

    public ExaminationType getType() {
        return type;
    }

    public ExaminationStatus getStatus() {
        return status;
    }

    public Therapy getTherapy() {
        return therapy;
    }

    public void setIdExamination(Integer idExamination) {
        this.idExamination = idExamination;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public void setReport(String report) {
        this.report = report;
    }

    public void setScheduled(Boolean scheduled) {
        isScheduled = scheduled;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public void setType(ExaminationType type) {
        this.type = type;
    }

    public void setStatus(ExaminationStatus status) {
        this.status = status;
    }

    public void setTherapy(Therapy therapy) {
        this.therapy = therapy;
    }

    public Examination(Integer idExamination, LocalDate date, LocalTime startTime, LocalTime endTime, double price, String report, Boolean isScheduled, Pharmacy pharmacy, Patient patient, Staff staff, ExaminationType type, ExaminationStatus status, Therapy therapy) {
        this.idExamination = idExamination;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.report = report;
        this.isScheduled = isScheduled;
        this.pharmacy = pharmacy;
        this.patient = patient;
        this.staff = staff;
        this.type = type;
        this.status = status;
        this.therapy = therapy;
    }

    public Examination(Integer idExamination, LocalDate date, Boolean canceled, LocalTime startTime, LocalTime endTime, double price, String report, Boolean isScheduled, Pharmacy pharmacy, Patient patient, Staff staff, ExaminationType type, ExaminationStatus status, Therapy therapy, Integer pointsForExamination) {
        this.idExamination = idExamination;
        this.date = date;
        this.canceled = canceled;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.report = report;
        this.isScheduled = isScheduled;
        this.pharmacy = pharmacy;
        this.patient = patient;
        this.staff = staff;
        this.type = type;
        this.status = status;
        this.therapy = therapy;
        this.pointsForExamination = pointsForExamination;
    }

    public Examination(Integer idExamination, LocalDate date, boolean canceled, LocalTime startTime, LocalTime endTime, double price, String report, Boolean isScheduled, Pharmacy pharmacy, Patient patient, Staff staff, ExaminationType type, ExaminationStatus status, Therapy therapy) {
        this.idExamination = idExamination;
        this.date = date;
        this.canceled = canceled;
        this.startTime = startTime;
        this.endTime = endTime;
        this.price = price;
        this.report = report;
        this.isScheduled = isScheduled;
        this.pharmacy = pharmacy;
        this.patient = patient;
        this.staff = staff;
        this.type = type;
        this.status = status;
        this.therapy = therapy;
    }
    public Examination(){

    }

    public Integer getPointsForExamination() {
        return pointsForExamination;
    }

    public void setPointsForExamination(Integer pointsForExamination) {
        this.pointsForExamination = pointsForExamination;
    }

    public Boolean getCanceled() {
        return canceled;
    }
}
  /*
---stranicu za započinjanje pregleda i unos informacija o pregledu gde može
da postavlja dijagnozu i preporučuje terapiju (lekove) klijentu

--- Dermatolog može da pristupi specifikaciji leka i da definiše trajanje terapije u danima.
---, a dermatologu se pruža mogućnost da pacijentu prepiše neki od zamenskih lekova
(ukoliko pacijent nije alergičan).

----3.27. Korak 5. Nakon popunjenog i sačuvanog izveštaja, sve promene koje su unete
od strane dermatologa, trajno se beleže pod istorijom poseta dermatolgu kod
korisnika. Ažurira se stanje leka u apoteci.



●*/
