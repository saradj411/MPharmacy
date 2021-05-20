package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;

import java.util.List;

public interface IDrugPricelistService {
    DrugPricelist findById(Integer id);
    List<DrugPricelist> findAll ();

}