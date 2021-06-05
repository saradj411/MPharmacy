package com.isaProject.isa.Controllers;

import com.isaProject.isa.Model.DTO.OfferDTO;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.Offer;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Repositories.OfferRepository;
import com.isaProject.isa.Services.Implementations.OfferService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.mail.MessagingException;
import java.util.Date;
import java.util.List;

@RestController
@CrossOrigin
@RequestMapping(value="/offer", produces = MediaType.APPLICATION_JSON_VALUE)
@Slf4j
public class OfferController {

    @Autowired
    OfferService offerService;


   /*
    Za svaku narudžbenicu administrator apoteke može da vidi sve ponude koje su
dobavljači dali.Uzmi ponude po id-ju narudzbenice
     */

    @GetMapping(value = "/getOfferByIdOrder/{id}")
    public ResponseEntity<List<Offer>> getOfferByIdOrder(@PathVariable Integer id) {
        List<Offer> offers=offerService.findOffersByIdOrder(id);
        for (Offer o:offers)
        {
            o.getDrugOrder();
            o.getDrugOrder().getOffers();
            o.getDrugOrder().getOrderItems();
            o.getSupplier();
        }
        return offers == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(offers);
    }




    @GetMapping(value ="/chooseOffer/{idOffer}/{idAdmin}")
    public ResponseEntity<Offer> chooseOffer(@PathVariable Integer idOffer,@PathVariable Integer idAdmin) throws MessagingException {


        System.out.println("usao u kontroler");
        Offer offer=offerService.chooseOffer(idOffer,idAdmin);

        return offer == null ?
                new ResponseEntity<>(HttpStatus.NOT_FOUND) :
                ResponseEntity.ok(offer);
    }

    @PostMapping(value = "/newOffer")
    public ResponseEntity<Offer> newOffer(@RequestBody OfferDTO offerDTO)
    {
        Offer offer = offerService.save(offerDTO);

        return offer == null ? new ResponseEntity<>(HttpStatus.BAD_REQUEST)
                : new ResponseEntity<>(offer, HttpStatus.CREATED);
    }

    /*
    Nakon isteka roka za davanje ponude, bira jednu ponudu koju
prihvata dok se ostale automatski odbijaju. Dobavljač se obaveštava putem
mail-a da li je njegova ponuda prihvaćena ili odbijena

     */


}
