package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.DermatologistDTO;
import com.isaProject.isa.Model.DTO.PatientDTO;
import com.isaProject.isa.Model.DTO.PharmacyDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Patient;

import java.util.List;
import java.util.Set;

public interface IDermatologistService {

    Dermatologist findById(Integer id);
    List<Dermatologist> findAll ();

    Dermatologist save(DermatologistDTO dermatologist);
    String delete(Dermatologist dermatologist);
    Set<PatientDTO> findAllPatients(Integer id) ;
     void update(Dermatologist dermatologist);

}
