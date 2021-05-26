package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Services.Implementations.ExaminationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value="/examination")
@Slf4j
public class ExaminationController {
    @Autowired
    ExaminationService examinationService;

    @PostMapping("/canceling/{id}")
    ResponseEntity<String> update(@PathVariable Integer id)
    {

        examinationService.canceling(id);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
}
