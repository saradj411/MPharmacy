package com.isaProject.isa.Services.IServices.Grade;

import com.isaProject.isa.Model.Grades.PharmacyGrade;

import java.util.List;

public interface IPharmacyGradeService {
    List<PharmacyGrade> findAll ();

    PharmacyGrade grade(Integer idPatient,Integer grade,Integer idPharm);

}
