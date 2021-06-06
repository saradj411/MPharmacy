package com.isaProject.isa.Model.Grades;

import javax.persistence.*;

@Entity
@Table
public class DermatolgoistGrade {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMarkD;

    @Column
    private Integer idPatient;

    @Column
    private Integer idDermatologist;

    @Column
    private Integer grade;


    public DermatolgoistGrade() {
    }


    public DermatolgoistGrade(Integer idMarkD, Integer idPatient, Integer idDermatologist, Integer grade) {
        this.idMarkD = idMarkD;
        this.idPatient = idPatient;
        this.idDermatologist = idDermatologist;
        this.grade = grade;
    }

    public DermatolgoistGrade(Integer idPatient, Integer idDermatologist, Integer grade) {
        this.idPatient = idPatient;
        this.idDermatologist = idDermatologist;
        this.grade = grade;
    }

    public Integer getIdMarkD() {
        return idMarkD;
    }

    public void setIdMarkD(Integer idMarkD) {
        this.idMarkD = idMarkD;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getIdDermatologist() {
        return idDermatologist;
    }

    public void setIdDermatologist(Integer idDermatologist) {
        this.idDermatologist = idDermatologist;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
