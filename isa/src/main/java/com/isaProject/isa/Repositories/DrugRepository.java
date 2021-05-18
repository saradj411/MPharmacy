package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.Drug;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugRepository extends JpaRepository<Drug, Integer> {
    Drug findOneByName(String name);
    Drug findOneByIdDrug(Integer idDrug);
}
