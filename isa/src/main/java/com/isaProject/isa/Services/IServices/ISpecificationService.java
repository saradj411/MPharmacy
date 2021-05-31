package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.SpecificationDTO;
import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import java.util.List;

public interface ISpecificationService {

    List<Specification> findAll ();
    SpecificationDTO getSpecById(String name);

}
