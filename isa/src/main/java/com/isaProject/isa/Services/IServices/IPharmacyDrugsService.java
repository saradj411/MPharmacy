package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;

import java.util.List;

public interface IPharmacyDrugsService {

    List<PharmacyDrugs> findAll();
    String remove(Integer idPharm,Integer idDrug);
    Boolean remove(Integer idPharm,Integer idDrug);

    List<PharmacyDrugs> findByName(String name);
    PharmacyDrugs findById(Integer id);

    String check(Integer id,String name);




    }
