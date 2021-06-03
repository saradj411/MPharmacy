package com.isaProject.isa.Controllers;


import com.isaProject.isa.Model.DTO.SearchPharmacistsDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Services.Implementations.DermatologistService;
import com.isaProject.isa.Services.Implementations.DrugPricelistService;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.PharmacistService;
import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.PharmaceutDTO;
import com.isaProject.isa.Model.DTO.WorkTimeDTO;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.*;
import com.isaProject.isa.Services.Implementations.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.nio.file.FileSystemNotFoundException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalTime;

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
    @Autowired
    private WorkTimeService workTimeService;

    @Autowired
    private  StaffService staffService;

    Set<WorkTime> tajm = new HashSet<WorkTime>();



    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Pharmacist>> findAll() {
        List<Pharmacist> pharmacists=pharmacistService.findAll();
        for (Pharmacist d:pharmacists){
            System.out.println(d.getId());
            d.getPharmacy();


        }
        return pharmacists == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacists);
    }
    @GetMapping(value = "/getPharmacist/{id}")
    public ResponseEntity<List<Pharmacist>> findAll(@PathVariable Integer id) {
        List<Pharmacist> pharmacists=pharmacistService.findAll();
        ArrayList<Pharmacist> newP = new ArrayList<>();

        for (Pharmacist d:pharmacists){
            if(d.getPharmacy().getIdPharm().equals(id)){
                System.out.println("eee"+d.getPharmacy().getIdPharm());

                newP.add(d);
            }
        }
        return newP == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newP);
    }

    @PostMapping("/searchPharmacistName/{id}")
    public ResponseEntity<List<Pharmacist>> findAllP(@PathVariable Integer id, @RequestBody SearchPharmacistsDTO dto) {
        List<Pharmacist> pharmacists=pharmacistService.findAll();
        System.out.println("ime sa fronta je "+dto.getName());
        System.out.println("prezime sa fronta je "+dto.getSurame());

        ArrayList<Pharmacist> newP = new ArrayList<>();

        for (Pharmacist d:pharmacists){
            if(d.getPharmacy().getIdPharm().equals(id)){
                if(d.getSurname().toLowerCase().contains(dto.getSurame().toLowerCase()) && d.getName().toLowerCase().contains(dto.getName().toLowerCase())){
                    newP.add(d);
                }

            }
        }
        return newP == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newP);
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
/*

    @GetMapping(value ="create/{name}/{surname}/{email}/{address}/{phoneNumber}/{city}/{country}/{idAdmina}/{date}/{start}/{end}")
    public ResponseEntity<String> addDrug(@PathVariable(value="name") String name,@PathVariable(value="surname") String surname,@PathVariable(value="email") String email,@PathVariable(value="address") String address,@PathVariable(value="phoneNumber") String phoneNumber,@PathVariable(value="city") String city,@PathVariable(value="country") String country,@PathVariable(value="idAdmina") Integer idAdmina,@PathVariable(value="start") String start,@PathVariable(value="end") String end) {
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
        System.out.println(admin.getId()+"id adminaaaaaaaaaaaaa");
        //nece da doda id u pharmacy ps. hoceee :D
        Pharmacy pharmacy=admin.getPharmacy();





        //Pharmacy pp=d.getPharmacy();


        PharmacyAdmin adminn=pharmacyAdminService.findById(idAdmina);
        String proba="2011/11/11";
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        */
/*
        localhost:8083/dermatologist/create/dsdfdd/sdsadd/asdsdd/aSDdd/ASDFdd/ASDddd/asdefrdddd/503/2017-11-11/11:15:45/12:15:45
         *//*



        Date apptDay = null;
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        java.sql.Date sqlDate;
        System.out.println("\nPlease enter the date of the appointment, format: yyyy/mm/dd");

        try
        {
            // input = in.next();
            apptDay = (Date)df.parse(proba);
        }
        catch(ParseException e)
        {
            System.out.println("Please enter a valid date! Format is yyyy/mm/dd");
        }

        sqlDate = new java.sql.Date(apptDay.getTime());
        Date jDate =  new Date(sqlDate.getTime());





        LocalTime startt= LocalTime.parse(start);
        LocalTime endd= LocalTime.parse(end);

        Pharmacy pharmacyy=admin.getPharmacy();//apoteka u kojoj radi admin i dodati derm




        User u=userService.findById(idAdmina);
        Staff staff=new Staff(u.getId(),u.getName(),u.getSurname(),u.getEmail(), u.getPassword(),u.getAddress(),u.getPhoneNumber(),u.getCity(),u.getCountry(),0.0,null,null,null);
        //idUser, name, surname, email, password, address, phoneNumber, city, country
        WorkTimeDTO workTimeDTO=new WorkTimeDTO(jDate,startt,endd,staff,pharmacy);
        WorkTime ww=workTimeService.save(workTimeDTO);

        tajm.add(ww);

        PharmaceutDTO DTO=new PharmaceutDTO(name,surname,email,password,address,phoneNumber,city,country,pharmacy,grade,tajm,examinations,vacation);


        Pharmacist d = pharmacistService.save(DTO);




        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }
*/






    @PostMapping("/updatePharmacist")
    ResponseEntity<String> update(@RequestBody Pharmacist pharmacist)
    {
        pharmacistService.update(pharmacist);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }




   /* @GetMapping(value ="createWorkTime/{idPharmaceut}/{date}/{start}/{end}")//mora se id proslijediti nekako ili mozda email
    public ResponseEntity<String> addWorkTime(@PathVariable(value="idPharmaceut") Integer idPharmaceut,@PathVariable(value="start") String start,@PathVariable(value="end") String end) {

        Pharmacist pharmacist=pharmacistService.findById(idPharmaceut);//moze i findbyemail

        Pharmacy pharmacy=pharmacist.getPharmacy();
        String proba="2011/11/11";//mora biti u ovom obliku ako nije parsirati
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");




        Date apptDay = null;
        DateFormat df = new SimpleDateFormat("yyyy/MM/dd");
        java.sql.Date sqlDate;
        System.out.println("\nPlease enter the date of the appointment, format: yyyy/mm/dd");

        try
        {
            // input = in.next();
            apptDay = (Date)df.parse(proba);
        }
        catch(ParseException e)
        {
            System.out.println("Please enter a valid date! Format is yyyy/mm/dd");
        }

        sqlDate = new java.sql.Date(apptDay.getTime());
        Date jDate =  new Date(sqlDate.getTime());





        LocalTime startt= LocalTime.parse(start);
        LocalTime endd= LocalTime.parse(end);
        Staff staff= staffService.findById(pharmacist.getId());





        //idUser, name, surname, email, password, address, phoneNumber, city, country
        WorkTimeDTO workTimeDTO=new WorkTimeDTO(jDate,startt,endd,staff,pharmacy);
        WorkTime ww=workTimeService.save(workTimeDTO);









        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }
*/

    @GetMapping("/delete/{id}")
    public ResponseEntity<String> deletePharmacist(@PathVariable Integer id) {
        Pharmacist pharmacist = pharmacistService.findById(id);
        String answer = pharmacistService.delete(pharmacist);
        return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);
    }



}
