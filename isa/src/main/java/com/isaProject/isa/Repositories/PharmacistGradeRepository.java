package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Grades.DermatolgoistGrade;
import com.isaProject.isa.Model.Grades.PharmacistGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PharmacistGradeRepository extends JpaRepository<PharmacistGrade,Integer> {
    @Query("select s from PharmacistGrade s where s.idPatient= ?1 and s.idPharmacist= ?2")
    PharmacistGrade getByPatientAndPharmacist(Integer idP, Integer idD);
}