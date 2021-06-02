package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.DTO.ExaminationFrontDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Examination.Examination;

import java.util.List;

public interface IExaminationService {

    List<Examination> findAll ();

    void canceling(Integer id);
    Examination save1(ExaminationFrontDTO examinationDTO);

    Boolean getExaminationByIdStaff(Integer idPharmacist);
    Examination findById(Integer id);
    Examination save(ExaminationDTO examinationDTO);
    List<FrontCreatedExaminationDTO> findCreatedDermatologistExamination();

    void scheduledDermatologistExamination(Integer idPatient,Integer idExamination);


    }
