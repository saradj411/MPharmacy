package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.DTO.ExaminationFrontDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Examination.Examination;

import javax.mail.MessagingException;
import java.util.List;

public interface IExaminationService {

    List<Examination> findAll ();

    void canceling(Integer id);
    Examination save1(ExaminationFrontDTO examinationDTO);
    Examination save2(ExaminationDTO examinationDTO) throws MessagingException;
    Boolean getExaminationByIdStaff(Integer idPharmacist);
    Examination findById(Integer id);
    Examination save(ExaminationDTO examinationDTO) throws MessagingException;
    List<FrontCreatedExaminationDTO> findCreatedDermatologistExamination();

    void scheduledDermatologistExamination(Integer idPatient,Integer idExamination);


    }
