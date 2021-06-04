package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.DTO.ExaminationFrontDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Examination.Examination;

import javax.mail.MessagingException;
import java.util.List;

public interface IExaminationService {

    List<Examination> findAll ();
    Examination createExP(ExaminationDTO examinationDTO) throws MessagingException;
    Examination finishExP(ExaminationFrontDTO examinationDTO,Integer id);
    Examination finishExD(ExaminationFrontDTO examinationDTO,Integer id);
    Examination createExD(ExaminationDTO examinationDTO) throws MessagingException;
    Boolean getExaminationByIdStaff(Integer idPharmacist);
    Examination saveP(ExaminationDTO examinationDTO) throws MessagingException;
    Examination findById(Integer id);
    void patientCanceling(Examination examination);
    Examination save(ExaminationDTO examinationDTO) throws MessagingException;
    List<FrontCreatedExaminationDTO> findCreatedDermatologistExamination();
    void canceling(Integer id);

    void scheduledDermatologistExamination(Integer idPatient,Integer idExamination);


    }
