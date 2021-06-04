package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Repositories.PharmacyDrugsRepository;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.PatientService;
import com.isaProject.isa.Services.Implementations.PharmacyDrugsService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

import java.util.HashSet;
import java.util.List;
import java.util.Set;


@RestController
@CrossOrigin
@RequestMapping(value="/pharmacyDrugs")
@Slf4j
public class PharmacyDrugsController {


    @Autowired
    private PharmacyDrugsService pharmacyDrugsService;
    @Autowired
    private PharmacyDrugsRepository pharmacyDrugsRepository;
    @Autowired
    private PatientService patientService;

    @GetMapping("/delete/{idDrug}/{idPharm}")
    public ResponseEntity<Boolean> deleteDermatologist(@PathVariable Integer idDrug, @PathVariable Integer idPharm ) {

       // Drug drug = pharmacyDrugsService.findById(idPharm,idDrug);
        Boolean answer = pharmacyDrugsService.remove(idPharm,idDrug);

        return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<PharmacyDrugs>> getAll() {
        List<PharmacyDrugs> drugs=pharmacyDrugsService.findAll();
        List<PharmacyDrugs> newList=new ArrayList<>();
        for(PharmacyDrugs pD:drugs){
            if(pD.getQuantity()>0){
                newList.add(pD);
            }
        }
        return newList == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newList);
    }

    @GetMapping("/getAllByName/{name}")
    public ResponseEntity<List<PharmacyDrugs>> getAll(@PathVariable String name) {
        List<PharmacyDrugs> drugs=pharmacyDrugsService.findByName(name);
        List<PharmacyDrugs> newList=new ArrayList<>();
        for(PharmacyDrugs pD:drugs){
            if(pD.getQuantity()>0){
                newList.add(pD);
            }
        }
        return newList == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(newList);
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<PharmacyDrugs> getById(@PathVariable Integer id) {
        PharmacyDrugs drug = pharmacyDrugsService.findById(id);
        return new ResponseEntity<>(drug, HttpStatus.OK);
    }

    //vrati sve lijekove neke apooteke
    @GetMapping(value = "/findDrugsByIdPharm/{id}/{name}")
    public ResponseEntity<String> findAll(@PathVariable Integer id,@PathVariable String name) {
         String answer=pharmacyDrugsService.check( id,name);
         return new ResponseEntity<>(answer, HttpStatus.ACCEPTED);

    }




    @GetMapping(value = "/checkAvalibility/{id}/{name}")
    public ResponseEntity<Boolean> checkAvalibility(@PathVariable (value = "id") Integer id,@PathVariable (value = "name") String name) {
        String answer=pharmacyDrugsService.check(id,name);
        Boolean check=false;
        if(answer.equals("The drug is not available at the pharmacy")){
            check=false;
        }else {
            check = true;//lijek postoji
        }
        return new ResponseEntity<>(check, HttpStatus.ACCEPTED);
    }



    @GetMapping(value = "/findAlternative/{idPharm}/{id}/{name}")
    public ResponseEntity<Set<Drug>> findAlternativeDrugs(@PathVariable Integer idPharm,@PathVariable Integer id, @PathVariable String name) {
        Set<Drug> drugs=new HashSet<>();
        Set<Drug> finall=new HashSet<>();

        //ako je pacijent alergican na neki alternativni lijek,
        //dermatolog nece imati uopste u ponudi da izabere taj lijek
        if(pharmacyDrugsService.check(idPharm,name).equals("The drug is not available at the pharmacy")){//ako lijek ne postoji u ap pronadji alternativne
                drugs=pharmacyDrugsService.find(id,name);//alternativni lijekovi za proslijedjeni lijek
                for(Drug d:drugs){//prolazi kroz sve alternativne i provjerava dal je pacijent alergican na neki od njih
                    if(patientService.findAllergy(id,d.getName()).equals("The patient isn't allergic to the drug")) {
                          finall.add(d);
                    }

                }


            }
        return finall == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(finall);
    }


}
