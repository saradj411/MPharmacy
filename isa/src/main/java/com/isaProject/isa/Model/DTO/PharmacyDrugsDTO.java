package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import java.util.List;

public class PharmacyDrugsDTO {
    private Pharmacy pharmacy;
    private List<DrugInfoDTO> drugs;

    public PharmacyDrugsDTO(){};

    public PharmacyDrugsDTO(Pharmacy pharmacy, List<DrugInfoDTO> drugs) {
        this.pharmacy = pharmacy;
        this.drugs = drugs;
    }

    public Pharmacy getPharmacy() {
        return pharmacy;
    }

    public void setPharmacy(Pharmacy pharmacy) {
        this.pharmacy = pharmacy;
    }

    public List<DrugInfoDTO> getDrugs() {
        return drugs;
    }

    public void setDrugs(List<DrugInfoDTO> drugs) {
        this.drugs = drugs;
    }

    @Override
    public String toString() {
        return "PharmacyDrugsDTO{" +
                "pharmacy=" + pharmacy +
                ", drugs=" + drugs +
                '}';
    }
}
