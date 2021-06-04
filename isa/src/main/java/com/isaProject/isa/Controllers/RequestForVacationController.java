package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.RequestForVacationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Users.RequestForVacation;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.RequestForVacationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin
@RequestMapping(value="/requestVacation")
@Slf4j

public class RequestForVacationController {


    @Autowired
    private RequestForVacationService requestForVacationService;



    @PostMapping("/createPharmacist")
    public ResponseEntity<String> createPharmacist(@RequestBody RequestForVacationDTO requestForVacationDTO) {
        RequestForVacation requestForVacation = requestForVacationService.save1(requestForVacationDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }
    @PostMapping("/create")
    public ResponseEntity<String> addDrug(@RequestBody RequestForVacationDTO requestForVacationDTO) {
        RequestForVacation requestForVacation = requestForVacationService.save(requestForVacationDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }
}
