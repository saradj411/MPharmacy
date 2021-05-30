package com.isaProject.isa.Controllers;


import com.isaProject.isa.Config.Utils.Auth.JwtAuthenticationRequest;
import com.isaProject.isa.Model.DTO.UserDTO;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Model.Users.UserTokenState;
import com.isaProject.isa.Services.Implementations.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/user")
@Slf4j
public class UserController {
    @Autowired
    private UserService userService;

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

    @PostMapping(value="/savePatient")
    public ResponseEntity<User> savePatient(@RequestBody UserDTO userDTO)
    {
        System.out.println(userDTO.getEmail());
        User u = userService.save(userDTO);
        return  u == null ? new ResponseEntity<>(HttpStatus.IM_USED) :
                ResponseEntity.ok(u);
    }

    @PostMapping("/login")
    public ResponseEntity<UserTokenState> login(@RequestBody JwtAuthenticationRequest authRequest,
                                                HttpServletResponse response)
    {
        System.out.println("USAO");
        UserTokenState token = userService.Login(authRequest.getUsername(), authRequest.getPassword());
        return token == null ? new ResponseEntity<>(HttpStatus.NOT_FOUND) : ResponseEntity.ok(token);
    }


}
