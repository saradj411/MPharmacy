package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DrugOrderDTO;
import com.isaProject.isa.Model.DTO.OrderItemDTO;
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

    @PostMapping("/create")
    ResponseEntity<String> create(@RequestBody DrugOrderDTO drugOrderDTO)
    {
        System.out.println("Datum je "+drugOrderDTO.getTimeLimit());
        /*System.out.println("admin je "+drugOrderDTO.getPharmacyAdmin().getName());
        System.out.println("id admina je "+drugOrderDTO.getPharmacyAdmin().getIdUser());
*/
        for(OrderItemDTO o:drugOrderDTO.getOrderItemDTO()){
            System.out.println(o.getDrug().getName());
            System.out.println(o.getQuantity());

        }

        DrugOrder order = drugOrderService.save(drugOrderDTO);
        if(order != null) {
            return new ResponseEntity<>("Order is successfully published!", HttpStatus.CREATED);
        }else {
            return new ResponseEntity<>("Please try later.", HttpStatus.CREATED);
        }
    }
}
