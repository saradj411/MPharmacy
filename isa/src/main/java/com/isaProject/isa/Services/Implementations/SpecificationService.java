package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.IngredientDTO;
import com.isaProject.isa.Model.DTO.SpecificaitonDTO;
import com.isaProject.isa.Model.DTO.SpecificationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.Ingredient;
import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Repositories.SpecificationRepository;
import com.isaProject.isa.Services.IServices.ISpecificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;


@Service
@Slf4j
public class SpecificationService implements ISpecificationService {

  public @Autowired
    SpecificationRepository specificationRepository;

    public @Autowired
    DrugRepository drugRepository;


    @Override
    public List<Specification> findAll() {
       return specificationRepository.findAll();
    }

  @Override
  public Specification getSpecById(String name){
        Drug drug=drugRepository.findOneByNameDrug(name);
        Specification s=specificationRepository.findByNameDrug(name);
        return s;
    }


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
