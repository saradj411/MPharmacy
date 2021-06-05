package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.DTO.RequestForVacationDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.RequestForVacation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface RequestForVacationRepository  extends JpaRepository<RequestForVacation, Integer> {

    @Query("select s from RequestForVacation s where s.pharmacy.idPharm= ?1")
    public List<RequestForVacation> find(Integer idPharm);


}
