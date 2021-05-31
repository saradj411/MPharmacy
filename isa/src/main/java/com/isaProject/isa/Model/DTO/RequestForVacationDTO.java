package com.isaProject.isa.Model.DTO;

import javax.persistence.Column;
import java.time.DateTimeException;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class RequestForVacationDTO {

    private LocalDate start;

    private LocalDate end;
    private Integer idStaff;


    private String description;

    public RequestForVacationDTO() {
    }

    public RequestForVacationDTO(LocalDate start, LocalDate end, Integer idStaff, String description) {
        this.start = start;
        this.end = end;
        this.idStaff = idStaff;
        this.description = description;
    }

    public Integer getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public LocalDate getStart() {
        return start;
    }

    public void setStart(LocalDate start) {
        this.start = start;
    }

    public LocalDate getEnd() {
        return end;
    }

    public void setEnd(LocalDate end) {
        this.end = end;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
