package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.IngredientDTO;
import com.isaProject.isa.Model.DTO.SpecificationDTO;
import com.isaProject.isa.Model.Drugs.Ingredient;
import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Repositories.SpecificationRepository;
import com.isaProject.isa.Services.IServices.ISpecificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@Service
@Slf4j

public class SpecificationService implements ISpecificationService {

  public @Autowired
    SpecificationRepository specificationRepository;


    @Override
    public List<Specification> findAll() {
       return specificationRepository.findAll();
    }

  @Override
  public SpecificationDTO getSpecById(String name){
    Specification needSpecification=specificationRepository.findByNameDrug(name);
   //Specification needSpecification=new Specification();
/*    List<Specification> listOfSpecification=findAll();
    for (Specification s:listOfSpecification){
      if (s.getDrug().geequals(drug)){
        needSpecification=s;
      }
    }
  */
    Set<IngredientDTO> ingredients=new HashSet<IngredientDTO>();

    for (Ingredient in:needSpecification.getIngredients()){
      IngredientDTO i=new IngredientDTO(in.getName());
      ingredients.add(i);
    }

    SpecificationDTO dto=new SpecificationDTO(needSpecification.getContraindications(),needSpecification.getStructure(),needSpecification.getRecommendedDose(),ingredients);

    return dto;
  }

}
