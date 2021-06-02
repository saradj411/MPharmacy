package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.SpecificaitonDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Services.Implementations.SpecificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value="/specification")
public class SpecificationController {

    @Autowired
    SpecificationService specificationService;

    /*@PostMapping("/create")
    public ResponseEntity<Specification> addDrug(@RequestBody SpecificaitonDTO specDTO) {

        Specification spec = specificationService.save(specDTO);
        return new ResponseEntity<>(spec, HttpStatus.CREATED);
    }*/


}
