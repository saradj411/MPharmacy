package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Repositories.PatientRepository;
import com.isaProject.isa.Services.IServices.IPatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class PatientService implements IPatientService {

    @Autowired
    PatientRepository patientRepository;
    @Autowired
    DrugRepository drugRepository;

    @Override
    public Patient findById(Integer id) {

        return patientRepository.findById(id).get();

    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public void saveAllergy(Integer idDrug,Integer idPatient) {
        Patient patient = patientRepository.findById(idPatient).get();
        Set<Drug> allergies=patient.getAllergies();
        Drug dr=drugRepository.getOne(idDrug);
        allergies.add(dr);
        patient.setAllergies(allergies);
        patientRepository.save(patient);

    }
}

