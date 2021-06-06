package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrugReservationRepository extends JpaRepository<DrugReservation, Integer> {
    List<DrugReservation> findAllByPatient(Patient idPatient);
    DrugReservation findOneByIdReservation(Integer idRes);
    List<DrugReservation> findAllByIsPickedUp(Boolean isPickedUp);


    @Query("select s from DrugReservation s where s.pharmacy.idPharm = ?1 and s.drug.idDrug= ?2")
    List<DrugReservation> findAllByIdDrugAndIdPharm(Integer idPharm,Integer idDrug);
    List<DrugReservation> findAllByPharmacy(Pharmacy pharmacy);

}
