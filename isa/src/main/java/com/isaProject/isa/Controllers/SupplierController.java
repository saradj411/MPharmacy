package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DermatologistDTO;
import com.isaProject.isa.Model.DTO.SupplierDTO;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Supplier;
import com.isaProject.isa.Repositories.SupplierRepository;
import com.isaProject.isa.Services.Implementations.AuthorityService;
import com.isaProject.isa.Services.Implementations.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@CrossOrigin
@RequestMapping(value = "/supplier")
public class SupplierController {

    @Autowired
    SupplierService supplierService;
    @Autowired
    AuthorityService authorityService;


    @PostMapping(value = "/saveSupplier",  produces = MediaType.APPLICATION_JSON_VALUE)
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Supplier> saveSupplier(@RequestBody SupplierDTO supplierDTO)
    {
        System.out.println("Usao " + supplierDTO.getName());
        Supplier supplier = supplierService.save(supplierDTO);

        return supplier == null ? new ResponseEntity<>(supplier, HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(supplier, HttpStatus.CREATED);
    }

}
