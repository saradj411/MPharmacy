package com.isaProject.isa.Controllers;

import com.google.zxing.WriterException;
import com.isaProject.isa.Model.DTO.ERecipeDTO;
import com.isaProject.isa.Model.DTO.ERecipeWithUserDTO;
import com.isaProject.isa.Model.DTO.FrontERecipeDTO;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Services.Implementations.ERecipeService;
import com.isaProject.isa.Services.Implementations.ServiceForEmail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/erecipe")
@Slf4j

public class ERecipeController {
    @Autowired
    ERecipeService eRecipeService;
@Autowired
ServiceForEmail serviceForEmail;

   @GetMapping(value = "/findByIdPatient/{id}")
    public ResponseEntity<List<FrontERecipeDTO>> findSheduledPharmacistExamination(@PathVariable Integer id) {

        List<FrontERecipeDTO> d= eRecipeService.findByPatient(id);

        return d == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(d);
    }

    @GetMapping("/sortByDateAscending/{id}")
    ResponseEntity<List<FrontERecipeDTO>> sortByGradeGrowing(@PathVariable Integer id)
    {
        List<FrontERecipeDTO> recipes= eRecipeService.findByPatient(id);
        Collections.sort(recipes, new Comparator<FrontERecipeDTO>() {
            @Override
            public int compare(FrontERecipeDTO p1, FrontERecipeDTO p2) {
                return p1.getDateOfIssue().compareTo(p2.getDateOfIssue());

            }
        });

        return ResponseEntity.ok(recipes);
    }
    @GetMapping("/sortByDateDescending/{id}")
    ResponseEntity<List<FrontERecipeDTO>> sortByGradeDescending(@PathVariable Integer id)
    {
        List<FrontERecipeDTO> recipes= eRecipeService.findByPatient(id);
        Collections.sort(recipes, new Comparator<FrontERecipeDTO>() {
            @Override
            public int compare(FrontERecipeDTO p1, FrontERecipeDTO p2) {
                return p1.getDateOfIssue().compareTo(p2.getDateOfIssue());

            }
        });
        Collections.reverse(recipes);

        return ResponseEntity.ok(recipes);
    }

    @PostMapping("/createERecp")
    @PreAuthorize("hasRole('DERMATOLOGIST') || hasRole('PHARMACIST')")
    public ResponseEntity<List<ERecipeDTO>> getByName(@RequestBody List<ERecipeDTO> eRecipeDTOS) throws MessagingException {
        System.out.println(eRecipeDTOS);
        try {
            return new ResponseEntity(eRecipeService.create(eRecipeDTOS), HttpStatus.OK);
        } catch (IOException e) {
            e.printStackTrace();
        } catch (WriterException e) {
            e.printStackTrace();
        }
        return  new ResponseEntity<>(HttpStatus.BAD_REQUEST);
    }
    @GetMapping("/downloadERecepie")
    public ResponseEntity download() throws IOException, WriterException {
         return ResponseEntity.status(HttpStatus.OK).body(serviceForEmail.getQRCodeImage());

    }

    @GetMapping("/showERecepieQRcode/{idRecepie}")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<ERecipeWithUserDTO> showERecepieQRcode(@PathVariable Integer idRecepie) throws IOException, WriterException {
       return  new ResponseEntity<ERecipeWithUserDTO>(eRecipeService.showERecepieQRcode(idRecepie), HttpStatus.OK);

    }

    @GetMapping("/retValUser/{idRecepie}")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<User> retValUser(@PathVariable Integer idRecepie) throws IOException, WriterException {
        return  new ResponseEntity<User>(eRecipeService.retaValUser(idRecepie), HttpStatus.OK);

    }

    /*@GetMapping("/getPharmacyWhereToBuy/{name}/{q}")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity<List<DrugPricelist>> getPharmacyWhereToBuy(@PathVariable String name, @PathVariable Integer q)
        {
        return  new ResponseEntity(eRecipeService.getAllPharamcyForERecept(name,q), HttpStatus.OK);
    }

    /*@GetMapping("/buyDrug/{idRec}/{idPharmacy}")
    @PreAuthorize("hasRole('PATIENT')")
    public ResponseEntity buyDrug(@PathVariable Integer idRec, @PathVariable Integer idPharmacy)
    {
        return  new ResponseEntity(eRecipeService.buyDrug(idRec,idPharmacy), HttpStatus.OK);
    }*/



}
