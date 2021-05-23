package com.isaProject.isa.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Model.DTO.ChangePasswordDTO;
import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Services.Implementations.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/patient", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientController {

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Integer id) {

        Patient d= patientService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }

    @GetMapping("/addAllergy/{id}/{idPatient}")
    public ResponseEntity<String> addDrug(@PathVariable(value = "id") Integer id,
                                          @PathVariable(value = "idPatient") Integer idPatient ) {

        patientService.saveAllergy(id,idPatient);
        return new ResponseEntity<>("Allergy is added", HttpStatus.CREATED);
    }

    @PostMapping(value="/updatePatient",consumes = MediaType.APPLICATION_JSON_VALUE)
    ResponseEntity<String> update(@RequestBody Patient patient)
    {

        patientService.update(patient);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
    


}
