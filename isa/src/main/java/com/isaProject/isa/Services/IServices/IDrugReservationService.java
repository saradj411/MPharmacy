package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Users.Patient;

import java.util.List;

public interface IDrugReservationService {
    List<DrugReservation> findAll ();
    List<DrugReservation> findByIdPatient(Patient id);
    DrugReservation findById(Integer id);
}
