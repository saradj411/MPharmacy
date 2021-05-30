package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Services.Implementations.ExaminationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@CrossOrigin("*")
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
    @GetMapping(value = "/findCreatedPharmacistExamination")
    public ResponseEntity<List<FrontCreatedExaminationDTO>> findCreatedPharmacistExamination() {
        //log.info("dsds:"+id);
        List<FrontCreatedExaminationDTO> pharm=examinationService.findCreatedDermatologistExamination();
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }

    @PostMapping("/patientScheduledDermatologistExamination/{id}/{idExamination}")
    ResponseEntity<String> scheduledDermatologistExamination(@PathVariable Integer id,@PathVariable Integer idExamination)
    {

        examinationService.scheduledDermatologistExamination(id,idExamination);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
}
