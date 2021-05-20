package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.PharmacyDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPharmacyService {

    Pharmacy findById(Integer id);
    List<Pharmacy> findByName(String name);
    List<Pharmacy> findByAddress(String city);
    List<Pharmacy> findAll ();
    Pharmacy save(PharmacyDTO pharmacy);
    //Boolean savePharmacy(WorkingHoursDermatologistDTO dto);
    void update(Pharmacy pharmacy);
}
