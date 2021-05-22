package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Repositories.DrugReservationRepository;
import com.isaProject.isa.Services.IServices.IDrugReservationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.DateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;


@Service
@Slf4j
public class DrugReservationService implements IDrugReservationService {
    @Autowired
    DrugReservationRepository drugRepository;

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
    public DrugReservation findById(Integer id) {
        return drugRepository.findOneByIdReservation(id);
    }

    public Boolean possibleCancel(LocalDate dateRes){
        Boolean rez=false;
        //trenutno vrijeme
        LocalDate now=LocalDate.now();
        //jedan dan manje nego danas
        LocalDate day=now.minusDays(1);
          int dan= dateRes.getDayOfMonth();
        //poredim dan manje sa danom kad se mora pokupiti rez
        int res=dateRes.compareTo(day);
        if(res==0){
            //poklapaju se, ne moze otkazati
            rez=false;

        }else if (res>0){
            //moguce
            rez=true;
        }else{
            rez=false;
        }
        //System.out.println(wd);
        //System.out.println(dsd);
        System.out.println(res);
        System.out.println(dan);
        return rez;

    }
}
