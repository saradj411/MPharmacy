package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Services.Implementations.DermatologistService;
import com.isaProject.isa.Services.Implementations.PharmacistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/pharmacist")
@Slf4j
public class PharmacistController {

    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Pharmacist>> findAll() {
        List<Pharmacist> pharmacists=pharmacistService.findAll();
        for (Pharmacist d:pharmacists){
            System.out.println(d.getIdUser());
            d.getPharmacy();


        }
        return pharmacists == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacists);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Pharmacist> findById(@PathVariable Integer id) {

        Pharmacist d= pharmacistService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
}
