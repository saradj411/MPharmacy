package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.PharmacyDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Services.IServices.IPharmacyService;
import com.isaProject.isa.Services.Implementations.PharmacyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/pharmacy")
@Slf4j
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Pharmacy>> findAll() {
        List<Pharmacy> pharmacies=pharmacyService.findAll();
        return pharmacies == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacies);
    }
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Pharmacy> findById(@PathVariable Integer id) {
        //log.info("dsds:"+id);
        Pharmacy pharm=pharmacyService.findById(id);
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }

    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<Pharmacy> findById(@PathVariable String name) {
        //log.info("dsds:"+id);
        Pharmacy pharm=pharmacyService.findByName(name);
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }
    @PostMapping("/register")
    public ResponseEntity<String> addPharmacy(@RequestBody PharmacyDTO pharmacyDTO) {

        Pharmacy pharmacy = pharmacyService.save(pharmacyDTO);
        return new ResponseEntity<>("SACUVANOOO", HttpStatus.CREATED);
    }

    @PostMapping("/updatePharmacy")
    ResponseEntity<String> update(@RequestBody Pharmacy pharmacy)
    {

        pharmacyService.update(pharmacy);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
}
