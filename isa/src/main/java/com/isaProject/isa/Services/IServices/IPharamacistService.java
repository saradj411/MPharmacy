package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.PharmaceutDTO;
import com.isaProject.isa.Model.DTO.ReviewedClientsDTO;
import com.isaProject.isa.Model.DTO.ScheduleAnExaminationDTO;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;

import java.util.List;

public interface IPharamacistService {
    Pharmacist findById(Integer id);
    List<Pharmacist> findAll ();
    String delete(Pharmacist pharmacist);
     void update(Pharmacist pharmacist);
     void updateFreeEx(ScheduleAnExaminationDTO scheduleAnExaminationDTO);
     void patientNotAppear(Integer idEx);
     List<ReviewedClientsDTO> reviewedClientsDermatologist(Integer id);

        Pharmacist save(PharmaceutDTO dto);
}
