package com.isaProject.isa.Model.Pharmacy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Users.Patient;

import javax.persistence.*;

@Entity
@Table
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idComplaint;

    //tekst zalbe (slobodna forma)
    @Column
    private String text;

    @Column
    private Boolean isAnswered;

    @OneToOne(mappedBy="complaint")
    private ComplaintAnswer answer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    @JsonBackReference
    private Patient patient;

    //staff


}

/*---odgovara na žalbe korisnika

----Korisnik može da piše žalbu za:
● dermatologa (samo ukoliko je imao održan bar jedan pregled kod tog
dermatologa),
● farmaceuta (samo ukoliko je imao održano bar jedno savetovanje kod tog
farmaceuta),
● apoteku (samo ukoliko je bar jednom rezervisao i preuzeo lek ili mu je
prepisan putem eRecepta ili je imao održan bar jedan pregled ili jedno
savetovanje u toj apoteci).



*/