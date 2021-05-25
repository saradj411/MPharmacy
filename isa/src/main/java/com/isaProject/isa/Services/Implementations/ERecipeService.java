package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Repositories.ERecipeRepository;
import com.isaProject.isa.Services.IServices.IERecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ERecipeService implements IERecipeService {
    @Autowired
    ERecipeRepository eRecipeRepository;
    @Autowired
    PatientService patientService;
    @Override
    public List<ERecipe> findByPatient(Integer id) {
        List<ERecipe> recipes=eRecipeRepository.findAllByPatient(patientService.findById(id));
        return recipes;
    }
}
