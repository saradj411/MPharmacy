package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Services.Implementations.SpecificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value="/specification")
@Slf4j

public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping(value = "/getSpec/{name}")//radiii
    public ResponseEntity<Specification> getSpecc(@PathVariable String name) {
        System.out.println("ime lijka je "+name);
        Specification d= specificationService.getSpecById(name);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }

    @GetMapping(value = "/findSpecByDrugName/{name}")//radiii
    public ResponseEntity<Specification> getDrugSpecByName(@PathVariable String name) {
        Specification specification = specificationService.findByName(name);
        return specification == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<Specification>(specification, HttpStatus.OK);
    }




}
