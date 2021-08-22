package com.isaProject.isa.Model.Pharmacy;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;

@Entity
@Table
public class ComplaintAnswer {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long idAnswer;

    @Column
    private String textAnswer;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "complaintId", referencedColumnName = "idComplaint")
    @JsonBackReference
    private Complaint complaint;


    public ComplaintAnswer(){}
    public ComplaintAnswer(Long idAnswer, String textAnswer, Complaint complaint) {
        this.idAnswer = idAnswer;
        this.textAnswer = textAnswer;
        this.complaint = complaint;
    }

    public Long getIdAnswer() {
        return idAnswer;
    }

    public void setIdAnswer(Long idAnswer) {
        this.idAnswer = idAnswer;
    }

    public String getTextAnswer() {
        return textAnswer;
    }

    public void setTextAnswer(String textAnswer) {
        this.textAnswer = textAnswer;
    }

    public Complaint getComplaint() {
        return complaint;
    }

    public void setComplaint(Complaint complaint) {
        this.complaint = complaint;
    }
}
/*
    Administrator sistema vidi sve žalbe na koje može da odgovori. Odgovor se
    unosi u slobodnoj formi i šalje se korisniku na mail.
 */