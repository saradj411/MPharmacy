package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Vacation;
import com.isaProject.isa.Model.Users.WorkTime;
import org.hibernate.jdbc.Work;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class DermatologistDTO {
    private String name;

    private String surname;

    private String email;

    private String password;

    private String address;

    private String phoneNumber;

    private String city;

    private String country;

    private double avgGrade;

    //radno vrijeme
    private Set<WorkTime> workTime = new HashSet<WorkTime>();

    //savetovanja farmacut,pregledi dermatolog
    private Set<Examination> examinations = new HashSet<Examination>();

    //odmor
    private Set<Vacation> vacation = new HashSet<Vacation>();

    //apoteke u kojima je zaposlen
    private Set<Pharmacy> pharmacies = new HashSet<>();

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getStartTime() {
        return startTime;
    }

    public void setStartTime(LocalTime startTime) {
        this.startTime = startTime;
    }

    public LocalTime getEndTime() {
        return endTime;
    }

    public void setEndTime(LocalTime endTime) {
        this.endTime = endTime;
    }

    public Integer getPharmacyID() {
        return pharmacyID;
    }

    public void setPharmacyID(Integer pharmacyID) {
        this.pharmacyID = pharmacyID;
    }

    private LocalDate date;
    private LocalTime startTime;
    private LocalTime endTime;
    private Integer pharmacyID;

    Pharmacy pharmacy;

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

    public Set<Pharmacy> getPharmacies() {
        return pharmacies;
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

    public void setPharmacies(Set<Pharmacy> pharmacies) {
        this.pharmacies = pharmacies;
    }

    public DermatologistDTO(){}

    public DermatologistDTO(String name, String surname, String email, String password, String address, String phoneNumber, String city, String country, double avgGrade, Set<WorkTime> workTime, Set<Examination> examinations, Set<Vacation> vacation,Pharmacy pharmacy) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.avgGrade = avgGrade;
        this.workTime = workTime;
        this.examinations = examinations;
        this.vacation = vacation;
        this.pharmacy = pharmacy;
    }

    public DermatologistDTO(String name, String surname, String email, String address, String phoneNumber, String city, String country, double avgGrade, Set<WorkTime> workTime) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.avgGrade = avgGrade;
        this.workTime = workTime;
    }
    public DermatologistDTO(String name, String surname, String email, String address, String phoneNumber, String city, String country, double avgGrade, LocalDate date, LocalTime startTime, LocalTime endTime, Integer pharmacyID) {
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.avgGrade = avgGrade;
        this.date = date;
        this.startTime = startTime;
        this.endTime = endTime;
        this.pharmacyID = pharmacyID;

    }


    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    @Override
    public String toString() {
        return "DermatologistDTO{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", email='" + email + '\'' +
                ", password='" + password + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", city='" + city + '\'' +
                ", country='" + country + '\'' +
                ", avgGrade=" + avgGrade +
                ", workTime=" + workTime +
                ", examinations=" + examinations +
                ", vacation=" + vacation +
                ", pharmacies=" + pharmacies +
                ", pharmacy=" + pharmacy +
                '}';
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }
}
