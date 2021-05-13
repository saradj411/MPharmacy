package com.isaProject.isa.Model.Users;

import javax.persistence.Column;
import javax.persistence.Entity;

@Entity
public class Patient extends User{

    @Column
    private int penalty;

    @Column
    private int points;

    //kategorija korisnika (npr. Regular, Silver, Gold).
    @Column
    private String loyaltyCategory;

    //Lijekovi na koje je alergican
    //posjeta, zalbe
}
