package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.SpecificaitonDTO;
import com.isaProject.isa.Model.Drugs.Specification;

import java.util.List;
import java.util.Optional;

public interface ISpecificationService {

    List<Specification> findAll ();
    Specification getSpecById(String name);

    Optional<Specification> findById(Integer idSpec);
    Specification save(SpecificaitonDTO specDTO);
   
}
