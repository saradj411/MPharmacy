package com.isaProject.isa.Services.IServices;

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
    Set<Examination> findSheduledDermatologistExamination(Integer id);
    Set<Examination> findSheduledPharmacistExamination(Integer id);


}
