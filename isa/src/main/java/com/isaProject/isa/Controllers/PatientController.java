package com.isaProject.isa.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Model.DTO.*;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.PatientService;
import com.isaProject.isa.Services.Implementations.PharmacyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/patient")
@Slf4j
//@JsonIgnoreProperties(ignoreUnknown = true)
public class PatientController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DrugService drugService;

    @Autowired
    private PharmacyService pharmacyService;

    /*@GetMapping(value = "/findAllergyById/{id}")
    public ResponseEntity<Set<Drug>> findAllergyById(@PathVariable Integer id) {

        Set<Drug> d= patientService.findAllergy(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }*/
    @GetMapping(value = "/findAllergyById/{id}/{name}")
    public ResponseEntity<String> findAllergy(@PathVariable (value = "id") Integer id,@PathVariable (value = "name") String name) {
        String answer=patientService.findAllergy(id,name);
        return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);

    }


    @GetMapping(value = "/checkAllergy/{id}/{name}")
    public ResponseEntity<Boolean> checkAllergy(@PathVariable (value = "id") Integer id,@PathVariable (value = "name") String name) {
        String answer=patientService.findAllergy(id,name);
        Boolean check=false;
        if(answer.equals("The patient isn't allergic to the drug")){
            check=false;
        }else {
            check = true;//pacijent je alergican
        }
        return new ResponseEntity<>(check, HttpStatus.ACCEPTED);
    }
/*

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Patient> findById(@PathVariable Integer id) {}
*/

    @GetMapping(value = "/findOneById/{id}")
    @Async
    public ResponseEntity<Patient> findById(@PathVariable Integer id) {
        System.out.println("PatientController"+id);
        Patient d= patientService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }

    @GetMapping("/addAllergy/{id}/{idPatient}")
    public ResponseEntity<String> addDrug(@PathVariable(value = "id") Integer id,
                                          @PathVariable(value = "idPatient") Integer idPatient ) {

        patientService.saveAllergy(id,idPatient);
        return new ResponseEntity<>("Allergy is added", HttpStatus.CREATED);
    }

    @PostMapping("/updatePatient")
    ResponseEntity<String> update(@RequestBody Patient patient)
    {

        patientService.update(patient);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
    @GetMapping(value = "/findActionPharmacy/{id}")
    public ResponseEntity<Set<Pharmacy>> findActionPharmacy(@PathVariable Integer id) {

        Patient d= patientService.findById(id);
        Set<Pharmacy> pharmacies=new HashSet<>();
        pharmacies=d.getActionPharmacies();
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacies);
    }

    @GetMapping(value = "/findSheduledDermatologistExamination/{id}")
    public ResponseEntity<Set<FrontCreatedExaminationDTO>> findSheduledDermatologistExamination(@PathVariable Integer id) {

        Set<FrontCreatedExaminationDTO> d= patientService.findSheduledDermatologistExamination(id);

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    @GetMapping(value = "/findSheduledPharmacistExamination/{id}")
    public ResponseEntity<Set<FrontCreatedExaminationDTO>> findSheduledPharmacistExamination(@PathVariable Integer id) {

        Set<FrontCreatedExaminationDTO> d= patientService.findSheduledPharmacistExamination(id);

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    @GetMapping(value = "/findFinishedDermatologistExamination/{id}")
    public ResponseEntity<Set<FrontCreatedExaminationDTO>> findFinishedDermatologistExamination(@PathVariable Integer id) {

        Set<FrontCreatedExaminationDTO> d= patientService.findFinishedDermatologistExamination(id);

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }

    @GetMapping(value = "/findDermatologistForGrade/{id}")
    public ResponseEntity<Set<Integer>> findDermatologistForGrade(@PathVariable Integer id) {

        Set<Integer> d= patientService.findDermatologistForGrade(id);

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }

    @GetMapping(value = "/findFinishedPharmacistExamination/{id}")
    public ResponseEntity<Set<FrontCreatedExaminationDTO>> findFinishedPharmacistExamination(@PathVariable Integer id) {

        Set<FrontCreatedExaminationDTO> d= patientService.findFinishedPharmacistExamination(id);

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }


    @GetMapping(value = "/findAll")
    public ResponseEntity<List<PatientDTO>> findAll() {
        ArrayList<PatientDTO> lista=new ArrayList<>();
        List<Patient> d= patientService.findAll();
        for (Patient p:d){
            PatientDTO pDTO=new PatientDTO(p.getId(),p.getEmail(),p.getName(),p.getSurname(),p.getPhoneNumber());

            lista.add(pDTO);

        }

        return lista == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(lista);
    }
    @PostMapping("/searchUser")
    public ResponseEntity<List<Patient>> findAllP(@RequestBody SearchUserDTO dto) {
        List<Patient> lista=patientService.findAll();
        System.out.println("ime sa fronta je "+dto.getName());
        System.out.println("prezime sa fronta je "+dto.getSurame());
        ArrayList<Patient> newP = new ArrayList<>();
        for (Patient d:lista){
                if(d.getSurname().toLowerCase().contains(dto.getSurame().toLowerCase()) && d.getName().toLowerCase().contains(dto.getName().toLowerCase())){
                    newP.add(d);
                }
        }
        return newP == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newP);
    }
}
