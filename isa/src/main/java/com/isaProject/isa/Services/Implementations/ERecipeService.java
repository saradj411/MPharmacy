package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.DTO.FrontERecipeDTO;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Repositories.ERecipeRepository;
import com.isaProject.isa.Services.IServices.IERecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@Service
@Slf4j
public class ERecipeService implements IERecipeService {
    @Autowired
    ERecipeRepository eRecipeRepository;
    @Autowired
    PatientService patientService;
    @Override
    public List<FrontERecipeDTO> findByPatient(Integer id) {
        List<ERecipe> recipes=eRecipeRepository.findAllByPatient(patientService.findById(id));
        List<FrontERecipeDTO> newList=new ArrayList<>();
        for(ERecipe e:recipes){

            FrontERecipeDTO exDTO=new FrontERecipeDTO(e.getIdRecipe(),e.getCode(),e.getName(),
                    e.getSurname(),e.getDateOfIssue(),e.geteRecipeDrug(),e.getPharmacy().getName(),
                    e.getStatus()
                    );
                    newList.add(exDTO);
                }
        return newList;
    }


}
