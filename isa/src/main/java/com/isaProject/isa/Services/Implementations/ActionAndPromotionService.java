package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.ActionAndPromotionDTO;
import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.ActionAndPromotion;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Repositories.ActionAndPromotionRepository;
import com.isaProject.isa.Repositories.PharmacyRepository;
import com.isaProject.isa.Services.IServices.IActionAndPromotionService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Service
public class ActionAndPromotionService implements IActionAndPromotionService {


  /*

    Administrator apoteke u slobodnoj formi definiše akciju, odnosno promociju.
Svaka akcija i promocija ima period važenja. Kada se definiše nova akcija ili
promocija, obaveštavaju se sve zainteresovane strane koje su pretplaćene da
dobijaju obaveštenja od apoteke putem mail-a.

     */
    @Autowired
    PharmacyService pharmacyService;

    @Autowired
    ActionAndPromotionRepository actionAndPromotionRepository;

    @Autowired
    PatientService patientService;

    @Autowired
    ServiceForEmail serviceForEmail;

    @Autowired
    PharmacyRepository pharmacyRepository;


    @Override
    public ActionAndPromotion save(ActionAndPromotionDTO dto) {
        ActionAndPromotion actionAndPromotion=new ActionAndPromotion();
        Pharmacy pharmacy=pharmacyRepository.getOne(dto.getIdPham());
        actionAndPromotion.setEndDate(dto.getEndDate());
        actionAndPromotion.setStartDate(dto.getStartDate());
        actionAndPromotion.setText(dto.getText());
        actionAndPromotion.setPharmacy(pharmacy);



        actionAndPromotionRepository.save(actionAndPromotion);
        return actionAndPromotion;
    }

    @Override
    public void sendMail(ActionAndPromotion actionAndPromotion) throws MessagingException {
        List<Patient>patients=patientService.findAll();
        Pharmacy pharmacy=actionAndPromotion.getPharmacy();
        List<Patient>patientsForAction=new ArrayList<>();
        for (Patient p:patients){
            Set<Pharmacy> pharmForPatient=p.getActionPharmacies();
            for (Pharmacy ph:pharmForPatient){
                if(pharmacy.equals(ph)){
                    //posalji mejl
                    serviceForEmail.sendingEmailsForActionAndPromotions (p,actionAndPromotion.getPharmacy().getName(),actionAndPromotion.getText());

                }

            }
        }


    }

}
