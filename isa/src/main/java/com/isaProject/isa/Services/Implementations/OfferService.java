package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.OfferDTO;
import com.isaProject.isa.Model.Drugs.*;

import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Supplier;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Repositories.DrugOrderRepository;
import com.isaProject.isa.Repositories.OfferRepository;
import com.isaProject.isa.Repositories.SupplierRepository;
import com.isaProject.isa.Repositories.UserRepository;
import com.isaProject.isa.Services.IServices.IOfferServise;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import javax.mail.MessagingException;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import static com.isaProject.isa.Model.Drugs.OfferStatus.CONFIRMED;
import static com.isaProject.isa.Model.Drugs.OfferStatus.REJECTED;


@Service
@Slf4j
public class OfferService implements IOfferServise{

    @Autowired
    OfferRepository offerRepository;

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserService userService;

    @Autowired
    DrugPricelistService drugPricelistService;

    @Autowired
    SupplierRepository supplierRepository;

    @Autowired
    DrugOrderRepository drugOrderRepository;

    @Autowired
    ServiceForEmail serviceForEmail;
    @Autowired
    DrugOrderService drugOrderService;

    @Override
    public List<Offer>findOffersByIdOrder(Integer id){
        List<Offer> lista=offerRepository.findOffersByIdOrder(id);
        for (Offer o:lista)
        {
            o.getDrugOrder();
            o.getDrugOrder().getOffers();
            o.getDrugOrder().getOrderItems();
            o.getSupplier();
        }
        return  lista;
    }

    @Override
    public Offer chooseOffer(Integer id, Integer idAdmin) throws MessagingException {//treba mi id ponude i admin
        Offer offer=offerRepository.getOne(id);
        DrugOrder drugOrder=offer.getDrugOrder();
        System.out.println("Ponuda za prihvatajee  "+offer.getIdOffer()+"  "+offer.getDrugOrder().getIdOrder());
        System.out.println("Usao u serviss");
        LocalDate today = LocalDate.now();
        List<Offer>forRejection =offerRepository.findOffersByIdOrder(offer.getDrugOrder().getIdOrder());
        if(offer.getDrugOrder().getTimeLimit().isAfter(today)){
            System.out.println("ne valja datum");

            throw new IllegalArgumentException("The time for making an offer does not expire.You can not choose offer");


        }

/*

odkomentarisiiii
        if (drugOrder.getProcessed()==true){
            throw new IllegalArgumentException("Drug order is processed");
        }

*/



        if(offer.getDrugOrder().getPharmacyAdmin().getId().equals(idAdmin)) {
            System.out.println("dobaaee");


        }else {
            throw new IllegalArgumentException("This order create other Pharmacy admin");


        }
        offer.setOfferStatus(CONFIRMED);
        offerRepository.save(offer);

        drugOrder.setProcessed(true);
        drugOrderRepository.save(drugOrder);
        serviceForEmail.sendingAnEmailToAcceptTheOffer(drugOrder,offer);

        System.out.println("rejested");

        //ostale odbij
        for(Offer reject:forRejection){
            if(reject.getIdOffer().equals(offer.getIdOffer())){

            }else {
                serviceForEmail.sendingAnEmailToRejectTheOffer(drugOrder,reject);
                reject.setOfferStatus(REJECTED);
                offerRepository.save(reject);
            }
        }
//ako postoji promijeniti kolicinu ako ne dodati lijek u bazu.Pricelist i PharmacyDrugs.Izmijeniti poslee.
        List<DrugPricelist>drugsInPharmacy=drugPricelistService.findAllDrugsByPharmacy(offer.getDrugOrder().getPharmacyAdmin().getPharmacy().getIdPharm());




        return offer;
    }

    @Override
    public Offer save(OfferDTO offerDTO) {
        Offer offer = new Offer();
        offer.setOfferStatus(OfferStatus.ON_HOLD);
        offer.setDeliveryDate(convertLocalDateToDate(offerDTO.getDeliveryDate()));
        offer.setDrugOrder(drugOrderService.findById(offerDTO.getIdOrder()));
        offer.setPrice(offerDTO.getTotalPrice());
        Supplier supplier = supplierRepository.getOne(offerDTO.getIdSupplier());
        offer.setSupplier(supplier);



        offerRepository.save(offer);
        return offer;
    }

    // parsiranje LOCAL DATE to DATE
    public Date convertLocalDateToDate(LocalDate localDate) {
        return java.util.Date.from(localDate.atStartOfDay()
                .atZone(ZoneId.systemDefault())
                .toInstant());
    }


    /*

    Nakon isteka roka za davanje ponude, bira jednu ponudu koju
prihvata dok se ostale automatski odbijaju
     */
}
