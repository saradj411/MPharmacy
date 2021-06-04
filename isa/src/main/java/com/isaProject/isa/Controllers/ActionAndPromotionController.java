package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.ActionAndPromotionDTO;
import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Users.ActionAndPromotion;
import com.isaProject.isa.Services.Implementations.ActionAndPromotionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;

@RestController
@CrossOrigin
@RequestMapping(value="/actionAndPromotion")
@Slf4j
public class ActionAndPromotionController {

    @Autowired
    ActionAndPromotionService actionAndPromotionService;



    @PostMapping("/create")
    public ResponseEntity<String> addDrug(@RequestBody ActionAndPromotionDTO actionAndPromotionDTO) throws MessagingException {

        ActionAndPromotion actionAndPromotion = actionAndPromotionService.save(actionAndPromotionDTO);
        actionAndPromotionService.sendMail(actionAndPromotion);
        //posalji mejl
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }

}
