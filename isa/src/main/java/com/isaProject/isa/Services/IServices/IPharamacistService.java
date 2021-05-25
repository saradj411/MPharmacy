package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.PharmaceutDTO;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;

import java.util.List;

public interface IPharamacistService {
    Pharmacist findById(Integer id);
    List<Pharmacist> findAll ();
    String delete(Pharmacist pharmacist);
     void update(Pharmacist pharmacist);

    Pharmacist save(PharmaceutDTO dto);
}
