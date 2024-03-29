package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.DrugReservationDTO;
import com.isaProject.isa.Model.DTO.DrugReservationForViewDTO;
import com.isaProject.isa.Model.DTO.FrontDrugReservationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Services.Implementations.DrugReservationService;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.PatientService;
import com.isaProject.isa.Services.Implementations.ServiceForEmail;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/reservation")
@Slf4j
public class DrugReservationController {

    @Autowired
    private DrugReservationService drugReservationService;

    @Autowired
    private PatientService patientService;

    @Autowired
    ServiceForEmail serviceForEmail;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<DrugReservation>> findAll() {
        List<DrugReservation> reservations=this.drugReservationService.findAll();
        return reservations == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reservations);
    }

    //AKTIVNE REZERVACIJE
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<List<FrontDrugReservationDTO>> findById(@PathVariable Patient id) {

        List<FrontDrugReservationDTO> reserv=drugReservationService.findActualByIdPatient(id);

        return reserv == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reserv);
    }

    @GetMapping(value = "/getBool/{id}")
    public ResponseEntity<Boolean> getBool(@PathVariable Integer id) {
        DrugReservation res=drugReservationService.findById(id);
        LocalDate date=res.getPickUpDate();
        //log.info("dsds:"+id);
        Boolean reserv=drugReservationService.possibleCancel(date);

        return reserv == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reserv);
    }

    @GetMapping(value = "/findPickedById/{id}")
    public ResponseEntity<List<FrontDrugReservationDTO>> findPickedById(@PathVariable Patient id) {

        List<FrontDrugReservationDTO> reserv=drugReservationService.findPickedById(id);

        return reserv == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reserv);
    }
    @GetMapping(value = "/findCanceledById/{id}")
    public ResponseEntity<List<FrontDrugReservationDTO>> findCanceledById(@PathVariable Patient id) {

        List<FrontDrugReservationDTO> reserv=drugReservationService.findCanceledById(id);

        return reserv == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reserv);
    }
    @GetMapping(value = "/findAllPicked")
    public ResponseEntity<List<DrugReservation>> findAllPicked() {
        List<DrugReservation> reservations=this.drugReservationService.findByIsPickedUp(true);

        return reservations == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reservations);
    }

    @PostMapping("/canceling/{id}")
    ResponseEntity<String> update(@PathVariable Integer id)
    {

        drugReservationService.canceling(id);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
    @PostMapping("/checkReservations")
    ResponseEntity<String> checkReservations()
    {

        drugReservationService.checkReservations();
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

    @PostMapping("/create")
    public ResponseEntity<DrugReservation> createReservation(@RequestBody DrugReservationDTO drugDTO) throws MessagingException {

        DrugReservation drug = drugReservationService.save(drugDTO);
        //serviceForEmail.sendingMailToPatientForReservattion(drug.getIdReservation(),drug.getPatient());
        return new ResponseEntity<>(drug, HttpStatus.CREATED);
    }

    @GetMapping(value = "/res/{id}")
    public ResponseEntity<String> res(@PathVariable Integer id) throws MessagingException {

        String reserv=drugReservationService.reservation(id);

        return reserv == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reserv);
    }


    @GetMapping(value = "/res2/{id}/{name}")
    public ResponseEntity<List<DrugReservationForViewDTO>> res2(@PathVariable Integer id,@PathVariable String name) throws MessagingException {

        List<DrugReservationForViewDTO> reserv=drugReservationService.listDr(id);
        List<DrugReservationForViewDTO>drugs=new ArrayList<>();
        for (DrugReservationForViewDTO d:reserv){
            if(d.getDrugName().equals(name)){
                drugs.add(d);
            }
        }

        return drugs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reserv);
    }

}
