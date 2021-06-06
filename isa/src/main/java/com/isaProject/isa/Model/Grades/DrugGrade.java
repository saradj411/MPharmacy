package com.isaProject.isa.Model.Grades;

import javax.persistence.*;

@Entity
@Table
public class DrugGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMarkDr;

    @Column
    private Integer idPatient;

    @Column
    private Integer idDrug;

    @Column
    private Integer grade;


    public DrugGrade() {
    }

    public DrugGrade(Integer idMarkDr, Integer idPatient, Integer idDrug, Integer grade) {
        this.idMarkDr = idMarkDr;
        this.idPatient = idPatient;
        this.idDrug = idDrug;
        this.grade = grade;
    }

    public DrugGrade(Integer idPatient, Integer idDrug, Integer grade) {
        this.idPatient = idPatient;
        this.idDrug = idDrug;
        this.grade = grade;
    }

    public Integer getIdMarkDr() {
        return idMarkDr;
    }

    public void setIdMarkDr(Integer idMarkDr) {
        this.idMarkDr = idMarkDr;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getIdDrug() {
        return idDrug;
    }

    public void setIdDrug(Integer idDrug) {
        this.idDrug = idDrug;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
