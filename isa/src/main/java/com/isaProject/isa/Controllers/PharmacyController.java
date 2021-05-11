package com.isaProject.isa.Controllers;

import com.isaProject.isa.Services.Implementations.PharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/pharmacy")
public class PharmacyController {

    @Autowired
    PharmacyService pharmacyService;

}
