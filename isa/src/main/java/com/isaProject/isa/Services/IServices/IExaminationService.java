package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.DTO.SchedulePharmacistExaminationDTO;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Examination.Examination;

import javax.mail.MessagingException;
import java.util.List;

public interface IExaminationService {

    List<Examination> findAll ();
    Examination findById(Integer id);

    void canceling(Integer id);
    void patientCanceling(Examination examination);
    void patientCancelingPharmacistExamination(Examination examination);
    Boolean getExaminationByIdStaff(Integer idPharmacist);
    //Examination findById(Integer id);
    Examination save(ExaminationDTO examinationDTO);
    List<FrontCreatedExaminationDTO> findCreatedDermatologistExamination();

    void scheduledDermatologistExamination(Integer idPatient,Integer idExamination) throws MessagingException;
    Boolean schedulePharmacistExamination(SchedulePharmacistExaminationDTO schedulePharmacistExaminationDTO) throws MessagingException;


    }
