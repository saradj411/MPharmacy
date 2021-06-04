package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.FrontPharmacyForExamination;
import com.isaProject.isa.Model.DTO.WorkTimeDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.WorkTime;
import com.isaProject.isa.Services.Implementations.WorkTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.parameters.P;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/workTime")
@Slf4j
public class WorkTimeController {

    @Autowired
    WorkTimeService workTimeService;

    @PostMapping(value = "/findAllByDate")
    public ResponseEntity<List<FrontPharmacyForExamination>> findAll(@RequestBody WorkTimeDTO workTimeDTO)
                                  {
        System.out.println("eee:"+workTimeDTO.getDate()+"--iii:"+workTimeDTO.getStartTime());
        List<WorkTime> workTimes=workTimeService.listForPatient(workTimeDTO.getDate(),workTimeDTO.getStartTime());
            List<FrontPharmacyForExamination> newList=new ArrayList<>();
        for(WorkTime w:workTimes){
                FrontPharmacyForExamination front=new FrontPharmacyForExamination(w.getPharmacy().getName()
                , w.getPharmacy().getAddress(),w.getPharmacy().getAvgGrade(),555.5,
                        w.getStaff().getId());
                newList.add(front);
            }

            return newList == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newList);
    }
}
