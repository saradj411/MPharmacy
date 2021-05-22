package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Services.Implementations.DrugReservationService;
import com.isaProject.isa.Services.Implementations.DrugService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/reservation")
@Slf4j
public class DrugReservationController {

    @Autowired
    private DrugReservationService drugReservationService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<DrugReservation>> findAll() {
        List<DrugReservation> reservations=this.drugReservationService.findAll();
        return reservations == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(reservations);
    }
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<List<DrugReservation>> findById(@PathVariable Patient id) {
        //log.info("dsds:"+id);
        List<DrugReservation> reserv=drugReservationService.findByIdPatient(id);

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
}
