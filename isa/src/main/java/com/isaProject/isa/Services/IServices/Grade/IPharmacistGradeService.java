package com.isaProject.isa.Services.IServices.Grade;

import com.isaProject.isa.Model.Grades.DermatolgoistGrade;
import com.isaProject.isa.Model.Grades.PharmacistGrade;

import java.util.List;

public interface IPharmacistGradeService {
    List<PharmacistGrade> findAll ();

    PharmacistGrade grade(Integer idPatient,Integer grade,Integer idPharm);
}
