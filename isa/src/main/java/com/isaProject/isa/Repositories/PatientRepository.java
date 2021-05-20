package com.isaProject.isa.Repositories;


import com.isaProject.isa.Model.Users.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatientRepository  extends JpaRepository<Patient, Integer> {
}
