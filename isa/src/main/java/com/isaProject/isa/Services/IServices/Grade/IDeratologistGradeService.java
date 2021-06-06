package com.isaProject.isa.Services.IServices.Grade;

import com.isaProject.isa.Model.Grades.DermatolgoistGrade;

import java.util.List;

public interface IDeratologistGradeService {

    List<DermatolgoistGrade> findAll ();

    DermatolgoistGrade grade(Integer idPatient,Integer grade,Integer idDerm);
}
