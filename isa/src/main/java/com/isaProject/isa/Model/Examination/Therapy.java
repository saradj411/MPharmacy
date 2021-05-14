package com.isaProject.isa.Model.Examination;

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
    private Drug drug;

}
