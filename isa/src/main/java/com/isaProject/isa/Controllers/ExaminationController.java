package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Examination.Examination;

import com.isaProject.isa.Services.Implementations.DrugReservationService;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;

import com.isaProject.isa.Services.Implementations.ExaminationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.List;


@RestController
@CrossOrigin("*")
@RequestMapping(value="/examination")
@Slf4j
public class ExaminationController {
    @Autowired
    ExaminationService examinationService;
    @Autowired
    DrugReservationService drugReservationService;

    @PostMapping("/canceling/{id}")
    ResponseEntity<String> update(@PathVariable Integer id)
    {

        examinationService.canceling(id);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
    @GetMapping(value = "/findPatientById/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Integer id) {

        Examination examination= examinationService.findById(id);
        Patient patient=examination.getPatient();
        return patient == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(patient);
    }

    @GetMapping(value = "/findExamination/{id}")
    public ResponseEntity<Examination> findByIdEx(@PathVariable Integer id) {

        Examination examination= examinationService.findById(id);
        return examination == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(examination);
    }
    @GetMapping(value = "/findStaff/{id}")
    public ResponseEntity<Staff> findStaff(@PathVariable Integer id) {

        Examination examination= examinationService.findById(id);
        Staff staff=examination.getStaff();
        return staff == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(staff);
    }

    @GetMapping(value = "/findPharmacy/{id}")
    public ResponseEntity<Pharmacy> findPharmacy(@PathVariable Integer id) {

        Examination examination= examinationService.findById(id);
        Pharmacy pharmacy=examination.getPharmacy();
        return pharmacy == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacy);
    }


    @PostMapping("/create")
    public ResponseEntity<String> addDrug(@RequestBody ExaminationDTO examinationDTO) {
        System.out.println("Usao u pregleddd");
        System.out.println("examination  " + examinationDTO.getStart());
        System.out.println("end " + examinationDTO.getEnd());
        Examination examination = examinationService.save(examinationDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
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
    ResponseEntity<String> scheduledDermatologistExamination(@PathVariable Integer id,@PathVariable Integer idExamination) throws MessagingException {

        examinationService.scheduledDermatologistExamination(id,idExamination);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
    @GetMapping(value = "/getBool/{id}")
    public ResponseEntity<Boolean> getBool(@PathVariable Integer id) {
        Examination ex=examinationService.findById(id);
        LocalDate date=ex.getDate();
        //log.info("dsds:"+id);
        Boolean res=drugReservationService.possibleCancel(date);

        return res == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(res);
    }
    @CrossOrigin
    @PostMapping("/patientCanceling")
    ResponseEntity<String> update(@RequestBody Examination examination)
    {

        examinationService.patientCanceling(examination);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
}
