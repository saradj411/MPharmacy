package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.DTO.ExaminationFrontDTO;
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
    void patientCancelingPharmacistExamination(Examination examination);

    Examination createExP(ExaminationDTO examinationDTO) throws MessagingException;
    Examination finishExP(ExaminationFrontDTO examinationDTO,Integer id);
    Examination finishExD(ExaminationFrontDTO examinationDTO,Integer id);

    Examination defineTerms(ExaminationDTO examinationDTO) throws MessagingException;

    Examination createExD(ExaminationDTO examinationDTO) throws MessagingException;

    Boolean getExaminationByIdStaff(Integer idPharmacist);
    Examination saveP(ExaminationDTO examinationDTO) throws MessagingException;

    void patientCanceling(Integer examination);
    Examination save(ExaminationDTO examinationDTO) throws MessagingException;
    List<FrontCreatedExaminationDTO> findCreatedDermatologistExamination();

    void scheduledDermatologistExamination(Integer idPatient,Integer idExamination) throws MessagingException;
    Boolean schedulePharmacistExamination(SchedulePharmacistExaminationDTO schedulePharmacistExaminationDTO) throws MessagingException;


    }
