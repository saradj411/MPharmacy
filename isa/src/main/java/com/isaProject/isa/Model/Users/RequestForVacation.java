package com.isaProject.isa.Model.Users;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class RequestForVacation {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date start;

    @Column
    private Date end;

    //prihvacen,odbijen
    @Column
    private Boolean accepted;

    //razlog za odbijanje
    @Column
    private String description;

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "idUser", nullable = false)
    private Staff staff;

    @ManyToOne
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm", nullable = false)
    private Pharmacy pharmacy;



}
