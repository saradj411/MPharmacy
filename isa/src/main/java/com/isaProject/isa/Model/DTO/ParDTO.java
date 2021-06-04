package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Staff;

public class ParDTO {
    private Pharmacy idPharmacy;
    private Staff idStaff;


    public ParDTO(Pharmacy idPharmacy, Staff idStaff) {
        this.idPharmacy = idPharmacy;
        this.idStaff = idStaff;
    }

    public Pharmacy getIdPharmacy() {
        return idPharmacy;
    }

    public void setIdPharmacy(Pharmacy idPharmacy) {
        this.idPharmacy = idPharmacy;
    }

    public Staff getIdStaff() {
        return idStaff;
    }

    public void setIdStaff(Staff idStaff) {
        this.idStaff = idStaff;
    }
}
