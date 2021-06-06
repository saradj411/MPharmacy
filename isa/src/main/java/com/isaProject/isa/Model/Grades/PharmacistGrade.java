package com.isaProject.isa.Model.Grades;

import javax.persistence.*;

@Entity
@Table
public class PharmacistGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMarkP;

    @Column
    private Integer idPatient;

    @Column
    private Integer idPharmacist;

    @Column
    private Integer grade;

    public PharmacistGrade() {
    }

    public PharmacistGrade(Integer idMarkP, Integer idPatient, Integer idPharmacist, Integer grade) {
        this.idMarkP = idMarkP;
        this.idPatient = idPatient;
        this.idPharmacist = idPharmacist;
        this.grade = grade;
    }

    public PharmacistGrade(Integer idPatient, Integer idPharmacist, Integer grade) {
        this.idPatient = idPatient;
        this.idPharmacist = idPharmacist;
        this.grade = grade;
    }

    public Integer getIdMarkP() {
        return idMarkP;
    }

    public void setIdMarkP(Integer idMarkP) {
        this.idMarkP = idMarkP;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getIdPharmacist() {
        return idPharmacist;
    }

    public void setIdPharmacist(Integer idPharmacist) {
        this.idPharmacist = idPharmacist;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
