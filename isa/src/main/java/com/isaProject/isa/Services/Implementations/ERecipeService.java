package com.isaProject.isa.Services.Implementations;

import com.google.zxing.WriterException;
import com.isaProject.isa.Model.DTO.ERecipeDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.DTO.FrontERecipeDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Drugs.ERecipeDrug;
import com.isaProject.isa.Model.Drugs.ERecipeStatus;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Repositories.ERecipeRepository;
import com.isaProject.isa.Services.IServices.IERecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;

import javax.mail.MessagingException;
import java.io.IOException;
import java.time.LocalDate;
import java.util.*;

@Service
@Slf4j
public class ERecipeService implements IERecipeService {
    @Autowired
    ERecipeRepository eRecipeRepository;
    @Autowired
    PatientService patientService;
    @Autowired
    UserService userService;
    @Autowired
    DrugService drugService;

    @Autowired
    ServiceForEmail serviceForEmail;

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

    //kreate ERecepie

    public ERecipe create(List<ERecipeDTO> eRecipeDTO) throws MessagingException, IOException, WriterException {
        Patient patient = patientService.findById(eRecipeDTO.get(0).getIdPatient());
        User user = userService.findById(eRecipeDTO.get(0).getIdWhoCreate());
        Set<ERecipeDrug> eRecipeDrugSet = new HashSet<>();

        List<Drug> drugForRecept = new ArrayList<>();
        for(ERecipeDTO e : eRecipeDTO)
        {
            Drug drug = drugService.findById(e.getIdDrug());
            ERecipeDrug eRecipeDrug = new ERecipeDrug();
            eRecipeDrug.setName(drug.getName());
            eRecipeDrug.setCode(drug.getCode());
            eRecipeDrug.setQuantity(e.getQuantity());
            eRecipeDrugSet.add(eRecipeDrug);
            drugForRecept.add(drug);

        }

        ERecipe eRecipe = new ERecipe();
        eRecipe.seteRecipeDrug(eRecipeDrugSet);
        eRecipe.setUser(user);
        eRecipe.setPatient(patient);
        eRecipe.setName(patient.getName());
        eRecipe.setSurname(patient.getSurname());
        eRecipe.setDateOfIssue(LocalDate.now());
        eRecipe.setCode("Hard kodirano");
        eRecipe.setStatus(ERecipeStatus.NEW);

        for(ERecipeDrug e: eRecipeDrugSet)
        {
            e.seteRecipe(eRecipe);
        }

        eRecipeRepository.save(eRecipe);
        System.out.println("ID: " + eRecipe.getIdRecipe());
        //send email
        serviceForEmail.sendERecepieToPatient(eRecipe);
        return eRecipe;
    }


}
