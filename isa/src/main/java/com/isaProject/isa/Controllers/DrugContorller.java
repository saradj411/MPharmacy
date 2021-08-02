package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.*;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.SpecificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/drug")
@Slf4j
public class DrugContorller {

    @Autowired
    private DrugService drugService;
    @Autowired
    private SpecificationService specificationService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Drug>> findAll() {
        List<Drug> drugs=drugService.findAll();
        return drugs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drugs);
    }
    @GetMapping(value = "/findAllNames")
    public ResponseEntity<List<Drug>> findAllNames() {
        List<Drug> drugs=drugService.findAll();
        return drugs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(drugs);
    }

    @GetMapping(value = "/alternative")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<List<AlternativeDrugDTO>> alternative() {
        List<AlternativeDrugDTO> alter= drugService.alternativeDrugs();
        return alter == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(alter);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Drug> findById(@PathVariable Integer id) {

        Drug d=drugService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    @GetMapping(value = "/findByName/{name}}")
    public ResponseEntity<List<Drug>> findByName(@PathVariable String name) {
        //log.info("dsds:"+id);
        List<Drug> pharm=drugService.findByName(name);
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }
    @PostMapping("/create")
    public ResponseEntity<Drug> addDrug(@RequestBody DrugDTO drugDTO) {

        Drug drug = drugService.save(drugDTO);
        return new ResponseEntity<>(drug, HttpStatus.CREATED);
    }

    @PostMapping("/updateDrug")
    ResponseEntity<String> update(@RequestBody Drug drug)
    {
        drugService.update(drug);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

    @PostMapping(value = "/createDrug")
    ResponseEntity<String> update(@RequestBody DrugNewDTO drugNewDTO)
    {
        System.out.println("id apoteke je "+drugNewDTO.getIdPharm());
        System.out.println("Ime je "+drugNewDTO.getName());
        System.out.println("Kod  je "+drugNewDTO.getPassword());


        Drug dermatologist=drugService.create(drugNewDTO);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

    @PostMapping("/addDrugAndSpecification")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<String> addSpecificationAndDrug(@RequestBody DrugAndSpecDTO drugAndSpec) {
        System.out.println(drugAndSpec);
        DrugDTO drugDTO = new DrugDTO(drugAndSpec.getName(),
                drugAndSpec.getCode(),
                drugAndSpec.isRecipeNeed(),
                drugAndSpec.getDrugType(),
                drugAndSpec.getFormat(),
                drugAndSpec.getManufacturer(),
                drugAndSpec.getPoints(),
                drugAndSpec.getAlternatives());

        Drug u = drugService.saveForShifarnik(drugDTO);
        if(u != null)
        {
            SpecificaitonDTO specDTO = new SpecificaitonDTO(
                    drugAndSpec.getContraindications(),
                    drugAndSpec.getStructure(),
                    drugAndSpec.getRecommendedDose(),
                    u,
                    drugAndSpec.getIngredients()
            );

            Specification s = specificationService.save(specDTO);
            return new ResponseEntity<>("Successeffully created sifarnik!", HttpStatus.CREATED);
        }

        return new ResponseEntity<>("Something went wrong!", HttpStatus.BAD_REQUEST);


    }





}
