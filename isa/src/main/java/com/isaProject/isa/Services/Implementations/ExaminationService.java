package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Services.IServices.IExaminationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class ExaminationService implements IExaminationService {

    @Autowired
    ExaminationRepository examinationRepository;

    @Override
    public List<Examination> findAll() {
        return examinationRepository.findAll();
    }

    @Override

    public void canceling(Integer id) {
        Examination pat = examinationRepository.getOne(id);


        pat.setCanceled(true);
        pat.setStatus(ExaminationStatus.CANCELED);


        examinationRepository.save(pat);
    }
    public Boolean getExaminationByIdStaff(Integer idPharmacist){

        List<Examination> lista=examinationRepository.findAll();
        for(Examination e:lista){
            if (e.getStaff().getIdUser().equals(idPharmacist)){
                return true;
            }
        }
        return  false;

    }

    @Override
    public List<Examination> findCreatedDermatologistExamination() {
        List<Examination> list=examinationRepository.findAll();
        List<Examination> newList=new ArrayList<>();
        for(Examination e:list){
            if (e.getType().compareTo(ExaminationType.DERMATOLOGIST_EXAMINATION)==0){
                if(e.getStatus().compareTo(ExaminationStatus.CREATED)==0) {
                    newList.add(e);
                }
            }
        }
        return  newList;
    }

}
