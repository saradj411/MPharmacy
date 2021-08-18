package com.isaProject.isa.Services.Implementations;

import com.google.zxing.WriterException;
import com.isaProject.isa.Model.DTO.*;
import com.isaProject.isa.Model.Drugs.*;
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
    @Autowired
    DrugPricelistService drugPricelistService;
    @Autowired
    PharmacyDrugsService pharmacyDrugsService;

    @Override
    public List<FrontERecipeDTO> findByPatient(Integer id) {
        List<ERecipe> recipes=eRecipeRepository.findAllByPatient(patientService.findById(id));
        List<FrontERecipeDTO> newList=new ArrayList<>();
        for(ERecipe e:recipes){
            if(e.getPharmacy() != null)

            {FrontERecipeDTO exDTO=new FrontERecipeDTO(e.getIdRecipe(),e.getCode(),e.getName(),
                    e.getSurname(),e.getDateOfIssue(),e.geteRecipeDrug(),e.getPharmacy().getName(),
                    e.getStatus()
                    );
                    newList.add(exDTO);}
                }
        return newList;
    }

    public List<ERecipe> findAll()
    {
        return eRecipeRepository.findAll();
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


    public ERecipeWithUserDTO showERecepieQRcode(Integer idRecepie) {

        ERecipe e = new ERecipe();

        for(ERecipe erec : findAll()) {
                if(erec.getIdRecipe() == idRecepie && erec.getStatus().equals(ERecipeStatus.NEW))
                    e = erec;

        }
        User u = userService.findById(e.getUser().getId());
        return new ERecipeWithUserDTO(e,u);


    }

    public User retaValUser(Integer idRecepie) {
        ERecipe e = findOne(idRecepie);
        User user = userService.findById(e.getUser().getId());
        return user;
    }

    public ERecipe findOne(Integer idRecepie)
    {
        for(ERecipe e : findAll()) {
            if(e.getIdRecipe() == idRecepie)
                return e;
        }
        return  null;
    }

    /*public List<BuyDrugDTO> getAllPharamcyForERecept(Integer idRecepie)
    {
           ERecipe eRecipe = findOne(idRecepie);

           for(PharmacyDrugs pharmacyDrugs : pharmacyDrugsService.findAll())
           {
               for(ERecipeDrug eRecipeDrug : eRecipe.geteRecipeDrug())
               {
                   if(pharmacyDrugs.getDrug().getIdDrug() == eRecipeDrug.getId() && pharmacyDrugs.getQuantity() > eRecipeDrug.getQuantity())
                   {
                       ApotekaICena  apotekaICena = new ApotekaICena();
                       apotekaICena.setPharmacy(pharmacyDrugs.getPharmacy());
                       apotekaICena.setPrice(getPrice(idDrug, idPharmacy));
                   }
               }
           }return  null;
    }*/

    public boolean buyDrug (Integer idERec, Integer idPharmacy)
    {
        ERecipe eRecipe = new ERecipe();
        for(ERecipe e : eRecipeRepository.findAll())
        {
            if(e.getIdRecipe() == idERec)
                eRecipe = e;

        }
        eRecipe.setStatus(ERecipeStatus.PROCESSED);
        //set quantity to new number
        return true;

    }
}
