package com.isaProject.isa.Repositories;


import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface DrugPricelistRepository extends JpaRepository<DrugPricelist, Integer> {
    DrugPricelist findOneByIdPricelist(Integer idDrug);

    @Query("select ex from DrugPricelist  ex where ex.pharmacy.idPharm = ?1 and ex.drug.name = ?2")
    List<DrugPricelist> findAllDrugsByNameAndIdPharmacy(Integer idPharmacy,String name);

    //findAllDrugsByIdDrugAndIdPharmacy

    @Query("select ex from DrugPricelist  ex where ex.pharmacy.idPharm = ?1 and ex.drug.idDrug = ?2")
    DrugPricelist findAllDrugsByIdDrugAndIdPharmacy(Integer idPharm,Integer idDrug);

    //listu cijenovnika jedne apoteke

    @Query("select ex from DrugPricelist  ex where ex.pharmacy.idPharm = ?1")
    List<DrugPricelist> findAllByIdPharm(Integer idPharm);


}
