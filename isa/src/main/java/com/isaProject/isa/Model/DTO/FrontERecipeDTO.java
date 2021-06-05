package com.isaProject.isa.Model.DTO;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.isaProject.isa.Model.Drugs.ERecipeDrug;
import com.isaProject.isa.Model.Drugs.ERecipeStatus;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class FrontERecipeDTO {

    private Integer idRecipe;

    private String code;

    private String name;

    private String surname;

    private LocalDate dateOfIssue;

    private Set<ERecipeDrug> eRecipeDrug = new HashSet<ERecipeDrug>();

    private String pharmacyName;

    private ERecipeStatus status;

    public FrontERecipeDTO(Integer idRecipe, String code, String name, String surname, LocalDate dateOfIssue, Set<ERecipeDrug> eRecipeDrug, String pharmacyName, ERecipeStatus status) {
        this.idRecipe = idRecipe;
        this.code = code;
        this.name = name;
        this.surname = surname;
        this.dateOfIssue = dateOfIssue;
        this.eRecipeDrug = eRecipeDrug;
        this.pharmacyName = pharmacyName;
        this.status = status;
    }

    public FrontERecipeDTO() {
    }

    public Integer getIdRecipe() {
        return idRecipe;
    }

    public void setIdRecipe(Integer idRecipe) {
        this.idRecipe = idRecipe;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public LocalDate getDateOfIssue() {
        return dateOfIssue;
    }

    public void setDateOfIssue(LocalDate dateOfIssue) {
        this.dateOfIssue = dateOfIssue;
    }

    public Set<ERecipeDrug> geteRecipeDrug() {
        return eRecipeDrug;
    }

    public void seteRecipeDrug(Set<ERecipeDrug> eRecipeDrug) {
        this.eRecipeDrug = eRecipeDrug;
    }

    public String getPharmacyName() {
        return pharmacyName;
    }

    public void setPharmacyName(String pharmacyName) {
        this.pharmacyName = pharmacyName;
    }

    public ERecipeStatus getStatus() {
        return status;
    }

    public void setStatus(ERecipeStatus status) {
        this.status = status;
    }
}
