package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;


public interface PharmacyDrugsRepository extends JpaRepository<PharmacyDrugs, Integer> {

    @Query("select s from PharmacyDrugs s where s.pharmacy.idPharm= ?1 and s.drug.idDrug= ?2" )
    PharmacyDrugs findByIdDrugAndIfPharm(Integer idPharm,Integer idDrug);
}
