package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;

import java.util.List;

public interface IPharmacyDrugsService {

    List<PharmacyDrugs> findAll();
    String remove(Integer idPharm,Integer idDrug);
    String check(Integer id,String name);



    }
