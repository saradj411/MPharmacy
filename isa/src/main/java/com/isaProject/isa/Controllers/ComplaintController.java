package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.ComplainDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Complaint;
import com.isaProject.isa.Model.Pharmacy.StaffComplaint;
import com.isaProject.isa.Repositories.StaffComplaintRepository;
import com.isaProject.isa.Services.Implementations.ComplainService;
import com.isaProject.isa.Services.Implementations.StaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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
    @GetMapping("/findAll")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<List<Complaint>> findAll()
    {
         List<Complaint> complaints = complainService.findAll();
         return complaints != null ? new ResponseEntity<>(complaints, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }
    @Autowired
    StaffComplaintRepository staffComplaintRepository;
    @GetMapping("/findAllStaffComplaint")
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<List<StaffComplaint>> findAllStaffComplaint()
    {
        List<StaffComplaint> complaints = staffComplaintRepository.findAll();
        return complaints != null ? new ResponseEntity<>(complaints, HttpStatus.CREATED)
                : new ResponseEntity<>(null, HttpStatus.BAD_REQUEST);

    }

}
