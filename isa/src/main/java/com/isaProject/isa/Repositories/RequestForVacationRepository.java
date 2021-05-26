package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.DTO.RequestForVacationDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.RequestForVacation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RequestForVacationRepository  extends JpaRepository<RequestForVacation, Integer> {


    }
