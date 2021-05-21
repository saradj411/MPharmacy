package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Vacation;
import com.isaProject.isa.Model.Users.WorkTime;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

public class PharmaceutDTO {

    private String name;

    private String surname;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private String city;

    private String country;


    private Pharmacy pharmacy;


    private double avgGrade;

    //radno vrijeme
    private Set<WorkTime> workTime = new HashSet<WorkTime>();

    //savetovanja farmacut,pregledi dermatolog
    private Set<Examination> examinations = new HashSet<Examination>();

    //odmor
    private Set<Vacation> vacation = new HashSet<Vacation>();


    public PharmaceutDTO(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, Pharmacy pharmacy, double avgGrade, Set<WorkTime> workTime, Set<Examination> examinations, Set<Vacation> vacation) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.pharmacy = pharmacy;
        this.avgGrade = avgGrade;
        this.workTime = workTime;
        this.examinations = examinations;
        this.vacation = vacation;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
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

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getEmail() {
        return email;
    }

    public String getPassword() {
        return password;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public String getCountry() {
        return country;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
