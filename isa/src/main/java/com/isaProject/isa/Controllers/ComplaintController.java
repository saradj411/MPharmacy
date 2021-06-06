package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.ComplainDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Complaint;
import com.isaProject.isa.Services.Implementations.ComplainService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@RequestMapping(value="/complaint")
@Slf4j
public class ComplaintController {

    @Autowired
    ComplainService complainService;

    @PostMapping("/save")
    @PreAuthorize("hasRole('PATIENT')")
    ResponseEntity<Complaint> save(@RequestBody ComplainDTO complainDTO)
    {
        Complaint complaint = complainService.save(complainDTO);
        return complaint != null ? new ResponseEntity<>(complaint, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }


}
