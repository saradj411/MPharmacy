package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Model.Users.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface SpecificationRepository  extends JpaRepository<Specification, Integer> {

    @Query("select s from Specification s where s.drug.name= ?1") //za pharm
    Specification findByNameDrug(String name);
    
}
