package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.DTO.ExaminationFrontDTO;
import com.isaProject.isa.Model.DTO.RequestForVacationDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Examination.Examination;

import com.isaProject.isa.Services.Implementations.DrugReservationService;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;

import com.isaProject.isa.Services.Implementations.ExaminationService;
import com.isaProject.isa.Services.Implementations.PatientService;
import com.isaProject.isa.Services.Implementations.PharmacyDrugsService;
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

    @Autowired
    PatientService patientService;
    @Autowired
    PharmacyDrugsService pharmacyDrugsService;


    @GetMapping(value = "/shedule/{id}/{name}")
    public ResponseEntity<Boolean> findAllergy(@PathVariable (value = "id") Integer id,@PathVariable (value = "name") String name) {
        Boolean b=false;
        /*if(pharmacyDrugsService.check(id,name).equals("The drug is not available at the pharmacy")){
            b=false;
        }*/
        if(patientService.findAllergy(id,name).equals("The patient is allergic to the drug")){
            b=false;
        }
        return new ResponseEntity<>(b, HttpStatus.ACCEPTED);

    }

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


    @PostMapping("/createDermatologistEx")
    public ResponseEntity<String> addDrug(@RequestBody ExaminationDTO examinationDTO) throws MessagingException {
        Examination examination = examinationService.createExD(examinationDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }
    @PostMapping("/createPharmacistEx")
    public ResponseEntity<String> createExamination(@RequestBody ExaminationDTO examinationDTO) throws MessagingException {
        Examination examination = examinationService.createExP(examinationDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }

    @PostMapping("/createDermatologist")
    public ResponseEntity<String> create(@RequestBody ExaminationDTO examinationDTO) throws MessagingException {
        Examination examination = examinationService.save(examinationDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }

    @PostMapping("/createPharmacists")
    public ResponseEntity<String> createP(@RequestBody ExaminationDTO examinationDTO) throws MessagingException {
        Examination examination = examinationService.saveP(examinationDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }


    @PostMapping("/finished/{id}")
    public ResponseEntity<String> finished(@RequestBody ExaminationFrontDTO examinationFrontDTO,@PathVariable Integer id) {

        Examination examination = examinationService.finishExD(examinationFrontDTO,id);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }

    @PostMapping("/finishedPharmacist/{id}")
    public ResponseEntity<String> finishedPharmacist(@RequestBody ExaminationFrontDTO examinationFrontDTO,@PathVariable Integer id) {

        Examination examination = examinationService.finishExP(examinationFrontDTO,id);
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
    ResponseEntity<String> scheduledDermatologistExamination(@PathVariable Integer id,@PathVariable Integer idExamination)
    {

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
    @PostMapping("/patientCanceling/{id}")
    ResponseEntity<String> cancelingA(@PathVariable Integer id)
    {
        System.out.println("KONTROLEEEEER");

        examinationService.patientCanceling(id);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
}
