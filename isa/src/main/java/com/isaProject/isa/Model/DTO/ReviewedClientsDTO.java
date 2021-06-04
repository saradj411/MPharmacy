package com.isaProject.isa.Model.DTO;

import java.time.LocalDate;
import java.time.LocalTime;

public class ReviewedClientsDTO {

    private LocalDate date;
    private String name;
    private String surname;
    private LocalTime start;
    private LocalTime end;

    public ReviewedClientsDTO(LocalDate date, String name, String surname, LocalTime start, LocalTime end) {
        this.date = date;
        this.name = name;
        this.surname = surname;
        this.start = start;
        this.end = end;
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

    public ReviewedClientsDTO() {
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }
}
