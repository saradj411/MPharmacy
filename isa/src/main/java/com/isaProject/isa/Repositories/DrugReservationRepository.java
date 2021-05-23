package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Users.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugReservationRepository extends JpaRepository<DrugReservation, Integer> {
    List<DrugReservation> findAllByPatient(Patient idPatient);
    DrugReservation findOneByIdReservation(Integer idRes);
    List<DrugReservation> findAllByIsPickedUp(Boolean isPickedUp);
}
