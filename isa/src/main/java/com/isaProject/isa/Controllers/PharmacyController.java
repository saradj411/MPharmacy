package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.AddressForMap;
import com.isaProject.isa.Model.DTO.PharmacyDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.PharmacyDrugs;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Services.IServices.IPharmacyService;
import com.isaProject.isa.Services.Implementations.DrugPricelistService;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.PharmacyDrugsService;
import com.isaProject.isa.Services.Implementations.PharmacyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/pharmacy")
@Slf4j
public class PharmacyController {

    @Autowired
    private PharmacyService pharmacyService;
    @Autowired
    private DrugService drugService;

    @Autowired
    private DrugPricelistService drugPricelistService;

    @Autowired
    private PharmacyDrugsService pharmacyDrugsService;


    @GetMapping(value = "/findAll")
    public ResponseEntity<List<Pharmacy>> findAll() {
        List<Pharmacy> pharmacies=pharmacyService.findAll();
        return pharmacies == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacies);
    }

    @GetMapping(value = "/findByCity/{city}")
    public ResponseEntity<List<Pharmacy>> findByCity(@PathVariable String city) {
        List<Pharmacy> pharmacies=pharmacyService.findByAddress(city);
        return pharmacies == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacies);
    }
    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<Pharmacy> findById(@PathVariable Integer id) {
        //log.info("dsds:"+id);
        Pharmacy pharm=pharmacyService.findById(id);
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }
    @GetMapping(value = "/getDrugsPharmacy/{id}")
    public ResponseEntity<List<Drug>> findDrugs(@PathVariable Integer id) {
        List<Drug> drugs=drugService.findAll();
        List<PharmacyDrugs> pharmacyDrugs=pharmacyDrugsService.findAll();

        ArrayList<Drug> listDrugs = new ArrayList<>();

        for (PharmacyDrugs dp:pharmacyDrugs){
            for (Drug dd:drugs){
                if(dp.getPharmacy().getIdPharm().equals(id)){
                    System.out.println("eee"+dp.getPharmacy().getIdPharm());
                    if(dd.getIdDrug().equals(dp.getDrug().getIdDrug())){
                        listDrugs.add(dd);
                    }

                }
            }

        }
        return listDrugs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(listDrugs);
    }



    @GetMapping(value = "/findDrugByName/{name}/{id}")
    public ResponseEntity<List<Drug>> findDrugByName(@PathVariable String name,Integer id) {
        List<Drug> drugs=drugService.findAll();
        List<DrugPricelist> drugPricelists=drugPricelistService.findAll();

        ArrayList<Drug> listDrugs = new ArrayList<>();
        ArrayList<Drug> idemoo = new ArrayList<>();

        for (DrugPricelist dp:drugPricelists){
            for (Drug dd:drugs){
                if(dd.getIdDrug().equals(dp.getDrug().getIdDrug())){
                    System.out.println("eee"+dp.getPharmacy().getIdPharm());
                    if(dp.getPharmacy().getIdPharm().equals(id)){

                        if(dd.getName().equals(name)){
                            listDrugs.add(dd);
                            System.out.println("Naziv trazenog lijeka jeee   "+dd.getName());

                        }
                    }

                }
            }

        }

        return listDrugs == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(listDrugs);
    }



    @GetMapping(value = "/findByName/{name}")
    public ResponseEntity<List<Pharmacy>> findById(@PathVariable String name) {
        //log.info("dsds:"+id);
        List<Pharmacy> pharm=pharmacyService.findByName(name);
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }

    @GetMapping(value = "/findOneByName/{name}")
    public ResponseEntity<Pharmacy> findByName(@PathVariable String name) {
        //log.info("dsds:"+id);
        Pharmacy pharm=pharmacyService.pronadjiPoImenu(name);
        return pharm == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharm);
    }
    @PostMapping("/register")
    @PreAuthorize("hasRole('ADMIN')")
    public ResponseEntity<Pharmacy> addPharmacy(@RequestBody PharmacyDTO pharmacyDTO) {

        System.out.println("Usao u controller add pharmacy");
        Pharmacy pharmacy = pharmacyService.save(pharmacyDTO);
        return pharmacy != null ? new ResponseEntity<>(pharmacy, HttpStatus.CREATED)
                : new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }

    @PostMapping("/updatePharmacy")
    ResponseEntity<String> update(@RequestBody Pharmacy pharmacy)
    {

        pharmacyService.update(pharmacy);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }


    @GetMapping("/sortByGradeDescending")
    ResponseEntity<List<Pharmacy>> sortByGradedescending()
    {
        List<Pharmacy> pharmacies = pharmacyService.findAll();
        Collections.sort(pharmacies, new Comparator<Pharmacy>() {
            @Override
            public int compare(Pharmacy p1, Pharmacy p2) {
                return Double.compare(p1.getAvgGrade(), p2.getAvgGrade());

            }
        });

        Collections.reverse(pharmacies);

        return ResponseEntity.ok(pharmacies);
    }
    @GetMapping("/sortByGradeAscending")
    ResponseEntity<List<Pharmacy>> sortByGradeGrowing()
    {
        List<Pharmacy> pharmacies = pharmacyService.findAll();
        Collections.sort(pharmacies, new Comparator<Pharmacy>() {
            @Override
            public int compare(Pharmacy p1, Pharmacy p2) {
                return Double.compare(p1.getAvgGrade(), p2.getAvgGrade());

            }
        });

        return ResponseEntity.ok(pharmacies);
    }

    @GetMapping("/sortByNameDescending")
    ResponseEntity<List<Pharmacy>> sortByNameDescending()
    {
        List<Pharmacy> pharmacies = pharmacyService.findAllOrderByNameDesc();


        return ResponseEntity.ok(pharmacies);
    }
    @GetMapping("/sortByNameAscending")
    ResponseEntity<List<Pharmacy>> sortByNameGrowing()
    {
        List<Pharmacy> pharmacies = pharmacyService.findAllOrderByNameAsc();


        return ResponseEntity.ok(pharmacies);
    }

    @GetMapping("mapp/{idPharm}")
    ResponseEntity<AddressForMap> getPharmacyAddress(@PathVariable Integer idPharm) {
        Pharmacy pharmacy = pharmacyService.findById(idPharm);
        AddressForMap addressDTO = new AddressForMap();
        addressDTO.setCountry(pharmacy.getCountry());
        addressDTO.setTown(pharmacy.getTown());
        addressDTO.setStreet(pharmacy.getStreet());
        addressDTO.setNumber(pharmacy.getNumber());
        addressDTO.setPostalCode(pharmacy.getPostalCode());
        return pharmacy == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(addressDTO);
    }



}