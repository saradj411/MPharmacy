package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.SpecificaitonDTO;
import com.isaProject.isa.Model.DTO.SpecificationDTO;
import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import java.util.List;
import java.util.Optional;

public interface ISpecificationService {

    List<Specification> findAll ();
    SpecificationDTO getSpecById(String name);

    Optional<Specification> findById(Integer idSpec);
    Specification save(SpecificaitonDTO specDTO);
   
}
