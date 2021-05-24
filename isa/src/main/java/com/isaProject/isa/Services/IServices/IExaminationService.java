package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Examination.Examination;

import java.util.List;

public interface IExaminationService {

    List<Examination> findAll ();
    Boolean getExaminationByIdStaff(Integer idPharmacist);
}
