package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table
public class RequestForVacation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private LocalDate start;

    @Column
    private LocalDate end;

    //prihvacen,odbijen
    @Column
    private Boolean accepted;

    //razlog za odbijanje
    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "idUser", nullable = false)
    //@JsonManagedReference
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = false)
    //@JsonManagedReference
    private Pharmacy pharmacy;

    public RequestForVacation() {

    }

    public RequestForVacation(Integer id, LocalDate start, LocalDate end, Boolean accepted, String description, Staff staff, Pharmacy pharmacy) {
        this.id = id;
        this.start = start;
        this.end = end;
        this.accepted = accepted;
        this.description = description;
        this.staff = staff;
        this.pharmacy = pharmacy;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public Boolean getAccepted() {
        return accepted;
    }

    public void setAccepted(Boolean accepted) {
        this.accepted = accepted;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Staff getStaff() {
        return staff;
    }

    public void setStaff(Staff staff) {
        this.staff = staff;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
