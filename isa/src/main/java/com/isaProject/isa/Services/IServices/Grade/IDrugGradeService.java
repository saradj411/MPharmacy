package com.isaProject.isa.Services.IServices.Grade;

import com.isaProject.isa.Model.Grades.DrugGrade;
import com.isaProject.isa.Model.Grades.PharmacistGrade;

import java.util.List;

public interface IDrugGradeService {
    List<DrugGrade> findAll ();

    DrugGrade grade(Integer idPatient,Integer grade,Integer idDrug);

}
