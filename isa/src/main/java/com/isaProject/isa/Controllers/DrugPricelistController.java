package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DrugPricelistDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Repositories.DrugPricelistRepository;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Services.Implementations.DrugPricelistService;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.PharmacyDrugsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/drugPricelist", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class DrugPricelistController {
    @Autowired
    private DrugPricelistService drugService;

    @Autowired
    private DrugService drugService1;

    @Autowired
    PharmacyDrugsService pharmacyDrugsService;
    @Autowired
    DrugPricelistRepository drugPricelistRepository;

    @Autowired
    DrugRepository drugRepository;


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


    @GetMapping(value = "/findByName/{id}")
    public ResponseEntity<DrugPricelist> findByName(@PathVariable Integer id) {
        Drug drug=drugRepository.getOne(id);
        List<DrugPricelist> drugPricelist=drugPricelistRepository.findAll();
        DrugPricelist p=new DrugPricelist();
        for(DrugPricelist dp:drugPricelist){
            if(dp.getDrug().getIdDrug().equals(drug.getIdDrug())){
                p=new DrugPricelist();
            }
        }


        return p == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(p);
    }

    @GetMapping(value = "/getDrugsPricelistByIdPharm/{id}")
    public ResponseEntity<List<DrugPricelist>> findAllByIdPharm(@PathVariable Integer id) {
        List<DrugPricelist> drugs=drugPricelistRepository.findAllByIdPharm(id);

        return drugs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drugs);
    }



    @GetMapping(value = "/getDrugsPharmacy/{id}")
    public ResponseEntity<List<DrugPricelist>> findAll(@PathVariable Integer id) {
        List<DrugPricelist> drugs=drugService.findAllDrugsByPharmacy(id);

        return drugs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drugs);
    }



    @GetMapping(value = "/searchDrugName/{id}/{name}")
    public ResponseEntity<List<PharmacyDrugs>> searchName(@PathVariable (value = "id") Integer id,@PathVariable (value = "name") String name) {
        List<PharmacyDrugs> drugs=pharmacyDrugsService.findAll();
        ArrayList<PharmacyDrugs> newP = new ArrayList<>();

        for (PharmacyDrugs d:drugs){
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

    @PostMapping("/create/{idPharmacy}")
    public ResponseEntity<String> createDrugPricelist(@RequestBody DrugPricelistDTO drugPricelistDTO,@PathVariable Integer idPharmacy){

        String s="Pricelist created";
        DrugPricelist drug = drugService.save(drugPricelistDTO,idPharmacy);
        if(pharmacyDrugsService.check(idPharmacy,drugPricelistDTO.getName()).equals("The drug is not available at the pharmacy")){
            s="The drug is not available at the pharmacy";
        }
        return new ResponseEntity<>(s, HttpStatus.CREATED);
    }

    @PostMapping("/update/{id}")
    ResponseEntity<String> update(@RequestBody DrugPricelistDTO drugPricelistDTO,@PathVariable Integer id)
    {
        drugService.update(drugPricelistDTO,id);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }




}
