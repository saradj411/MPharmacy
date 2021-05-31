package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DrugOrderDTO;
import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Services.Implementations.DrugOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@Component
@CrossOrigin
@RequestMapping(value="/drugOrder")
@Slf4j
public class DrugOrderController {


    @Autowired
    DrugOrderService drugOrderService;
    /*

    @PostMapping("/create")
    ResponseEntity<String> create(@RequestBody DrugOrderDTO drugOrderDTO)
    {
        if(drugOrderDTO.getTimeLimit() ==null){
            throw new IllegalArgumentException("Expiry date has to be defined.");
        }
     /*
        if(!(drugOrderDTO.getTimeLimit().toString().matches("\\d{4}-\\d{2}-\\d{2}"))) {
            throw new IllegalArgumentException("Date has to be in format YYYY-MM-DD.");
        }
*/
    /*
        DrugOrder order = drugOrderService.createDrugOrder(drugOrderDTO);
        if(order != null) {
            return new ResponseEntity<>("Order is successfully published!", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Please try later.", HttpStatus.CREATED);
        }

        // return null;
    }

     */
}
