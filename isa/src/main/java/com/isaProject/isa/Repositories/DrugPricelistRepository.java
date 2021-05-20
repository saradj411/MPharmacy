package com.isaProject.isa.Repositories;


import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DrugPricelistRepository extends JpaRepository<DrugPricelist, Integer> {
    DrugPricelist findOneByIdPricelist(Integer idDrug);
}
