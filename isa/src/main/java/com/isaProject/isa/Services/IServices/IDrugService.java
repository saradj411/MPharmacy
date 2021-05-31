package com.isaProject.isa.Services.IServices;


import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.Drugs.Drug;

import java.util.List;

public interface IDrugService {

    Drug findById(Integer id);
    List<Drug> findByName(String name);
    List<Drug> findAll ();
    Drug save(DrugDTO drug);
    void update(Drug drug);
    //dodati za rezervaciju kad Sara uradi
    Boolean remove(Drug medication, Integer idAdmin);

    }
