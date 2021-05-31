package com.isaProject.isa.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Model.DTO.ChangePasswordDTO;
import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Services.Implementations.PatientService;
import com.isaProject.isa.Services.Implementations.PharmacyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/patient")
@Slf4j
@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private PharmacyService pharmacyService;

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

    @PostMapping("/updatePatient")
    ResponseEntity<String> update(@RequestBody Patient patient)
    {

        patientService.update(patient);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
    @GetMapping(value = "/findActionPharmacy/{id}")
    public ResponseEntity<Set<Pharmacy>> findActionPharmacy(@PathVariable Integer id) {

        Patient d= patientService.findById(id);
        Set<Pharmacy> pharmacies=new HashSet<>();
        pharmacies=d.getActionPharmacies();
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacies);
    }

    @GetMapping(value = "/findSheduledDermatologistExamination/{id}")
    public ResponseEntity<Set<FrontCreatedExaminationDTO>> findSheduledDermatologistExamination(@PathVariable Integer id) {

        Set<FrontCreatedExaminationDTO> d= patientService.findSheduledDermatologistExamination(id);

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    @GetMapping(value = "/findSheduledPharmacistExamination/{id}")
    public ResponseEntity<Set<FrontCreatedExaminationDTO>> findSheduledPharmacistExamination(@PathVariable Integer id) {

        Set<FrontCreatedExaminationDTO> d= patientService.findSheduledPharmacistExamination(id);

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    /*@GetMapping(value = "/findERecipe/{id}")
    public ResponseEntity<List<ERecipe>> findERecipe(@PathVariable Integer id) {

        List<ERecipe> d= patientService.findERecipe(id);

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }*/

}
