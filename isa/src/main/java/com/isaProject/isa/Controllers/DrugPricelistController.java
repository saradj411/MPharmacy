package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DrugPricelistDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Services.Implementations.DrugPricelistService;
import com.isaProject.isa.Services.Implementations.DrugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/drugPricelist", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class DrugPricelistController {
    @Autowired
    private DrugPricelistService drugService;

    @Autowired
    private DrugService drugService1;

    @GetMapping("/delete/{idDrug}/{idPharm}")
    public ResponseEntity<Boolean> deleteDermatologist(@PathVariable Integer idDrug,@PathVariable Integer idPharm ) {
        Drug drug = drugService1.findById(idDrug);
        Boolean answer = drugService1.remove(drug, idPharm);
        return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);
    }
        @GetMapping(value = "/findAll")
    public ResponseEntity<List<DrugPricelist>> findAll() {
        List<DrugPricelist> pricelists=drugService.findAll();
        return pricelists == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pricelists);
    }
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<DrugPricelist> findById(@PathVariable Integer id) {
        //log.info("dsds:"+id);
        DrugPricelist pharm=drugService.findById(id);
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }




    @GetMapping(value = "/getDrugsPharmacy/{id}")
    public ResponseEntity<List<DrugPricelist>> findAll(@PathVariable Integer id) {
        List<DrugPricelist> drugs=drugService.findAllDrugsByPharmacy(id);

        return drugs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drugs);
    }



    @GetMapping(value = "/searchDrugName/{id}/{name}")
    public ResponseEntity<List<DrugPricelist>> searchName(@PathVariable (value = "id") Integer id,@PathVariable (value = "name") String name) {
        List<DrugPricelist> drugs=drugService.findAll();
        ArrayList<DrugPricelist> newP = new ArrayList<>();

        for (DrugPricelist d:drugs){
            if(d.getPharmacy().getIdPharm().equals(id)){
                System.out.println("Id apoteke u kojoj su lijekovi je "+d.getPharmacy().getIdPharm());
                System.out.println("Ime lijeka je "+d.getDrug().getName());
                if(d.getDrug().getName().contains(name)){
                    System.out.println("ime je "+name);
                    System.out.println("usao u if");
                    newP.add(d);
                }

            }
        }

        for(DrugPricelist d:newP){
            System.out.println("usao");


        }
        return newP == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newP);
    }



    @GetMapping(value = "/serachName/{id}/{name}")
    public ResponseEntity<List<DrugPricelist>> findByNameDrug(@PathVariable (value = "id") Integer id,@PathVariable (value = "name") String name) {
        List<DrugPricelist> drugs=drugService.getSearchDrugs(id,name);

        return drugs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drugs);
    }



}
