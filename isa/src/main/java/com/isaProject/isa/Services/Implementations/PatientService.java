package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Repositories.PatientRepository;
import com.isaProject.isa.Services.IServices.IPatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@Slf4j
public class PatientService implements IPatientService {

    @Autowired
    PatientRepository patientRepository;

    @Override
    public Patient findById(Integer id) {

        return patientRepository.findById(id).get();

    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }
}
