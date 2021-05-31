package com.isaProject.isa.Repositories;


import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Users.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PatientRepository  extends JpaRepository<Patient, Integer> {
    @Query("select s from Patient s where s.id= ?1")
    Patient find(Integer id);
}
