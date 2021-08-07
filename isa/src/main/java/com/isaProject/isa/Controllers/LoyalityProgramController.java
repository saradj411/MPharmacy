package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.LoyalityProgramDTO;
import com.isaProject.isa.Model.Users.LoyalityProgram;
import com.isaProject.isa.Services.Implementations.LoyalityProgramService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/loyality")
@Slf4j
public class LoyalityProgramController {

    @Autowired
    LoyalityProgramService loyalityProgramService;

    @PostMapping("/save")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<LoyalityProgram> save(@RequestBody LoyalityProgramDTO loyalityProgramDTO)
    {
        LoyalityProgram lp = loyalityProgramService.save(loyalityProgramDTO);
        return new ResponseEntity<LoyalityProgram>(lp, HttpStatus.CREATED);

    }
}
