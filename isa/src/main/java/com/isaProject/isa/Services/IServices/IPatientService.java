package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.Users.Patient;

import java.util.List;

public interface IPatientService {
    Patient findById(Integer id);
    List<Patient> findAll ();
    void saveAllergy(Integer idDrug,Integer idPatient);
    void update(Patient patient);

}
