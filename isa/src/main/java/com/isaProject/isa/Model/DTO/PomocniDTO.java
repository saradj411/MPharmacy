package com.isaProject.isa.Model.DTO;

import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalTime;

@NoArgsConstructor
public class PomocniDTO {
    private Integer idPharmacy;
    private LocalDate date;
    private LocalTime time;


    public PomocniDTO(Integer idPharmacy, LocalDate date, LocalTime time) {
        this.idPharmacy = idPharmacy;
        this.date = date;
        this.time = time;
    }

    public Integer getIdPharmacy() {
        return idPharmacy;
    }

    public void setIdPharmacy(Integer idPharmacy) {
        this.idPharmacy = idPharmacy;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public LocalTime getTime() {
        return time;
    }

    public void setTime(LocalTime time) {
        this.time = time;
    }
}
