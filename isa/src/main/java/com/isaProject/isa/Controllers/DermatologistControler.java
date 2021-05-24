package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DermatologistDTO;
import com.isaProject.isa.Model.DTO.PharmaceutDTO;
import com.isaProject.isa.Model.DTO.WorkTimeDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Services.Implementations.DermatologistService;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.*;
import com.isaProject.isa.Services.Implementations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;
import java.util.*;


@RestController
@CrossOrigin
@RequestMapping(value="/dermatologist")
@Slf4j
public class DermatologistControler {


    @Autowired
    private DermatologistService dermatologistService;

    @Autowired
    private WorkTimeService workTimeService;

    @Autowired
    private PharmacyAdminService pharmacyAdminService;

    @Autowired
    private PharmacistService pharmacistService;

    @Autowired
    private UserService userService;

    @Autowired
    private PharmacyService pharmacyService;

    Set<WorkTime> tajm = new HashSet<WorkTime>();

    Set<Pharmacy> pharmOfDerm = new HashSet<Pharmacy>();


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
    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deleteDermatologist(@PathVariable Integer id) {
        Dermatologist dermatologist = dermatologistService.findById(id);
        String answer = dermatologistService.delete(dermatologist);
        return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);
    }

    @GetMapping(value = "/getDermatologists/{id}")
    public ResponseEntity<List<Dermatologist>> findAll(@PathVariable Integer id) {
        List<Dermatologist> dermatologists=dermatologistService.findAll();
        ArrayList<Dermatologist> newDermatologists = new ArrayList<Dermatologist>();

        for (Dermatologist d:dermatologists){
            for(Pharmacy pharm:d.getPharmacies()){
                if(pharm.getIdPharm().equals(id)){
                    System.out.println("eee"+pharm.getIdPharm());
                    newDermatologists.add(d);
                    System.out.println("eee"+d.getName());
                    System.out.println("eee"+newDermatologists);

                }
            }


        }
        return newDermatologists == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newDermatologists);
    }



    @GetMapping(value = "/findWorkTimeByIdUser/{id}")
    public ResponseEntity<WorkTime> findWorkTimeByIdUser(@PathVariable Integer id) {

        WorkTime d= workTimeService.findByIdUser(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }
    //sutraaaaaaaa

    @GetMapping(value ="create/{name}/{surname}/{email}/{address}/{phoneNumber}/{city}/{country}/{idAdmina}")
    public ResponseEntity<String> addDrug(@PathVariable(value="name") String name,@PathVariable(value="surname") String surname,@PathVariable(value="email") String email,@PathVariable(value="address") String address,@PathVariable(value="phoneNumber") String phoneNumber,@PathVariable(value="city") String city,@PathVariable(value="country") String country,@PathVariable(value="idAdmina") Integer idAdmina) {

        Pharmacist p=null;
        Pharmacy pharm=null;
        Double grade=0.0;

        Set<WorkTime> workTime=null;
        Set<Examination> examinations=null;
        Set<Vacation> vacation=null;


        String password=null;
        PharmacyAdmin admin=pharmacyAdminService.findById(idAdmina);
        String proba="2011/11/11";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        /*
        localhost:8083/dermatologist/create/dsdfdd/sdsadd/asdsdd/aSDdd/ASDFdd/ASDddd/asdefrdddd/503/2017-11-11/11:15:45/12:15:45
         */



        Set<Pharmacy> pharmacies = null;
        Pharmacy pharmacy=admin.getPharmacy();//apoteka u kojoj radi admin i dodati derm





        pharmOfDerm.add(pharmacy);





        DermatologistDTO DTO=new DermatologistDTO(name,surname,email,password,address,phoneNumber,city,country,grade, tajm,examinations,vacation,pharmacy);


        Dermatologist d=dermatologistService.save(DTO);




        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }
}
