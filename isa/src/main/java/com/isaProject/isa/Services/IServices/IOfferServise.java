package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.OfferDTO;
import com.isaProject.isa.Model.Drugs.Offer;

import javax.mail.MessagingException;
import java.util.List;

public interface IOfferServise {

    List<Offer> findOffersByIdOrder(Integer id);
    Offer findById(Integer id);

    Offer chooseOffer(Integer id, Integer idAdmin) throws MessagingException;

    Offer save(OfferDTO offerDTO);

    List<OfferDTO> findAllByIdSupplier(Integer idSupplier);

    void deleteById(Integer id_offer);

    Offer update(OfferDTO offer);
}
