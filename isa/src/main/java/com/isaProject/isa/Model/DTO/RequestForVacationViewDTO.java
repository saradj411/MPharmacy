package com.isaProject.isa.Model.DTO;

import javax.persistence.Column;
import java.time.LocalDate;

public class RequestForVacationViewDTO {



    private LocalDate start;


    private LocalDate end;



    private String nameStaff;

    private String surnameStaff;

    private String pharmacyName;


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


    public String getNameStaff() {
        return nameStaff;
    }

    public void setNameStaff(String nameStaff) {
        this.nameStaff = nameStaff;
    }

    public String getSurnameStaff() {
        return surnameStaff;
    }

    public void setSurnameStaff(String surnameStaff) {
        this.surnameStaff = surnameStaff;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }


    public RequestForVacationViewDTO() {
    }

    public RequestForVacationViewDTO(LocalDate start, LocalDate end, String nameStaff, String surnameStaff, String pharmacyName) {
        this.start = start;
        this.end = end;
        this.nameStaff = nameStaff;
        this.surnameStaff = surnameStaff;
        this.pharmacyName = pharmacyName;
    }
}
