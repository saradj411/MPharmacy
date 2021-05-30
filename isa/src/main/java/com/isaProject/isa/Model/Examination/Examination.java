package com.isaProject.isa.Model.Examination;


import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idExamination;

    @Column
    private Date date;

    @Column
    private boolean canceled;

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




    @ManyToOne(fetch = FetchType.EAGER,cascade = CascadeType.MERGE)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm")
    @JsonBackReference
    private Pharmacy pharmacy;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.MERGE)
    @JoinColumn(name = "patient", referencedColumnName = "id")
    @JsonBackReference
    private Patient patient;

    @ManyToOne(cascade = CascadeType.MERGE)
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
    @JsonBackReference
    private Therapy therapy;

    public Integer getIdExamination() {
        return idExamination;
    }

    public boolean isCanceled() {
        return canceled;
    }

    public void setCanceled(boolean canceled) {
        this.canceled = canceled;
    }

    public Date getDate() {
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

    public void setDate(Date date) {
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

    public Examination(Integer idExamination, Date date, LocalTime startTime, LocalTime endTime, double price, String report, Boolean isScheduled, Pharmacy pharmacy, Patient patient, Staff staff, ExaminationType type, ExaminationStatus status, Therapy therapy) {
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

    public Examination(Integer idExamination, Date date, boolean canceled, LocalTime startTime, LocalTime endTime, double price, String report, Boolean isScheduled, Pharmacy pharmacy, Patient patient, Staff staff, ExaminationType type, ExaminationStatus status, Therapy therapy) {
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
