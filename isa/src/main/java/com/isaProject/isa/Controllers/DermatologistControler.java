package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Services.Implementations.DermatologistService;
import com.isaProject.isa.Services.Implementations.DrugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;



@RestController
@CrossOrigin
@RequestMapping(value="/dermatologist")
@Slf4j
public class DermatologistControler {

    @Autowired
    private DermatologistService dermatologistService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Dermatologist>> findAll() {
        List<Dermatologist> dermatologists=dermatologistService.findAll();
        for (Dermatologist d:dermatologists){
            System.out.println(d.getIdUser());
            System.out.println(d.getPharmacies());


        }
        return dermatologists == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(dermatologists);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Dermatologist> findById(@PathVariable Integer id) {

        Dermatologist d= dermatologistService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }

    @GetMapping(value = "/getDermatologists/{id}")
    public ResponseEntity<List<Dermatologist>> findAll(@PathVariable Integer id) {
        List<Dermatologist> dermatologists=dermatologistService.findAll();
        ArrayList<Dermatologist> newDermatologists = new ArrayList<Dermatologist>();

        for (Dermatologist d:dermatologists){
            for(Pharmacy pharm:d.getPharmacies()){
                if(pharm.getIdPharm().equals(id)){
                    System.out.println("eee"+pharm.getIdPharm());
                    newDermatologists.add(d);
                    System.out.println("eee"+d.getName());
                    System.out.println("eee"+newDermatologists);

                }
            }


        }
        return newDermatologists == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newDermatologists);
    }



}
