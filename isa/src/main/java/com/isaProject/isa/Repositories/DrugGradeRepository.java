package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Grades.DrugGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface DrugGradeRepository extends JpaRepository<DrugGrade,Integer> {
    @Query("select s from DrugGrade s where s.idPatient= ?1 and s.idDrug= ?2")
    DrugGrade getByPatientAndDrug(Integer idP,Integer idD);

}