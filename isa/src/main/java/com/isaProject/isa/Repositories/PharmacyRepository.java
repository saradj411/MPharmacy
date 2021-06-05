package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface PharmacyRepository extends JpaRepository<Pharmacy, Integer>{

    Pharmacy findOneByIdPharm(Integer idPharm);
    List<Pharmacy> findOneByName(String name);
    List<Pharmacy> findOneByAddress(String address);

    @Query("select s from Pharmacy s where s.idPharm= ?1")
    Pharmacy findOneByNamee(String name);

    @Query("FROM Pharmacy")
    List<Pharmacy> findAllOrderByNameAsc(Sort sort);
    @Query("FROM Pharmacy")
    List<Pharmacy> findAllOrderByNameDesc(Sort sort);
}
