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


    @PostMapping("/create")
    public ResponseEntity<String> addDrug(@RequestBody RequestForVacationDTO requestForVacationDTO) {
        System.out.println("start "+requestForVacationDTO.getStart());
        System.out.println("end "+requestForVacationDTO.getEnd());
        System.out.println("opis "+requestForVacationDTO.getDescription());
        RequestForVacation requestForVacation = requestForVacationService.save(requestForVacationDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }
}
