package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DermatologistDTO;
import com.isaProject.isa.Model.DTO.PharmaceutDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.*;
import com.isaProject.isa.Services.Implementations.DermatologistService;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.PharmacistService;
import com.isaProject.isa.Services.Implementations.PharmacyAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin
@RequestMapping(value="/dermatologist")
@Slf4j
public class DermatologistControler {

    @Autowired
    private DermatologistService dermatologistService;

    @Autowired
    private PharmacyAdminService pharmacyAdminService;

    @Autowired
    private PharmacistService pharmacistService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Dermatologist>> findAll() {
        List<Dermatologist> dermatologists=dermatologistService.findAll();
        for (Dermatologist d:dermatologists){
            System.out.println(d.getIdUser());
            System.out.println(d.getPharmacies());


        }
        return dermatologists == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(dermatologists);
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Dermatologist> findById(@PathVariable Integer id) {

        Dermatologist d= dermatologistService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }

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

        Set<Pharmacy> pharmacies = null;
        Pharmacy pharmacy=admin.getPharmacy();



        DermatologistDTO DTO=new DermatologistDTO(name,surname,email,password,address,phoneNumber,city,country,grade, workTime,examinations,vacation,pharmacies);


        //Dermatologist d = dermatologistService.save(DTO);
        Dermatologist d=dermatologistService.save(DTO);
        System.out.println(d);

        //Pharmacy pp=d.getPharmacy();



        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }
}
