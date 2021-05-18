package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Services.Implementations.DrugService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/drug")
@Slf4j
public class DrugContorller {

    @Autowired
    private DrugService drugService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Drug>> findAll() {
        List<Drug> drugs=drugService.findAll();
        return drugs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drugs);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Drug> findById(@PathVariable Integer id) {

        Drug d=drugService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<Drug> findById(@PathVariable String name) {

        Drug d=drugService.findByName(name);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    @PostMapping("/create")
    public ResponseEntity<String> addDrug(@RequestBody DrugDTO drugDTO) {

        Drug drug = drugService.save(drugDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }



}
