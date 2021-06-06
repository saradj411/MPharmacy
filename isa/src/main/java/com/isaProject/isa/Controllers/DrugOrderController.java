package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DrugOrderDTO;
import com.isaProject.isa.Model.DTO.DrugOrderFrontDTO;
import com.isaProject.isa.Model.DTO.OrderItemDTO;
import com.isaProject.isa.Model.DTO.PatientDTO;
import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.OrderItem;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Repositories.OrderItemRepository;
import com.isaProject.isa.Services.Implementations.DrugOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@RestController
@Component
@CrossOrigin
@RequestMapping(value="/drugOrder")
@Slf4j
public class DrugOrderController {


    @Autowired
    DrugOrderService drugOrderService;
    @Autowired
    OrderItemRepository orderItemRepository;


    @PostMapping("/create")
    public ResponseEntity<String> create(@RequestBody DrugOrderDTO drugOrderDTO)
    {
        //provjeraa
        System.out.println("Datum je "+drugOrderDTO.getTimeLimit());
        System.out.println("admin je "+drugOrderDTO.getId());
        System.out.println("ceka ponude je "+drugOrderDTO.getProcessed());

        for(OrderItemDTO o:drugOrderDTO.getOrderItemDTO()){//posaljem set order item
            System.out.println(o.getDrug().getName());
            System.out.println(o.getQuantity());
        }
        DrugOrder order = drugOrderService.save(drugOrderDTO);
        return new ResponseEntity<>("created", HttpStatus.CREATED);
    }

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<DrugOrderFrontDTO>> findAll() {
        List<DrugOrder> drugOrders=drugOrderService.findAll();
        ArrayList<DrugOrderFrontDTO> lista=new ArrayList<>();
        for (DrugOrder p:drugOrders){
           // if(p.getProcessed().equals(false)){
                DrugOrderFrontDTO pDTO = new DrugOrderFrontDTO(p.getIdOrder(), p.getTimeLimit());
                lista.add(pDTO);
           // }
        }

        return lista == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(lista);
    }


    @GetMapping(value = "/findAllByAdmin/{id}")//vrati narudjbenice koje je admin definisao
    public ResponseEntity<List<DrugOrderFrontDTO>> findAll(@PathVariable Integer id) {
        List<DrugOrder> drugOrders=drugOrderService.findAll();
        ArrayList<DrugOrderFrontDTO> lista=new ArrayList<>();
        for (DrugOrder p:drugOrders){
            if(p.getPharmacyAdmin().getId().equals(id) && p.getProcessed().equals(false)){
                DrugOrderFrontDTO pDTO=new DrugOrderFrontDTO(p.getIdOrder(),p.getTimeLimit());
                lista.add(pDTO);
            }
        }
        return lista == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(lista);
    }



    @GetMapping(value = "/findOrderItem/{idOrder}")
    public ResponseEntity<List<OrderItemDTO>> findAllItem(@PathVariable Integer idOrder) {
        List<OrderItem> orderItems=drugOrderService.getOrderByIdOffer(idOrder);//nadje
        ArrayList<OrderItemDTO> lista=new ArrayList<>();

        for (OrderItem p:orderItems){
            OrderItemDTO pDTO=new OrderItemDTO(p.getQuantity(),p.getDrug());
            lista.add(pDTO);
        }
        return lista == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(lista);
    }



}
