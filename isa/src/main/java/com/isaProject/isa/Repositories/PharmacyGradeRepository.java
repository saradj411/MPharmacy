package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Grades.DermatolgoistGrade;
import com.isaProject.isa.Model.Grades.PharmacyGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface PharmacyGradeRepository extends JpaRepository<PharmacyGrade,Integer> {

    @Query("select s from PharmacyGrade s where s.idPatient= ?1 and s.idPharmacy= ?2")
    PharmacyGrade getByPatientAndPharmacy(Integer idP,Integer idD);
}
