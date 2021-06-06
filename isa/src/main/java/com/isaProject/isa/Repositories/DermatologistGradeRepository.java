package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Grades.DermatolgoistGrade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DermatologistGradeRepository extends JpaRepository<DermatolgoistGrade,Integer> {
    @Query("select s from DermatolgoistGrade s where s.idPatient= ?1 and s.idDermatologist= ?2")
    DermatolgoistGrade getByPatientAndDermatologist(Integer idP,Integer idD);

}
