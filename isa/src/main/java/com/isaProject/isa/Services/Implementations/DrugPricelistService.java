package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Repositories.DrugPricelistRepository;
import com.isaProject.isa.Services.IServices.IDrugPricelistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DrugPricelistService implements IDrugPricelistService {
    @Autowired
    DrugPricelistRepository drugRepository;
    @Override
    public List<DrugPricelist> findAll() {
        return drugRepository.findAll();
    }
    @Override
    public DrugPricelist findById(Integer id) {
        DrugPricelist drugg = drugRepository.findOneByIdPricelist(id);
        return drugg;
    }
}
