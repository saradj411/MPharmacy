package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.SpecificaitonDTO;
import com.isaProject.isa.Model.Drugs.Specification;

import java.util.Optional;

public interface ISpecificationService {
    Optional<Specification> findById(Integer idSpec);
    Specification save(SpecificaitonDTO specDTO);
}
