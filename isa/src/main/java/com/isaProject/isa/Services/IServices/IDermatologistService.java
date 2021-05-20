package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.PharmacyDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;

import java.util.List;

public interface IDermatologistService {

    Dermatologist findById(Integer id);
    List<Dermatologist> findAll ();

}