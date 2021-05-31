package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.Drug;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Integer> {
    List<Drug> findOneByName(String name);

    @Query("select s from Drug s where s.name= ?1")
    Drug findOneByNameDrug(String  name);

    Drug findOneByIdDrug(Integer idDrug);

}
