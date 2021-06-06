package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Users.Dermatologist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

public interface DermatologistRepository  extends JpaRepository<Dermatologist, Integer> {

}
