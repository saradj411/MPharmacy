package com.isaProject.isa.Model.Examination;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Drugs.Drug;

import javax.persistence.*;

@Entity
@Table
public class Therapy {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idTherapy;

    @ManyToOne
    @JoinColumn(name = "drugId", referencedColumnName = "idDrug")
    //@JsonManagedReference
    private Drug drug;

    @Column
    private Integer numberOfDay;

    public Therapy(Drug drug, Integer numberOfDay) {
        this.drug = drug;
        this.numberOfDay = numberOfDay;
    }

    public Therapy(Integer idTherapy, Drug drug, Integer numberOfDay) {
        this.idTherapy = idTherapy;
        this.drug = drug;
        this.numberOfDay = numberOfDay;
    }

    public Therapy() {
    }

    public Integer getIdTherapy() {
        return idTherapy;
    }

    public void setIdTherapy(Integer idTherapy) {
        this.idTherapy = idTherapy;
    }

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public Integer getNumberOfDay() {
        return numberOfDay;
    }

    public void setNumberOfDay(Integer numberOfDay) {
        this.numberOfDay = numberOfDay;
    }
}
