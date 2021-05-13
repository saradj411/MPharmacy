package com.isaProject.isa.Model.Drugs;

import javax.persistence.*;

@Entity
@Table
public class Drug {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;
    @Column
    private String name;
    @Column
    private String code;
    @Column
    private String issuanceRegime;

    /*
    * Lek od podataka treba da sadrži minimalno:
● Šifru--
● Vrstu leka
● Oblik leka (prašak, kapsula, tableta, mast, pasta, gel, rastvor, sirup,...)
● Sastav
● Proizvođača
● Režim izdavanja (na recept, bez recepta)---
● Šifre zamenskih lekova
● Dodatne napomene
Podatke možete uzeti sa
https://www.alims.gov.rs/ciril/lekovi/pretrazivanje-humanih-lekova/?text=Хумани
%20лекови
*/
}
