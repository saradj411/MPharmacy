package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.DrugReservationDTO;
import com.isaProject.isa.Model.DTO.DrugReservationForViewDTO;
import com.isaProject.isa.Model.DTO.FrontDrugReservationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Repositories.*;
import com.isaProject.isa.Services.IServices.IDrugReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class DrugReservationService implements IDrugReservationService {
    @Autowired
    DrugReservationRepository drugRepository;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PharmacyRepository pharmacyRepository;
    @Autowired
    DrugRepository drugRepository2;
    @Autowired
    PharmacyDrugsRepository pharmacyDrugsRepository;

    @Autowired
    ServiceForEmail serviceForEmail;

    @Autowired
    PharmacistRepository pharmacistRepository;



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
    public void canceling(Integer id) {
        DrugReservation pat = drugRepository.getOne(id);

        PharmacyDrugs pp=pharmacyDrugsRepository.findByIdDrugAndIfPharm(pat.getPharmacy().getIdPharm(),pat.getDrug().getIdDrug());
        pat.setCancelled(true);
        pp.setQuantity(pp.getQuantity()+pat.getQuantity());
        pharmacyDrugsRepository.save(pp);

        drugRepository.save(pat);
    }

    @Override
    public void checkReservations() {
        List<DrugReservation> list=drugRepository.findAll();
        LocalDate now=LocalDate.now();
        for(DrugReservation dR:list){
            if(dR.getPickUpDate().compareTo(now)==0){
                if(!dR.getCancelled()){
                    if(!dR.getPickedUp()){
                        if(!dR.getExpired()) {
                            Patient pat = dR.getPatient();
                            pat.setPenalty(pat.getPenalty() + 1);
                            patientRepository.save(pat);

                            dR.setExpired(true);
                            drugRepository.save(dR);
                        }
                    }
                }
            }
        }
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

    @Override
    public DrugReservation save(DrugReservationDTO drug) {
            DrugReservation d = new DrugReservation();
            PharmacyDrugs pd=pharmacyDrugsRepository.findOneById(drug.getIdPharmacyDrug());

            d.setDrug(drugRepository2.findOneByIdDrug(drug.getDrug()));
            d.setPharmacy(pharmacyRepository.findOneByIdPharm(drug.getPharmacy()));
            d.setPatient(patientRepository.findOneById(drug.getPatient()));
            d.setPickUpDate(drug.getPickUpDate());
            d.setCancelled(false);
            d.setExpired(false);
            d.setDateOfReservation(LocalDate.now());
            d.setPickedUp(false);
            d.setQuantity(1);

            pd.setQuantity(pd.getQuantity()-1);
            DrugReservation novi=drugRepository.save(d);
            pharmacyDrugsRepository.save(pd);
            //pd.setDrug(novi);
            //drugRepository.save(pd);
            return novi;

    }


    @Override
    public String reservation(Integer idRes) throws MessagingException {
        String message="";
        DrugReservation drugReservation=drugRepository.getOne(idRes);
        System.out.println(" Rezervacija "+drugReservation.getDrug().getName());
        if (drugReservation.getIdReservation().equals(idRes)){

            message="Patient successfully took the drug.";
            drugReservation.setPickedUp(true);
            drugReservation.setPickUpDate(LocalDate.now());
            drugRepository.save(drugReservation);
            serviceForEmail.sendingEmailToInformPatient(drugReservation.getPatient());

        }
        if ( possibleCancel(drugReservation.getDateOfReservation()).equals(true) || drugReservation==null){
            message="The booking number is incorrect ";

        }
        return message;
    }

    /*
    Farmaceut ne može da vidi listu
svih rezervisanih lekova, samo one koje je pronašao pretragom. Prilikom
pretrage rezervacija, prikazuju se samo one koje su napravljene u istoj apoteci u
kojoj je farmaceut zaposlen

     */
    @Override
    public List<DrugReservationForViewDTO>listDr(Integer idPharm){
        Optional<Pharmacist> pharmacist=pharmacistRepository.findById(idPharm);
        Pharmacist p=pharmacist.get();
        List<DrugReservation>drugReservations=drugRepository.findAll();
        List<DrugReservationForViewDTO>drugReservationForViewDTOS=new ArrayList<>();
        for (DrugReservation d:drugReservations){
            if (d.getPharmacy().equals(p.getPharmacy())){
                DrugReservationForViewDTO drugReservationForViewDTO=new DrugReservationForViewDTO(d.getPatient().getName(),d.getPatient().getSurname(),d.getDrug().getName(),d.getQuantity(),d.getDateOfReservation());
                drugReservationForViewDTOS.add(drugReservationForViewDTO);
            }

        }
        return drugReservationForViewDTOS;
    }


}
