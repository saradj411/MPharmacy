package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.DTO.RequestForVacationDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Drugs.DrugReservation;

import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.RequestForVacation;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Repositories.PatientRepository;
import com.isaProject.isa.Services.IServices.IExaminationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Stack;

@Service
@Slf4j
public class ExaminationService implements IExaminationService {

    @Autowired
    ExaminationRepository examinationRepository;
    @Autowired
    PharmacyService pharmacyService;
    @Autowired
    PatientService patientService;
    @Autowired
    StaffService staffService;
    PatientRepository patientRepository;
    @Override
    public List<Examination> findAll() {
        return examinationRepository.findAll();
    }


    @Override
    public Examination save(ExaminationDTO examinationDTO) {
        Examination d = new Examination();
        Staff s=new Staff();
        d.setDate(examinationDTO.getDate());
        d.setEndTime(examinationDTO.getEnd());
        d.setStartTime(examinationDTO.getStart());
        d.setStaff(staffService.findById(examinationDTO.getIdStaff()));
        d.setPharmacy(pharmacyService.findById(examinationDTO.getIdPharm()));
        d.setPrice(examinationDTO.getPrice());
        d.setType(ExaminationType.DERMATOLOGIST_EXAMINATION);
        d.setPatient(patientService.findById(examinationDTO.getIdPatient()));
        d.setStatus(ExaminationStatus.SCHEDULED);
        return examinationRepository.save(d);
    }



    @Override
    public Examination findById(Integer id) {
        //veki skontalaaa
        Examination examination=examinationRepository.findById(id).get();
        return examination;
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
            if (e.getStaff().getId().equals(idPharmacist)){
                return true;
            }
        }
        return  false;

    }

    public List<Examination>getExaminationsByIdStaffAndIdPharmacy(Integer idStaff){
        List<Examination>examinations=examinationRepository.getAllExaminationsByIdStaffAndIdPharmacy(idStaff);
        List<Examination>freeEx = new ArrayList<>();
        for (Examination e:examinations){
            if(e.getStatus().equals(ExaminationStatus.CREATED)){
                freeEx.add(e);
            }
        }
        return examinations;
    }


    @Override
    public List<FrontCreatedExaminationDTO> findCreatedDermatologistExamination() {
        List<Examination> list=examinationRepository.findAll();
        List<FrontCreatedExaminationDTO> newList=new ArrayList<>();
        for(Examination e:list){
            if (e.getType().compareTo(ExaminationType.DERMATOLOGIST_EXAMINATION)==0){
                if(e.getStatus().compareTo(ExaminationStatus.CREATED)==0) {
                    FrontCreatedExaminationDTO exDTO=new FrontCreatedExaminationDTO(e.getIdExamination(),e.getDate(),
                            e.getStartTime(),e.getEndTime(),e.getPrice(),
                            e.getStaff().getName(),e.getStaff().getSurname(),e.getStaff().getAvgGrade()
                    );
                    newList.add(exDTO);
                }
            }
        }
        return  newList;
    }
    @Override
    public void scheduledDermatologistExamination(Integer idPatient, Integer idExamination) {
        Examination pat = examinationRepository.getOne(idExamination);


        pat.setStatus(ExaminationStatus.SCHEDULED);
        pat.setScheduled(true);
        pat.setPatient(patientRepository.getOne(idPatient));

        examinationRepository.save(pat);
    }


}
