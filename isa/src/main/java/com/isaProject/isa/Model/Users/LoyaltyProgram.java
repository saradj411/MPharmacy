package com.isaProject.isa.Model.Users;

import javax.persistence.*;

@Entity
@Table
public class LoyaltyProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProgram;

    @Column
    private int pointsForDrug;

    @Column
    private int pointsForDermatologistExamination;

    @Column
    private int pointsForPharmacistExamination;

//poeni za svaku od kategorije
    @Column
    private int pointsToRegular;

    @Column
    private int pointsToSilver;

    @Column
    private int pointsToGold;

   //popusti nzm


}
