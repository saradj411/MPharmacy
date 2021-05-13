package com.isaProject.isa.Model.Users;

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

    //odmor
    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    private Set<Vacation> vacation = new HashSet<Vacation>();
}
