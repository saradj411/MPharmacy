package com.isaProject.isa.Controllers;


import com.isaProject.isa.Config.Utils.Auth.JwtAuthenticationRequest;
import com.isaProject.isa.Model.DTO.DermatologistDTO;
import com.isaProject.isa.Model.DTO.UserDTO;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Model.Users.UserTokenState;
import com.isaProject.isa.Services.Implementations.DermatologistService;
import com.isaProject.isa.Services.Implementations.PatientService;
import com.isaProject.isa.Services.Implementations.UserService;
import lombok.extern.slf4j.Slf4j;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.scheduling.annotation.Async;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import javax.servlet.http.HttpServletResponse;
import java.time.LocalDate;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/user", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;
    @Autowired
    private PatientService patientService;
    @Autowired
    private DermatologistService dermatologistService;
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
    @Async
    @PreAuthorize("hasRole('ADMIN') or hasRole('PATIENT') or hasRole('SUPPLIER')") //mogu se dodati sve role ovde
    public ResponseEntity<User> findById(@PathVariable Integer id) {

        User user = userService.findById(id);
        return user == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping(value = "/findByEmail/{email}")
    public ResponseEntity<User> findByEmail(@PathVariable String email) {

        User user = userService.findByEmail(email);
        return user == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                new ResponseEntity<>(user, HttpStatus.OK);
    }



    @GetMapping(value = "/updatePenality")
    public ResponseEntity<Boolean> updatePenality(){

        //danasnji datum
        LocalDate now=LocalDate.now();
       //danasnji dan
        int day= now.getDayOfMonth();

        List<Patient> users=patientService.findAll();

        for(Patient u:users) {
            System.out.println(u.getId());
            if (day == 1) {
                u.setPenalty(0);
                patientService.update(u);
            }
        }
        return ResponseEntity.ok(true);
    }

    @PostMapping(value="/savePatient", consumes = "application/json")
    public ResponseEntity<User> savePatient(@RequestBody UserDTO userDTO)
    {
        try
        {
            System.out.println(userDTO.getEmail());
            User u = userService.save(userDTO);
            return  u == null ? new ResponseEntity<>(HttpStatus.IM_USED) :
                    ResponseEntity.ok(u);
        }catch (Exception e)
        {
            e.printStackTrace();
        }

        return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<UserTokenState> login(@NotNull @RequestBody JwtAuthenticationRequest authRequest,
                                                HttpServletResponse response)
    {
        System.out.println("USAO");
        System.out.println(authRequest.getUsername());
        UserTokenState token = userService.Login(authRequest.getUsername(), authRequest.getPassword());
        return token == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(token);
    }


    /*@PostMapping(value = "/saveSupplier", consumes = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<User> saveDermatologist(@RequestBody SupplierDTO dermDTO)
    {
        System.out.println("USAO U SAVE DERMATOLOGA SA ADMIN ROLE");
        System.out.println(dermDTO.getEmail());
        User u = dermatologistService.save(dermDTO);
        return  u == null ? new ResponseEntity<>(HttpStatus.IM_USED) :
                new ResponseEntity<>(u, HttpStatus.CREATED);
    }*/

    @GetMapping(value = "/loggedUser")
    public ResponseEntity<User> getLoggedUser()
    {
        System.out.println("Nasao logovanog usera?");

        User u = userService.getLoggedUser();
        return  u == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(u, HttpStatus.OK);
    }

    @PostMapping(value =  "/saveAdmin")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<User> saveAdmin(@RequestBody UserDTO userDTO) throws MessagingException {
        User u = userService.saveAdmin(userDTO);

        return u == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST) :
                new ResponseEntity<>(u, HttpStatus.CREATED);

    }

    @PostMapping(value =  "/updateUser")
    @PreAuthorize("hasRole('SUPPLIER') or hasRole('PATIENT') or hasROLE('ADMIN')")
    public ResponseEntity<User> update(@RequestBody User user) throws MessagingException {
        userService.update(user);
        return new ResponseEntity<>(HttpStatus.OK);

    }
}
