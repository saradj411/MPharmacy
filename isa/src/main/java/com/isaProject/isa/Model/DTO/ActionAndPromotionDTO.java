package com.isaProject.isa.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import java.time.LocalDate;
import java.util.Date;

public class ActionAndPromotionDTO {


    private LocalDate startDate;


    private LocalDate endDate;

    //Administrator apoteke u slobodnoj formi definiše akciju, odnosno promociju.

    private String text;


    private Integer idPham;


    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Integer getIdPham() {
        return idPham;
    }

    public void setIdPham(Integer idPham) {
        this.idPham = idPham;
    }

    public ActionAndPromotionDTO(LocalDate startDate, LocalDate endDate, String text, Integer idPham) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.text = text;
        this.idPham = idPham;
    }

    public ActionAndPromotionDTO() {
    }
}
