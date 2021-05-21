package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.PharmaceutDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.*;
import com.isaProject.isa.Services.Implementations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.nio.file.FileSystemNotFoundException;
import java.util.List;
import java.util.Set;

@RestController
@CrossOrigin
@RequestMapping(value="/pharmacist")
@Slf4j
public class PharmacistController {

    @Autowired
    private PharmacistService pharmacistService;
    @Autowired
    private UserService userService;
    @Autowired
    private PharmacyService pharmacyService;
    @Autowired
    private PharmacyAdminService pharmacyAdminService;


    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Pharmacist>> findAll() {
        List<Pharmacist> pharmacists=pharmacistService.findAll();
        for (Pharmacist d:pharmacists){
            System.out.println(d.getIdUser());
            d.getPharmacy();


        }
        return pharmacists == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacists);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Pharmacist> findById(@PathVariable Integer id) {

        Pharmacist d= pharmacistService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
/*
    @GetMapping(value = "/create/{name}/{surname}/{email}/{password}/{address}/{phoneNumber}/{city}/{country}/{pharmacy}/{avgGrade}/{workTime}/{examination}/{vacation})
    public ResponseEntity<String> addDrug(@PathVariable(value="name") String name,String surname,String email, String password, String address, String phoneNumber, String city, String country,Pharmacy pharmacy,double avgGrade,Set<WorkTime> workTime,Set<Examination> examinations,Set<Vacation> vacation) {

        //Drug drug = drugService.save(drugDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
        //return null;
    }


 */

    @GetMapping(value ="create/{name}/{surname}/{email}/{address}/{phoneNumber}/{city}/{country}/{idAdmina}")
    public ResponseEntity<String> addDrug(@PathVariable(value="name") String name,@PathVariable(value="surname") String surname,@PathVariable(value="email") String email,@PathVariable(value="address") String address,@PathVariable(value="phoneNumber") String phoneNumber,@PathVariable(value="city") String city,@PathVariable(value="country") String country,@PathVariable(value="idAdmina") Integer idAdmina) {
        Pharmacist p=null;
        Pharmacy pharm=null;
        Double grade=0.0;
        String password=null;
        Set<WorkTime> workTime=null;
        Set<Examination> examinations=null;
        Set<Vacation> vacation=null;
        //Pharmacy pharmacy=pharmacyService.findById(idAdmina);
        System.out.println("id adminaaaaaaaaaaaaa");
        PharmacyAdmin admin=pharmacyAdminService.findById(idAdmina);
        System.out.println(admin.getIdUser()+"id adminaaaaaaaaaaaaa");
        //nece da doda id u pharmacy ps. hoceee :D
        Pharmacy pharmacy=admin.getPharmacy();



        PharmaceutDTO DTO=new PharmaceutDTO(name,surname,email,password,address,phoneNumber,city,country,pharmacy,grade,workTime,examinations,vacation);


        Pharmacist d = pharmacistService.save(DTO);
        System.out.println(d);

        //Pharmacy pp=d.getPharmacy();



        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }
}
