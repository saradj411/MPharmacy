package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Services.Implementations.PatientService;
import com.isaProject.isa.Services.Implementations.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/user")
@Slf4j


public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<User>> findAll() {
        List<User> user=userService.findAll();
        return user == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(user);
    }

    

    @GetMapping(value = "/findAllDermatologist")
    public ResponseEntity<List<User>> findAllDermatologist() {
        List<User> user=userService.findAll();

        return user == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(user);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<User> findById(@PathVariable Integer id) {
        //log.info("dsds:"+id);


        User pharm=userService.findById(id);
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }
    @GetMapping(value = "/updatePenality")
    public ResponseEntity<Boolean> updatePenality(){

        //danasnji datum
        LocalDate now=LocalDate.now();
       //danasnji dan
        int day= now.getDayOfMonth();

        List<Patient> users=patientService.findAll();

        for(Patient u:users) {
            System.out.println(u.getIdUser());
            if (day == 1) {
                u.setPenalty(0);
                patientService.update(u);
            }
        }
        return ResponseEntity.ok(true);
    }
}
