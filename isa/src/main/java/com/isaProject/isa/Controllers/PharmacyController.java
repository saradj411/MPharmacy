package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Services.IServices.IPharmacyService;
import com.isaProject.isa.Services.Implementations.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value="/pharmacy")
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

}
