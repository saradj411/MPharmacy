package com.isaProject.isa.Services.IServices;

import com.google.zxing.WriterException;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.DTO.SubscribeDTO;
import com.isaProject.isa.Model.DTO.UserDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Pharmacist;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.List;
import java.util.Set;

public interface IPatientService {
    Patient findById(Integer id);
    List<Patient> findAll ();
    Patient save(UserDTO user) throws MessagingException;
    void saveAllergy(Integer idDrug,Integer idPatient);
    void update(Patient patient);
    Set<FrontCreatedExaminationDTO> findSheduledDermatologistExamination(Integer id);
    Set<FrontCreatedExaminationDTO> findSheduledPharmacistExamination(Integer id);
    //List<ERecipe> findERecipe(Integer id);
     Set<Drug> getAllergy(Integer idPatient, String name) ;

    List<ERecipe> findERecipe(Integer id);

    Set<FrontCreatedExaminationDTO> findFinishedDermatologistExamination(Integer id);
    Set<FrontCreatedExaminationDTO> findFinishedPharmacistExamination(Integer id);

    String findAllergy(Integer idPatient,String name);

    Set<Integer> findDermatologistForGrade(Integer id);
    Set<Integer> findPharmacistForGrade(Integer id);
    Set<Integer> findPharmaciesForGrade(Integer id);
    Set<Integer> findDrugsForGrade(Integer id);

    Patient subscribe(SubscribeDTO subscribeDTO) throws MessagingException, IOException, WriterException;
    Patient unsubscribe(SubscribeDTO subscribeDTO) throws MessagingException, IOException, WriterException;
}
