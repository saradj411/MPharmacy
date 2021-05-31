package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Examination.Examination;

import java.util.List;

public interface IExaminationService {

    List<Examination> findAll ();

    void canceling(Integer id);

    Boolean getExaminationByIdStaff(Integer idPharmacist);
    Examination findById(Integer id);
    Examination save(ExaminationDTO examinationDTO);


    }
