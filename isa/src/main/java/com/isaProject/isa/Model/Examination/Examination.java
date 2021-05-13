package com.isaProject.isa.Model.Examination;


import javax.persistence.*;
import java.util.Date;

@Entity
@Table
public class Examination {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private Date startDateTime;

    @Column
    private Date endDateTime;

    @Column
    private double price;


   /*
      vreme i trajanje
●*/

}
