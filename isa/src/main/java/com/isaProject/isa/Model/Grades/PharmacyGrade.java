package com.isaProject.isa.Model.Grades;

import javax.persistence.*;

@Entity
@Table
public class PharmacyGrade {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idMarkPh;

    @Column
    private Integer idPatient;

    @Column
    private Integer idPharmacy;

    @Column
    private Integer grade;

    public PharmacyGrade() {
    }

    public PharmacyGrade(Integer idMarkPh, Integer idPatient, Integer idPharmacy, Integer grade) {
        this.idMarkPh = idMarkPh;
        this.idPatient = idPatient;
        this.idPharmacy = idPharmacy;
        this.grade = grade;
    }

    public PharmacyGrade(Integer idPatient, Integer idPharmacy, Integer grade) {
        this.idPatient = idPatient;
        this.idPharmacy = idPharmacy;
        this.grade = grade;
    }

    public Integer getIdMarkPh() {
        return idMarkPh;
    }

    public void setIdMarkPh(Integer idMarkPh) {
        this.idMarkPh = idMarkPh;
    }

    public Integer getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(Integer idPatient) {
        this.idPatient = idPatient;
    }

    public Integer getIdPharmacy() {
        return idPharmacy;
    }

    public void setIdPharmacy(Integer idPharmacy) {
        this.idPharmacy = idPharmacy;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }
}
