package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Services.Implementations.DrugReservationService;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.PatientService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/reservation")
@Slf4j
public class DrugReservationController {

    @Autowired
    private DrugReservationService drugReservationService;

    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<DrugReservation>> findAll() {
        List<DrugReservation> reservations=this.drugReservationService.findAll();
        return reservations == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reservations);
    }

    //AKTIVNE REZERVACIJE
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<List<DrugReservation>> findById(@PathVariable Patient id) {
        //log.info("dsds:"+id);
        List<DrugReservation> reserv=drugReservationService.findByIdPatient(id);
        List<DrugReservation> reserv1=new ArrayList<>();
        LocalDate now=LocalDate.now();

        for (DrugReservation dR:reserv){
            LocalDate pick=dR.getPickUpDate();
            int rez=now.compareTo(pick);
            System.out.println(rez);
            if(rez<0) {
                System.out.println("uslo");
                if (!dR.getCancelled()) {
                    if(!dR.getPickedUp()) {
                        reserv1.add(dR);
                        //id.setPenalty(id.getPenalty() + 1);
                        //patientService.update(id);
                    }
                }
            }

        }
        return reserv1 == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reserv1);
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
    public ResponseEntity<List<DrugReservation>> findPickedById(@PathVariable Patient id) {
        //log.info("dsds:"+id);
        List<DrugReservation> reserv=drugReservationService.findByIdPatient(id);
        List<DrugReservation> reserv1=new ArrayList<>();
        for (DrugReservation dR:reserv){
            if(dR.getPickedUp()){
                reserv1.add(dR);
            }
        }
        return reserv1 == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reserv1);
    }
    @GetMapping(value = "/findCanceledById/{id}")
    public ResponseEntity<List<DrugReservation>> findCanceledById(@PathVariable Patient id) {
        //log.info("dsds:"+id);
        List<DrugReservation> reserv=drugReservationService.findByIdPatient(id);
        List<DrugReservation> reserv1=new ArrayList<>();
        for (DrugReservation dR:reserv){
            if(dR.getCancelled()){
                reserv1.add(dR);
            }
        }
        return reserv1 == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reserv1);
    }
    @GetMapping(value = "/findAllPicked")
    public ResponseEntity<List<DrugReservation>> findAllPicked() {
        List<DrugReservation> reservations=this.drugReservationService.findByIsPickedUp(true);
        return reservations == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reservations);
    }

    @PostMapping("/canceling")
    ResponseEntity<String> update(@RequestBody DrugReservation dR)
    {

        drugReservationService.canceling(dR);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }
}
