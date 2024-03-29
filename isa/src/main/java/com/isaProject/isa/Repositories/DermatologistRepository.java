package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Model.Users.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

import java.util.List;

@EnableJpaRepositories
public interface DermatologistRepository  extends JpaRepository<Dermatologist, Integer> {


}
