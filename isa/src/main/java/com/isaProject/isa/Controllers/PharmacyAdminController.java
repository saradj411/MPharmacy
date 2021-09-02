package com.isaProject.isa.Controllers;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.isaProject.isa.Model.DTO.DefiningFreeTermsWithDermatologist;
import com.isaProject.isa.Model.DTO.PharmacyAdminDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.Ingredient;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Services.Implementations.PharmacyAdminService;
import com.isaProject.isa.Services.Implementations.PharmacyService;
import com.isaProject.isa.Services.Implementations.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.*;

@RestController
@CrossOrigin("*")
@RequestMapping(value="/adminstrator")
@Slf4j
public class PharmacyAdminController {

    @Autowired
    private PharmacyAdminService pharmacyAdminService;

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private UserService userService;

    @GetMapping(value = "/findAll")
    public ResponseEntity<List<PharmacyAdmin>> findAll() {
        List<PharmacyAdmin> userss= pharmacyAdminService.findAll();
        for (PharmacyAdmin u:userss){
            u.getPharmacy();
            u.getDrugOrder();
        }

        System.out.println("nestoo");
        return userss == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(userss);
    }
    @GetMapping(value = "/findPharm/{id}")
    public ResponseEntity<Pharmacy> getPharm(@PathVariable Integer id) {

        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findById(id);
        System.out.println("ajde "+pharmacyAdmin.getPharmacy().getName());
        return pharmacyAdmin.getPharmacy() == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(pharmacyAdmin.getPharmacy());
    }

    @GetMapping(value = "/findById/{id}")
    public ResponseEntity<PharmacyAdmin> findById(@PathVariable Integer id) {

        PharmacyAdmin d=pharmacyAdminService.findById(id);
        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }

    //MediaType.APPLICATION_JSON)
    @PostMapping("/updateAdminPharmacy")
    ResponseEntity<String> updateAdmin(@RequestBody PharmacyAdmin pharmacyAdmin)
    {
        pharmacyAdminService.update1(pharmacyAdmin);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

    @PostMapping(value = "/updateAdmin")
    ResponseEntity<String> update(@RequestBody PharmacyAdmin pharmacyAdmin)
    {
        System.out.println("id admina je "+pharmacyAdmin.getId());
        System.out.println("id admina je "+pharmacyAdmin.getName());
        System.out.println("id admina je "+pharmacyAdmin.getAddress());

        pharmacyAdminService.update(pharmacyAdmin);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

    @PostMapping(value = "/definingFreeTermsWithDermatologist",consumes={"application/json"})
    ResponseEntity<String> definingFreeTermsWithDermatologist(@RequestBody DefiningFreeTermsWithDermatologist definingFreeTermsWithDermatologist)
    {
        pharmacyAdminService.definingFreeTermsWithDermatologist(definingFreeTermsWithDermatologist);
        return new ResponseEntity<>("ajdeee", HttpStatus.CREATED);

    }

        /*

    Svaki dermatolog ima radno vreme za svaku apoteku posebno. Administrator
apoteke definiše preglede kod dermatologa u terminu kada je dermatolog u
apoteci. Za svaki pregled potrebno je definisati datum i vreme početka pregleda,
trajanje pregleda i cenu. U radnom kalendaru dermatologa nalaze se pregledi
koji su unapred definisani.


     */

    @PostMapping(value = "/savePharmacyAdmin", consumes={"application/json"})
    @PreAuthorize("hasRole('ADMIN')")
    ResponseEntity<PharmacyAdmin> update(@RequestBody PharmacyAdminDTO pharmacyAdminDTO) throws MessagingException {
        PharmacyAdmin pharmAdmin = pharmacyAdminService.save(pharmacyAdminDTO);
        return pharmAdmin != null ? new ResponseEntity<>(pharmAdmin, HttpStatus.CREATED)
        : new ResponseEntity<>(HttpStatus.BAD_REQUEST);

    }




}
