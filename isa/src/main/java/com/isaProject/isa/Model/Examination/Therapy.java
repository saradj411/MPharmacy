package com.isaProject.isa.Model.Examination;

import com.fasterxml.jackson.annotation.JsonBackReference;
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
    @JsonBackReference
    private Drug drug;

}
