package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.DrugReservationDTO;
import com.isaProject.isa.Model.DTO.DrugReservationForViewDTO;
import com.isaProject.isa.Model.DTO.FrontDrugReservationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Users.Patient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;

import javax.mail.MessagingException;
import java.util.List;

public interface IDrugReservationService {
    List<DrugReservation> findAll ();
    List<DrugReservation> findByIdPatient(Patient id);
    DrugReservation findById(Integer id);
    List<DrugReservation> findByIsPickedUp(Boolean isPickedUp);
    void canceling(Integer id);
    void checkReservations();
    List<FrontDrugReservationDTO> findActualByIdPatient(Patient id);
    List<FrontDrugReservationDTO> findPickedById(Patient id);
    List<FrontDrugReservationDTO> findCanceledById(Patient id);
    DrugReservation save(DrugReservationDTO drug);

    String reservation(Integer idRes) throws MessagingException;

    /*
        Farmaceut ne može da vidi listu
    svih rezervisanih lekova, samo one koje je pronašao pretragom. Prilikom
    pretrage rezervacija, prikazuju se samo one koje su napravljene u istoj apoteci u
    kojoj je farmaceut zaposlen

         */
    List<DrugReservationForViewDTO>listDr(Integer idPharm);
}
