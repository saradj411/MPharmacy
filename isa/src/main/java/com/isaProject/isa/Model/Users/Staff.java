package com.isaProject.isa.Model.Users;

import com.isaProject.isa.Model.Examination.Examination;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Staff extends User{


    //ocjena
    @Column
    private double avgGrade;

    //radno vrijeme
    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<WorkTime> workTime = new HashSet<WorkTime>();

    //savetovanja farmacut,pregledi dermatolog
    @OneToMany(mappedBy = "staff",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Examination> examinations = new HashSet<Examination>();

    //odmor
    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Vacation> vacation = new HashSet<Vacation>();

    public Staff(Integer idUser, String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, double avgGrade, Set<WorkTime> workTime, Set<Examination> examinations, Set<Vacation> vacation) {
        super(idUser, name, surname, email, password, address, phoneNumber, city, country);
        this.avgGrade = avgGrade;
        this.workTime = workTime;
        this.examinations = examinations;
        this.vacation = vacation;
    }

    public Staff() {

    }
}
