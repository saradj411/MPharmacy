package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Examination.Examination;

import java.util.List;

public interface IExaminationService {

    List<Examination> findAll ();

    void canceling(Integer id);

    Boolean getExaminationByIdStaff(Integer idPharmacist);
    List<FrontCreatedExaminationDTO> findCreatedDermatologistExamination();

}
