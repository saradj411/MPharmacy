package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.IngredientDTO;
import com.isaProject.isa.Model.DTO.SpecificationDTO;
import com.isaProject.isa.Services.Implementations.SpecificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value="/specification")
@Slf4j

public class SpecificationController {

    @Autowired
    private SpecificationService specificationService;

    @GetMapping(value = "/getSpec/{name}")//radiii
    public ResponseEntity<SpecificationDTO> getSpecc(@PathVariable String name) {

        System.out.println("ime lijka je "+name);

        SpecificationDTO d= specificationService.getSpecById(name);
        Set<IngredientDTO> i=d.getIngredients();

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    @GetMapping(value = "/getIngredients/{name}")//radiii
    public ResponseEntity<Set<IngredientDTO>> getSpec(@PathVariable String name) {

        System.out.println("ime lijka je "+name);

        SpecificationDTO d= specificationService.getSpecById(name);
        Set<IngredientDTO> i=d.getIngredients();

        return i == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(i);
    }
}
