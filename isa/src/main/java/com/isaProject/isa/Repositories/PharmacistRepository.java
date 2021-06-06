package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Model.Users.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PharmacistRepository  extends JpaRepository<Pharmacist, Integer> {

    @Query("select s from Pharmacist s where s.pharmacy.idPharm= ?1") //za derm
    List<Pharmacist> findWorkTimeByIdDermAndIdPharm(Integer id);


}
