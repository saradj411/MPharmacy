package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.SpecificaitonDTO;
import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Repositories.SpecificationRepository;
import com.isaProject.isa.Services.IServices.ISpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class SpecificationService implements ISpecificationService {

    @Autowired
    SpecificationRepository specificationRepository;

    @Override
    public Optional<Specification> findById(Integer idSpec) {
        return specificationRepository.findById(idSpec);
    }

    @Override
    public Specification save(SpecificaitonDTO specDTO) {

        Specification s = new Specification();
        s.setContraindications(specDTO.getContraindications());
        s.setStructure(specDTO.getStructure());
        s.setRecommendedDose(specDTO.getRecommendedDose());
        s.setDrug(specDTO.getDrug());
        s.setIngredients(specDTO.getIngredients());

        specificationRepository.save(s);
        return s;

    }
}
