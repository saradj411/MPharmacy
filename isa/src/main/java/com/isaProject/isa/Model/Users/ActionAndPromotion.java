package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class ActionAndPromotion {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idAction;

    @Column
    private Date startDate;

    @Column
    private Date endDate;

    //Administrator apoteke u slobodnoj formi definiše akciju, odnosno promociju.
    @Column
    private String text;

    @ManyToOne
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm")
    @JsonBackReference
    private Pharmacy pharmacy;

    public Integer getIdAction() {
        return idAction;
    }

    public void setIdAction(Integer idAction) {
        this.idAction = idAction;
    }

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

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public ActionAndPromotion(Integer idAction, Date startDate, Date endDate, String text, Pharmacy pharmacy) {
        this.idAction = idAction;
        this.startDate = startDate;
        this.endDate = endDate;
        this.text = text;
        this.pharmacy = pharmacy;
    }

    public ActionAndPromotion() {
    }
}
