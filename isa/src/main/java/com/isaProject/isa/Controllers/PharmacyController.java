package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Services.IServices.IPharmacyService;
import com.isaProject.isa.Services.Implementations.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    @Autowired
    IPharmacyService pharmacyService;

    @RequestMapping(value = {"/findAll"}, method = {RequestMethod.GET})
    public ResponseEntity<List<Pharmacy>> findAll() {
        return null;
    }

}
