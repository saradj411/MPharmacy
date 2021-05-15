package com.isaProject.isa.Model.Examination;


import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Date;

@Entity
@Table
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idExamination;

    @Column
    private Date date;

    @Column
    private LocalTime startTime;

    @Column
    private LocalTime endTime;

    @Column
    private double price;

    //inf o pregledu
    @Column
    private String report;

    //isSheduled true znaci zakazan je vec,
    // a false samo je kreiran od strane admina i pacijent ga moze zakazati
    @Column
    private Boolean isScheduled;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "pharmacyId", referencedColumnName = "idPharm")
    private Pharmacy pharmacy;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "patient", referencedColumnName = "idUser")
    private Patient patient;

    @ManyToOne
    @JoinColumn(name = "staffId", referencedColumnName = "idUser")
    private Staff staff;

    //kod dermatologa, kod farmaceuta
    @Column
    @Enumerated(EnumType.STRING)
    private ExaminationType type;

    //CREATED,SCHEDULED,CANCELED,FINISHED,EXPIRED
    @Column
    @Enumerated(EnumType.STRING)
    private ExaminationStatus status;

    @ManyToOne(fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    @JoinColumn(name = "therapyId", referencedColumnName = "idTherapy")
    private Therapy therapy;

}
  /*
---stranicu za započinjanje pregleda i unos informacija o pregledu gde može
da postavlja dijagnozu i preporučuje terapiju (lekove) klijentu

--- Dermatolog može da pristupi specifikaciji leka i da definiše trajanje terapije u danima.
---, a dermatologu se pruža mogućnost da pacijentu prepiše neki od zamenskih lekova
(ukoliko pacijent nije alergičan).

----3.27. Korak 5. Nakon popunjenog i sačuvanog izveštaja, sve promene koje su unete
od strane dermatologa, trajno se beleže pod istorijom poseta dermatolgu kod
korisnika. Ažurira se stanje leka u apoteci.



●*/
