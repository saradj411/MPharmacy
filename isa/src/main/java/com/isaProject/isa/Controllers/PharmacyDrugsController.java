package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Repositories.PharmacyDrugsRepository;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.PharmacyDrugsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/pharmacyDrugs")
@Slf4j
public class PharmacyDrugsController {


    @Autowired
    private PharmacyDrugsService pharmacyDrugsService;
    @Autowired
    private PharmacyDrugsRepository pharmacyDrugsRepository;

    @GetMapping("/delete/{idDrug}/{idPharm}")
    public ResponseEntity<Boolean> deleteDermatologist(@PathVariable Integer idDrug, @PathVariable Integer idPharm ) {

       // Drug drug = pharmacyDrugsService.findById(idPharm,idDrug);
        Boolean answer = pharmacyDrugsService.remove(idPharm,idDrug);

        return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);
    }
    @GetMapping("/getAll")
    public ResponseEntity<List<PharmacyDrugs>> getAll() {
        List<PharmacyDrugs> drugs=pharmacyDrugsService.findAll();
        List<PharmacyDrugs> newList=new ArrayList<>();
        for(PharmacyDrugs pD:drugs){
            if(pD.getQuantity()>0){
                newList.add(pD);
            }
        }
        return newList == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newList);
    }

    @GetMapping("/getAllByName/{name}")
    public ResponseEntity<List<PharmacyDrugs>> getAll(@PathVariable String name) {
        List<PharmacyDrugs> drugs=pharmacyDrugsService.findByName(name);
        List<PharmacyDrugs> newList=new ArrayList<>();
        for(PharmacyDrugs pD:drugs){
            if(pD.getQuantity()>0){
                newList.add(pD);
            }
        }
        return newList == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newList);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PharmacyDrugs> getById(@PathVariable Integer id) {
        PharmacyDrugs drug=pharmacyDrugsService.findById(id);

        return drug == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drug);
    }

}
