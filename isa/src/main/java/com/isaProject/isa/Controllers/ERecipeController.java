package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.FrontERecipeDTO;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Services.Implementations.ERecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value="/erecipe")
@Slf4j

public class ERecipeController {
    @Autowired
    ERecipeService eRecipeService;

    @GetMapping(value = "/findByIdPatient/{id}")
    public ResponseEntity<List<FrontERecipeDTO>> findSheduledPharmacistExamination(@PathVariable Integer id) {

        List<FrontERecipeDTO> d= eRecipeService.findByPatient(id);

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
}
