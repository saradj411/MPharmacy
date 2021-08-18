package com.isaProject.isa.Model.DTO;

public class ComplainDTO {
    private Integer idPatient;
    private Integer idPharmacy;
    private Integer idStaff;
    private String text;

    public ComplainDTO() {}

    public ComplainDTO(Integer idPatient, Integer idPharmacy, Integer idStaff, String text) {
        this.idPatient = idPatient;
        this.idPharmacy = idPharmacy;
        this.idStaff = idStaff;
        this.text = text;
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

    public Integer getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Integer idStaff) {
        this.idStaff = idStaff;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }
}
