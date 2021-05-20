package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Services.Implementations.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value="/patient", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
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
}
