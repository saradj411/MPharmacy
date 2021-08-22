package com.isaProject.isa.Model.Pharmacy;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Users.Patient;

import javax.persistence.*;

@Entity
@Table
public class Complaint {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idComplaint;

    //tekst zalbe (slobodna forma)
    @Column
    private String text;

    @Column
    private Boolean isAnswered;

    @OneToOne(mappedBy="complaint")
    private ComplaintAnswer answer;

    @ManyToOne(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "patientId", referencedColumnName = "id")
    //@JsonBackReference
    private Patient patient;

    public Complaint(String text, Boolean isAnswered, ComplaintAnswer answer, Patient patient) {
        this.text = text;
        this.isAnswered = isAnswered;
        this.answer = answer;
        this.patient = patient;
    }

    public  Complaint(){}

    public Integer getIdComplaint() {
        return idComplaint;
    }

    public void setIdComplaint(Integer idComplaint) {
        this.idComplaint = idComplaint;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    public Boolean getAnswered() {
        return isAnswered;
    }

    public void setAnswered(Boolean answered) {
        isAnswered = answered;
    }

    public ComplaintAnswer getAnswer() {
        return answer;
    }

    public void setAnswer(ComplaintAnswer answer) {
        this.answer = answer;
    }

    public Patient getPatient() {
        return patient;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Complaint(Integer idComplaint, String text, Boolean isAnswered, ComplaintAnswer answer, Patient patient) {
        this.idComplaint = idComplaint;
        this.text = text;
        this.isAnswered = isAnswered;
        this.answer = answer;
        this.patient = patient;
    }
//staff


}

/*---odgovara na žalbe korisnika

----Korisnik može da piše žalbu za:
● dermatologa (samo ukoliko je imao održan bar jedan pregled kod tog
dermatologa),
● farmaceuta (samo ukoliko je imao održano bar jedno savetovanje kod tog
farmaceuta),
● apoteku (samo ukoliko je bar jednom rezervisao i preuzeo lek ili mu je
prepisan putem eRecepta ili je imao održan bar jedan pregled ili jedno
savetovanje u toj apoteci).



*/