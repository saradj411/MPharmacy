package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.FrontDrugReservationDTO;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Repositories.DrugReservationRepository;
import com.isaProject.isa.Repositories.PatientRepository;
import com.isaProject.isa.Services.IServices.IDrugReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class DrugReservationService implements IDrugReservationService {
    @Autowired
    DrugReservationRepository drugRepository;
    @Autowired
    PatientRepository patientRepository;

    @Override
    public List<DrugReservation> findAll() {
        return drugRepository.findAll();
    }

    @Override
    public  List<DrugReservation> findByIdPatient(Patient id) {
        List<DrugReservation> drugg = drugRepository.findAllByPatient(id);
        return drugg;
    }
    @Override
    public  List<DrugReservation> findByIsPickedUp(Boolean isPickedUp) {
        List<DrugReservation> drugg = drugRepository.findAllByIsPickedUp(isPickedUp);
        return drugg;
    }

    @Override
    public DrugReservation findById(Integer id) {
        return drugRepository.findOneByIdReservation(id);
    }


    public Boolean possibleCancel(LocalDate dateRes){
        Boolean rez=false;
        //trenutno vrijeme
        LocalDate now=LocalDate.now();
        LocalDate minusDan=dateRes.minusDays(1);

        int res=minusDan.compareTo(now);
        if(res==0){
            //poklapaju se, ne moze otkazati
            rez=false;
        }else if (res>0){
            //moguce
            rez=true;
        }else{
            rez=false;
        }
        //System.out.println("dan:"+dan);
        return rez;

    }
    @Override
    public void canceling(DrugReservation drugReservation) {
        DrugReservation pat = drugRepository.getOne(drugReservation.getIdReservation());


        pat.setCancelled(true);


        drugRepository.save(pat);
    }

    @Override
    public List<FrontDrugReservationDTO> findActualByIdPatient(Patient id) {
        List<DrugReservation> reserv = drugRepository.findAllByPatient(id);
        List<FrontDrugReservationDTO> reserv1 = new ArrayList<>();
        LocalDate now = LocalDate.now();

        for (DrugReservation dR : reserv) {
            LocalDate pick = dR.getPickUpDate();
            int rez = now.compareTo(pick);
            System.out.println(rez);
            if (rez < 0) {
                System.out.println("uslo:" + dR.getDrug().getName());
                if (!dR.getCancelled()) {
                    if (!dR.getPickedUp()) {
                        FrontDrugReservationDTO drDTO = new FrontDrugReservationDTO(dR.getIdReservation(),
                                dR.getQuantity(), dR.getDrug().getName(), dR.getPharmacy().getName(),
                                dR.getDateOfReservation(), dR.getPickUpDate());
                        reserv1.add(drDTO);
                        //id.setPenalty(id.getPenalty() + 1);
                        //patientService.update(id);
                    }
                }
            }

        }
        return reserv1;
    }

    @Override
    public List<FrontDrugReservationDTO> findPickedById(Patient id) {
        List<DrugReservation> reserv = drugRepository.findAllByPatient(id);
        List<FrontDrugReservationDTO> reserv1=new ArrayList<>();
        for (DrugReservation dR:reserv){
            if(dR.getPickedUp()){
                FrontDrugReservationDTO drDTO=new FrontDrugReservationDTO(dR.getIdReservation(),
                        dR.getQuantity(),dR.getDrug().getName(),dR.getPharmacy().getName(),
                        dR.getDateOfReservation(),dR.getPickUpDate());
                reserv1.add(drDTO);
            }
        }
        return reserv1;
    }

    @Override
    public List<FrontDrugReservationDTO> findCanceledById(Patient id) {
        List<DrugReservation> reserv = drugRepository.findAllByPatient(id);
        List<FrontDrugReservationDTO> reserv1=new ArrayList<>();
        for (DrugReservation dR:reserv){
            if(dR.getCancelled()){
                FrontDrugReservationDTO drDTO=new FrontDrugReservationDTO(dR.getIdReservation(),
                        dR.getQuantity(),dR.getDrug().getName(),dR.getPharmacy().getName(),
                        dR.getDateOfReservation(),dR.getPickUpDate());
                reserv1.add(drDTO);
            }
        }
        return reserv1;
    }

}
