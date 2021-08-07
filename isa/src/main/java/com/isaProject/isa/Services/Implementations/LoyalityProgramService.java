package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.LoyalityProgramDTO;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Users.LoyalityProgram;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Repositories.LoyalityProgramRepository;
import com.isaProject.isa.Services.IServices.ILoyalityProgramService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class LoyalityProgramService implements ILoyalityProgramService {

    @Autowired
    LoyalityProgramRepository loyalityProgramRepository;
    @Autowired
    ExaminationService examinationService;

    public List<LoyalityProgram> findAll(){
        return loyalityProgramRepository.findAll();
    }

    public LoyalityProgram findByIsActive()
    {
        for (LoyalityProgram loyalityProgram: findAll()) {
            if(loyalityProgram.getActive())
                return loyalityProgram;
        }
        return null;
    }


    @Override
    public LoyalityProgram save(LoyalityProgramDTO loyalityProgramDTO) {
        setActiveLoyalityProgram();
        LoyalityProgram loyalityProgram = new LoyalityProgram();
        loyalityProgram.setPercentBronse(loyalityProgramDTO.getPercentBronse());
        loyalityProgram.setPercentSilver(loyalityProgramDTO.getPercentSilver());
        loyalityProgram.setPercentGold(loyalityProgramDTO.getPercentGold());
        loyalityProgram.setPointsToGold(loyalityProgramDTO.getPointsToGold());
        loyalityProgram.setPointsToRegular(loyalityProgramDTO.getPointsToRegular());
        loyalityProgram.setPointsToSilver(loyalityProgramDTO.getPointsToSilver());
        loyalityProgram.setCreatedDate(LocalDate.now());
        loyalityProgram.setActive(true);
        loyalityProgramRepository.save(loyalityProgram);
        return loyalityProgram;
    }

    public void setActiveLoyalityProgram()
    {
        for (LoyalityProgram l : findAll()) {
            l.setActive(false);
            loyalityProgramRepository.save(l);
        }
    }

    public void changeStatusOfPatient(Patient patient)
    {
        LoyalityProgram loyalityProgram = findByIsActive();
        if(patient.getPoints() == 0)
            patient.setLoyaltyCategory("NONE");
        else if(patient.getPoints() <= loyalityProgram.getPointsToRegular())
            patient.setLoyaltyCategory("BRONZE");
        else if(patient.getPoints() <= loyalityProgram.getPointsToSilver())
            patient.setLoyaltyCategory("SILVER");
        else
            patient.setLoyaltyCategory("GOLD");


    }


}
