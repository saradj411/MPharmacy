package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;

import java.time.LocalDate;
import java.time.LocalTime;

public class ExaminationDTO {
     private Integer idPatient;
     private Integer idStaff;
     private Integer idPharm;
     private String name;
     private LocalDate date;
     private LocalTime start;
     private LocalTime end;
     private double price;

     public String getName() {
          return name;
     }

     public void setName(String name) {
          this.name = name;
     }

     public ExaminationDTO(Integer idPatient, Integer idStaff, String name, LocalDate date, LocalTime start, LocalTime end) {
          this.idPatient = idPatient;
          this.idStaff = idStaff;
          this.name = name;
          this.date = date;
          this.start = start;
          this.end = end;
     }

     public ExaminationDTO(Integer idPatient, Integer idStaff, Integer idPharm, LocalDate date, LocalTime start, LocalTime end, double price) {
          this.idPatient = idPatient;
          this.idStaff = idStaff;
          this.idPharm = idPharm;
          this.date = date;
          this.start = start;
          this.end = end;
          this.price = price;
     }

     public ExaminationDTO() {
     }

     public Integer getIdPatient() {
          return idPatient;
     }

     public void setIdPatient(Integer idPatient) {
          this.idPatient = idPatient;
     }

     public Integer getIdStaff() {
          return idStaff;
     }

     public void setIdStaff(Integer idStaff) {
          this.idStaff = idStaff;
     }

     public Integer getIdPharm() {
          return idPharm;
     }

     public void setIdPharm(Integer idPharm) {
          this.idPharm = idPharm;
     }

     public LocalDate getDate() {
          return date;
     }

     public void setDate(LocalDate date) {
          this.date = date;
     }

     public LocalTime getStart() {
          return start;
     }

     public void setStart(LocalTime start) {
          this.start = start;
     }

     public LocalTime getEnd() {
          return end;
     }

     public void setEnd(LocalTime end) {
          this.end = end;
     }

     public double getPrice() {
          return price;
     }

     public void setPrice(double price) {
          this.price = price;
     }
}
