package com.isaProject.isa.Model.DTO;

public class SubscribeDTO {
    private int idPharmacy;
    private int idPatient;

    public SubscribeDTO(){}

    public SubscribeDTO(int idPharmacy, int idPatient) {
        this.idPharmacy = idPharmacy;
        this.idPatient = idPatient;
    }

    public int getIdPharmacy() {
        return idPharmacy;
    }

    public void setIdPharmacy(int idPharmacy) {
        this.idPharmacy = idPharmacy;
    }

    public int getIdPatient() {
        return idPatient;
    }

    public void setIdPatient(int idPatient) {
        this.idPatient = idPatient;
    }
}
