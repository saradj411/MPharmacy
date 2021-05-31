package com.isaProject.isa.Model.Pharmacy;

import javax.persistence.*;

@Entity
@Table
public class ComplaintAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnswer;

    @Column
    private String textAnswer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "complaintId", referencedColumnName = "idComplaint")
    private Complaint complaint;
}
/*
    Administrator sistema vidi sve žalbe na koje može da odgovori. Odgovor se
    unosi u slobodnoj formi i šalje se korisniku na mail.
 */