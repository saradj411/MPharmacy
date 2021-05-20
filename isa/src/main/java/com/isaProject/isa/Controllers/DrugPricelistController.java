package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Services.Implementations.DrugPricelistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/drugPricelist", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class DrugPricelistController {
    @Autowired
    private DrugPricelistService drugService;

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
}
