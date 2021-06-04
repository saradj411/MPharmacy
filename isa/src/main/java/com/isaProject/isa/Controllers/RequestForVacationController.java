package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.RequestForVacationDTO;
import com.isaProject.isa.Model.DTO.RequestForVacationViewDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Users.RequestForVacation;
import com.isaProject.isa.Repositories.RequestForVacationRepository;
import com.isaProject.isa.Services.Implementations.DrugService;
import com.isaProject.isa.Services.Implementations.RequestForVacationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;


@RestController
@CrossOrigin
@RequestMapping(value="/requestVacation")
@Slf4j

public class RequestForVacationController {


    @Autowired
    private RequestForVacationService requestForVacationService;

    @Autowired
    private RequestForVacationRepository requestForVacationRepository;



    @PostMapping("/createPharmacist")
    public ResponseEntity<String> createPharmacist(@RequestBody RequestForVacationDTO requestForVacationDTO) {
        RequestForVacation requestForVacation = requestForVacationService.save1(requestForVacationDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }
    @PostMapping("/create")
    public ResponseEntity<String> addDrug(@RequestBody RequestForVacationDTO requestForVacationDTO) {
        RequestForVacation requestForVacation = requestForVacationService.save(requestForVacationDTO);
        return new ResponseEntity<>("kreirano", HttpStatus.CREATED);
    }




    @GetMapping(value = "/findAll/{idAdmina}")
    public ResponseEntity<List<RequestForVacationViewDTO>> findAll(@PathVariable Integer idAdmina) {
        List<RequestForVacation> request=requestForVacationService.listOfVacation(idAdmina);
        List<RequestForVacationViewDTO>dto=new ArrayList<>();
        String name="prihvacen";
        for (RequestForVacation requestForVacation:request){
            RequestForVacationViewDTO requestForVacationViewDTO=new RequestForVacationViewDTO(requestForVacation.getStart(),requestForVacation.getEnd(),requestForVacation.getStaff().getName(),requestForVacation.getStaff().getSurname(),requestForVacation.getPharmacy().getName(),requestForVacation.getId());
            dto.add(requestForVacationViewDTO);
        }

        return dto == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(dto);
    }

    @GetMapping(value = "/acceptOrRefuseRequest/{requestForVacationId}/{text}")
    public ResponseEntity<RequestForVacation> acceptOrRefuseRequuest(@PathVariable Integer requestForVacationId,@PathVariable String text) throws MessagingException {
        System.out.println("vrati id jeeeej"+requestForVacationId);
        System.out.println("razlog je "+text);


        RequestForVacation user=requestForVacationService.acceptOrRefuseRequuest(requestForVacationId,text);
        return user == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(user);
    }

    @GetMapping(value = "/acceptRequest/{id}")
    public ResponseEntity<RequestForVacation> accept(@PathVariable Integer id) throws MessagingException {

        RequestForVacation user=requestForVacationService.acceptRequuest(id);
        return user == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(user);
    }


    @GetMapping(value = "/getRequestById/{id}")
    public ResponseEntity<RequestForVacation> acceptOrRefuseRequuestp(@PathVariable Integer id) {
        RequestForVacation user=requestForVacationRepository.getOne(id);
        return user == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(user);
    }







}
