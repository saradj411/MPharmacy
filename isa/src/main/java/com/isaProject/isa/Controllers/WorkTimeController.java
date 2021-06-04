package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.FrontPharmacyForExamination;
import com.isaProject.isa.Model.DTO.ParDTO;
import com.isaProject.isa.Model.DTO.PomocniDTO;
import com.isaProject.isa.Model.DTO.WorkTimeDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Model.Users.WorkTime;
import com.isaProject.isa.Services.Implementations.PharmacistService;
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

    @Autowired
    PharmacistService pharmacistService;

    @PostMapping(value = "/findAllByDate")
    public ResponseEntity<List<FrontPharmacyForExamination>> findAll(@RequestBody WorkTimeDTO workTimeDTO) {
        List<Pharmacy> pharmacies=new ArrayList<>();
        List<Pharmacy> pharmacies1=new ArrayList<>();
        //List<Staff> staff=new ArrayList<>();
        List<ParDTO> listPar=new ArrayList<>();
        //System.out.println("eee:"+workTimeDTO.getDate()+"--iii:"+workTimeDTO.getStartTime());

        //List<WorkTime> workTimes=workTimeService.listForPatient(workTimeDTO.getDate(),workTimeDTO.getStartTime());
        List<Staff> staffs=workTimeService.listForPatient(workTimeDTO.getDate(),workTimeDTO.getStartTime());
        for(Staff s:staffs){
            System.out.println("eee:"+s.getId());

            Pharmacist pharmacist=pharmacistService.findById(s.getId());
           Pharmacy pharmacy=pharmacist.getPharmacy();
            ParDTO parDTO=new ParDTO(pharmacy,pharmacist);
            listPar.add(parDTO);

        }
        List<FrontPharmacyForExamination> newList=new ArrayList<>();
/*
        for(WorkTime w:workTimes){
            pharmacies.add(w.getPharmacy());
            staff.add(w.getStaff());
                FrontPharmacyForExamination front=new FrontPharmacyForExamination(w.getPharmacy().getName()
                , w.getPharmacy().getAddress(),w.getPharmacy().getAvgGrade(),555.5,
                        w.getStaff().getId());
                newList.add(front);
            }
            for(Pharmacy p:pharmacies){
                if(!pharmacies1.contains(p)){
                    System.out.println("eee:"+p.getName());
                    pharmacies1.add(p);
                }
            }*/
            for(ParDTO pD:listPar){
                pharmacies.add(pD.getIdPharmacy());
            }
            for(Pharmacy p:pharmacies){
                if(!pharmacies1.contains(p)){

                    pharmacies1.add(p);
                }
            }
            for(Pharmacy p1:pharmacies1){
                FrontPharmacyForExamination front=new FrontPharmacyForExamination(p1.getIdPharm(),p1.getName()
                        , p1.getAddress(),p1.getAvgGrade(),555.5);
                newList.add(front);
            }
            return newList == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newList);
    }

    @PostMapping(value = "/findFreeStaffByPharmacy")
    public ResponseEntity<List<FrontPharmacyForExamination>> findStaff(@RequestBody PomocniDTO pomocniDTO) {
        System.out.println("eee:"+pomocniDTO.getIdPharmacy()+"LLL"+pomocniDTO.getTime()+
                "ksalkja"+pomocniDTO.getDate());
        List<Staff> staffs=workTimeService.listStaffForPatient(pomocniDTO.getDate(),pomocniDTO.getTime());
        List<FrontPharmacyForExamination> newList=new ArrayList<>();

        for(Staff s:staffs){
            FrontPharmacyForExamination front=new FrontPharmacyForExamination(pomocniDTO.getIdPharmacy(),
                    s.getId());
            newList.add(front);
        }
        return newList == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newList);
    }
}
