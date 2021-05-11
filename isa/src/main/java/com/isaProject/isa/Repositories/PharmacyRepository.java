package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;


public interface PharmacyRepository extends JpaRepository<Pharmacy, Long>{
}
