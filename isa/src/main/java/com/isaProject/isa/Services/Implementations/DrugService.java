package com.isaProject.isa.Services.Implementations;


import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Services.IServices.IDrugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class DrugService implements IDrugService {

    @Autowired
    DrugRepository drugRepository;

    @Override
    public Drug findById(Integer id) {
        Drug drugg = drugRepository.findOneByIdDrug(id);
        return drugg;
    }
    @Override
    public Drug findByName(String name) {
        Drug drugg = drugRepository.findOneByName(name);
        return drugg;
    }

    @Override
    public List<Drug> findAll() {

        return drugRepository.findAll();
    }

    @Override
    public Drug save(DrugDTO drug) {
        Drug d = new Drug();
        d.setName(drug.getName());
        d.setCode(drug.getCode());
        d.setDrugType(drug.getDrugType());
        d.setFormat(drug.getFormat());
        d.setManufacturer(drug.getManufacturer());
        d.setRecipeNeed(drug.isRecipeNeed());
        return drugRepository.save(d);
    }
    @Override
    public void update(Drug drug) {
        Drug d = drugRepository.getOne(drug.getIdDrug());

        d.setName(drug.getName());
        d.setCode(drug.getCode());
        d.setDrugType(drug.getDrugType());
        d.setFormat(drug.getFormat());
        d.setManufacturer(drug.getManufacturer());
        d.setRecipeNeed(drug.isRecipeNeed());

        drugRepository.save(d);

    }
}
