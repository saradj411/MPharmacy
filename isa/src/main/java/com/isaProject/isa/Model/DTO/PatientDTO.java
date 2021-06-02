package com.isaProject.isa.Model.DTO;

import org.springframework.stereotype.Component;

import java.io.Serializable;

public class PatientDTO  {
    private  Integer id;

    private String email;

    private String firstname;

    private String surname;

    private String phonenumber;

    public PatientDTO() {
    }

    public PatientDTO(Integer id, String email, String firstname, String surname, String phonenumber) {
        this.id = id;
        this.email = email;
        this.firstname = firstname;
        this.surname = surname;
        this.phonenumber = phonenumber;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getPhonenumber() {
        return phonenumber;
    }

    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
    }
}
