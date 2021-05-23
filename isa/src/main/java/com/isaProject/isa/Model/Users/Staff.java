package com.isaProject.isa.Model.Users;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
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
    //@JsonBackReference
    private Set<WorkTime> workTime = new HashSet<WorkTime>();

    //savetovanja farmacut,pregledi dermatolog
    @OneToMany(mappedBy = "staff",fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<Examination> examinations = new HashSet<Examination>();

    //odmor
    @OneToMany(mappedBy = "staff", fetch = FetchType.LAZY,cascade = CascadeType.ALL)
    //@JsonManagedReference
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

    public double getAvgGrade() {
        return avgGrade;
    }

    public Set<WorkTime> getWorkTime() {
        return workTime;
    }

    public Set<Examination> getExaminations() {
        return examinations;
    }

    public Set<Vacation> getVacation() {
        return vacation;
    }

    public void setAvgGrade(double avgGrade) {
        this.avgGrade = avgGrade;
    }

    public void setWorkTime(Set<WorkTime> workTime) {
        this.workTime = workTime;
    }

    public void setExaminations(Set<Examination> examinations) {
        this.examinations = examinations;
    }

    public void setVacation(Set<Vacation> vacation) {
        this.vacation = vacation;
    }
}
