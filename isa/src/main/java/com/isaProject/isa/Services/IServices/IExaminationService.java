package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Examination.Examination;

import java.util.List;

public interface IExaminationService {

    List<Examination> findAll ();
    Examination findById(Integer id);

    void canceling(Integer id);
    void patientCanceling(Examination examination);
    Boolean getExaminationByIdStaff(Integer idPharmacist);
    List<FrontCreatedExaminationDTO> findCreatedDermatologistExamination();

    void scheduledDermatologistExamination(Integer idPatient,Integer idExamination);

}
