package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Repositories.DrugPricelistRepository;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Services.IServices.IDrugPricelistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class DrugPricelistService implements IDrugPricelistService {
    @Autowired
    DrugPricelistRepository drugRepository;

    @Autowired
    private DrugPricelistService drugService;

    @Autowired
    DrugRepository drugRepository1;


    @Override
    public List<DrugPricelist> findAll() {
        return drugRepository.findAll();
    }

    @Override
    public List<DrugPricelist> findAllDrugsByPharmacy(Integer id) {
        List<DrugPricelist> drugs=drugService.findAll();
        ArrayList<DrugPricelist> newP = new ArrayList<>();

        for (DrugPricelist d:drugs){
            if(d.getPharmacy().getIdPharm().equals(id)){
                System.out.println("eee"+d.getPharmacy().getIdPharm());

                newP.add(d);
            }
        }
        return newP;
    }




    @Override
    public DrugPricelist findById(Integer id) {
        DrugPricelist drugg = drugRepository.findOneByIdPricelist(id);
        return drugg;
    }
    //name
    @Override
    public List<DrugPricelist> getSearchDrugs(Integer idPharm, String name){
        System.out.println("usllo u servis ");
        List<DrugPricelist> lista= drugRepository.findAllDrugsByNameAndIdPharmacy(idPharm,name);
        for(DrugPricelist d:lista){
            System.out.println("ime lijeka jeeee "+d.getDrug().getName());
            d.getPharmacy();
            d.getDrug();
        }
        return lista;

    }










}
