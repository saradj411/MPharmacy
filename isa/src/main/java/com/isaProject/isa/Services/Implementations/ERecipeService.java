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
import com.isaProject.isa.Repositories.PharmacyDrugsRepository;
import com.isaProject.isa.Services.IServices.IERecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
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
    @Autowired
    PharmacyDrugsRepository pharmacyDrugsRepository;

    @Autowired
    PharmacyService pharmacyService;

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
                if(erec.getIdRecipe() == idRecepie)
                {
                    e = erec;
                    break;
                }
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

    public List<PharmacyDrugsDTO> showPharmacyWithDrugs()
    {
        List<Pharmacy> allPharmacy = pharmacyService.findAll();
        List<PharmacyDrugs> pharmacyDrugs = pharmacyDrugsService.findAll();

        List<PharmacyDrugsDTO> pharmacyDrugsDTOS = new ArrayList<>();

        // pretraga na osnovu apoteke koji lekovi postoje sve, da bude na jednom mestu.
        // uklju7cuje i quanitty koji nam je potreban za izdavanje erecepta

        for(Pharmacy p : allPharmacy)
        {
            PharmacyDrugsDTO pharmacyListWithDrugs = new PharmacyDrugsDTO();
            pharmacyListWithDrugs.setPharmacy(p);
            List<DrugInfoDTO> drugsList = new ArrayList<>();
            for(PharmacyDrugs pd : pharmacyDrugs)
            {
                if(p.getIdPharm() == pd.getPharmacy().getIdPharm()) {
                    DrugInfoDTO drugInfoDTO = new DrugInfoDTO();
                    drugInfoDTO.setDrug(pd.getDrug());
                    drugInfoDTO.setQuantity(pd.getQuantity());
                    drugsList.add(drugInfoDTO);
                }
            }
            pharmacyListWithDrugs.setDrugs(drugsList);
            pharmacyDrugsDTOS.add(pharmacyListWithDrugs);
        }

        for(PharmacyDrugsDTO pdDTOS : pharmacyDrugsDTOS)
        {
            for(DrugPricelist drugPricelist : drugPricelistService.findAll())
            {
                if(drugPricelist.getPharmacy().getIdPharm() == pdDTOS.getPharmacy().getIdPharm())
                {
                    for(DrugInfoDTO drugInfoDTO : pdDTOS.getDrugs())
                    {
                        if(drugInfoDTO.getDrug().getIdDrug() == drugPricelist.getDrug().getIdDrug())
                            drugInfoDTO.setPrice(drugPricelist.getPrice());
                    }
                }
            }
        }
        System.out.println("APOTEKE SA LEKOVIMA: ");
        System.out.println(pharmacyDrugsDTOS);
        return  pharmacyDrugsDTOS;
    }

    public List<TotalPriceDTO> sortByPriceAsc(Integer idRecepie)
    {
        List<TotalPriceDTO> totalPriceDTOS =  getDrugInPharmacyByErecepie(idRecepie);
        totalPriceDTOS.sort(Comparator.comparing(TotalPriceDTO::getTotalPrice));
        return  totalPriceDTOS;
    }
    public List<TotalPriceDTO> sortByPriceDesc(Integer idRecepie)
    {
        List<TotalPriceDTO> totalPriceDTOS =  getDrugInPharmacyByErecepie(idRecepie);
        totalPriceDTOS.sort(Comparator.comparing(TotalPriceDTO::getTotalPrice).reversed());
        return  totalPriceDTOS;
    }

    public List<TotalPriceDTO> sortByNameAsc(Integer idRecepie)
    {
        List<TotalPriceDTO> totalPriceDTOS =  getDrugInPharmacyByErecepie(idRecepie);

        //totalPriceDTOS.sort(Comparator.comparing(PharmacyDrugsDTO::getPharmacy));
        //totalPriceDTOS.sort(Comparator.comparing(PharmacyDrugsDTO::getPharmacy::comparing(Pharmacy::getName)));

        return  totalPriceDTOS;
    }


    public List<TotalPriceDTO> getDrugInPharmacyByErecepie(Integer id)
    {
        List<TotalPriceDTO> totalPriceDTOS = new ArrayList<>();
        ERecipe eRecipe = new ERecipe();
        for(ERecipe e : eRecipeRepository.findAll())
        {
            if(e.getIdRecipe() == id)
                eRecipe = e;
        }

        Integer number = 0;
        List<PharmacyDrugsDTO> newList = new ArrayList<>();

        for(PharmacyDrugsDTO pdDTOS :  showPharmacyWithDrugs())
        {
            for(ERecipeDrug eRecipeDrug : eRecipe.geteRecipeDrug())
            {
                for(DrugInfoDTO drugInfoDTO : pdDTOS.getDrugs())
                {
                    if(eRecipeDrug.getName().equals(drugInfoDTO.getDrug().getName())
                    && eRecipeDrug.getQuantity() <= drugInfoDTO.getQuantity())
                    {
                        number++;
                    }
                }
            }

            double price = 0;


            if(number == eRecipe.geteRecipeDrug().size())
            {
                PharmacyDrugsDTO pharmacyDrugsDTOnew = new PharmacyDrugsDTO();
                pharmacyDrugsDTOnew.setPharmacy(pdDTOS.getPharmacy());
                List<DrugInfoDTO> drugInfoDTOSListNew = new ArrayList<>();
                TotalPriceDTO totalPriceDTO = new TotalPriceDTO();


                for(ERecipeDrug eRecipeDrug : eRecipe.geteRecipeDrug())
                {
                    for(DrugInfoDTO drugInfoDTO : pdDTOS.getDrugs())
                    {
                        if(eRecipeDrug.getName().equals(drugInfoDTO.getDrug().getName())
                                && eRecipeDrug.getQuantity() <= drugInfoDTO.getQuantity())
                        {
                            drugInfoDTO.setQuantity(eRecipeDrug.getQuantity());
                            price += (eRecipeDrug.getQuantity() * drugInfoDTO.getPrice());
                            drugInfoDTOSListNew.add(drugInfoDTO);
                        }
                    }
                }
                pharmacyDrugsDTOnew.setDrugs(drugInfoDTOSListNew);;
                totalPriceDTO.setTotalPrice(price);
                totalPriceDTO.setPharmacyDrugsDTOList(pharmacyDrugsDTOnew);
                totalPriceDTOS.add(totalPriceDTO);
                number = 0;
                price = 0;
            }
            else
            {    number = 0;
                 price = 0;
            }

        }


        return  totalPriceDTOS;
    }


    public boolean buyDrugInPharmacy(Integer idPharamcy, Integer idRecepie) throws MessagingException {
        ERecipe eRecipe = findOne(idRecepie);

        for( ERecipeDrug eRecipeDrugChecked : eRecipe.geteRecipeDrug())
        {
            PharmacyDrugs pharmacyDrugsChecked = pharmacyDrugsService.findByIdPharmAndDrugName(eRecipeDrugChecked.getName(),idPharamcy);
            if(pharmacyDrugsChecked == null || (pharmacyDrugsChecked.getQuantity()-eRecipeDrugChecked.getQuantity()) < 0 ) {

                    return false;
                }

        }


        for( ERecipeDrug eRecipeDrug : eRecipe.geteRecipeDrug())
        {
            PharmacyDrugs pharmacyDrugs = pharmacyDrugsService.findByIdPharmAndDrugName(eRecipeDrug.getName(),idPharamcy);
            if(pharmacyDrugs != null )
            {
                Integer q = pharmacyDrugs.getQuantity() - eRecipeDrug.getQuantity();
                pharmacyDrugs.setQuantity(q);
                pharmacyDrugsRepository.save(pharmacyDrugs);

            }
            else
            {

                return false;
            }
        }
        eRecipe.setPharmacy(pharmacyService.findById(idPharamcy));
        eRecipe.setStatus(ERecipeStatus.PROCESSED);
        serviceForEmail.sendERecepieVerification(eRecipe.getPatient(),pharmacyService.findById(idPharamcy));
        eRecipeRepository.save(eRecipe);
        return  true;

    }
}
