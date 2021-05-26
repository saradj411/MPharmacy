package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface DrugRepository extends JpaRepository<Drug, Integer> {
    List<Drug> findOneByName(String name);
    Drug findOneByIdDrug(Integer idDrug);

}
