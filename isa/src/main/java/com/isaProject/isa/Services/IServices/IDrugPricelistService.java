package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.DrugPricelistDTO;
import com.isaProject.isa.Model.DTO.DrugPricelistUpdateDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;

import java.util.List;

public interface IDrugPricelistService {
    DrugPricelist findById(Integer id);
    List<DrugPricelist> findAll();
    List<DrugPricelist> getSearchDrugs(Integer idPharm, String name);
    List<DrugPricelist> findAllDrugsByPharmacy(Integer id);
    DrugPricelist findByIdDrugAndIdPharmacy(Integer idDrug, Integer idPharmacy);
    DrugPricelist save(DrugPricelistDTO drugPricelistDTO, Integer idPharmacy);
    void update(DrugPricelistDTO drugPricelistDTO, Integer id);

}