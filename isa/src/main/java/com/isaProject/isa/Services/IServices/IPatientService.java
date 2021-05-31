package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Users.Patient;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;
import java.util.Set;

public interface IPatientService {
    Patient findById(Integer id);
    List<Patient> findAll ();
    void saveAllergy(Integer idDrug,Integer idPatient);
    void update(Patient patient);
    Set<FrontCreatedExaminationDTO> findSheduledDermatologistExamination(Integer id);
    Set<FrontCreatedExaminationDTO> findSheduledPharmacistExamination(Integer id);
    List<ERecipe> findERecipe(Integer id);


}
