package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.ERecipeDTO;
import com.isaProject.isa.Model.DTO.FrontERecipeDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Services.Implementations.ERecipeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.Comparator;
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

    @GetMapping("/sortByDateAscending/{id}")
    ResponseEntity<List<FrontERecipeDTO>> sortByGradeGrowing(@PathVariable Integer id)
    {
        List<FrontERecipeDTO> recipes= eRecipeService.findByPatient(id);
        Collections.sort(recipes, new Comparator<FrontERecipeDTO>() {
            @Override
            public int compare(FrontERecipeDTO p1, FrontERecipeDTO p2) {
                return p1.getDateOfIssue().compareTo(p2.getDateOfIssue());

            }
        });

        return ResponseEntity.ok(recipes);
    }
    @GetMapping("/sortByDateDescending/{id}")
    ResponseEntity<List<FrontERecipeDTO>> sortByGradeDescending(@PathVariable Integer id)
    {
        List<FrontERecipeDTO> recipes= eRecipeService.findByPatient(id);
        Collections.sort(recipes, new Comparator<FrontERecipeDTO>() {
            @Override
            public int compare(FrontERecipeDTO p1, FrontERecipeDTO p2) {
                return p1.getDateOfIssue().compareTo(p2.getDateOfIssue());

            }
        });
        Collections.reverse(recipes);

        return ResponseEntity.ok(recipes);
    }

    @PostMapping("/createERecp")
    @PreAuthorize("hasRole('DERMATOLOGIST') || hasRole('PHARMACIST')")
    public ResponseEntity<List<ERecipeDTO>> getByName(@RequestBody List<ERecipeDTO> eRecipeDTOS)
    {
        System.out.println(eRecipeDTOS);
        return new ResponseEntity(eRecipeService.create(eRecipeDTOS), HttpStatus.OK);

    }
}
