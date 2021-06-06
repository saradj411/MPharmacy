package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.OfferStatus;

import java.time.LocalDate;

public class OfferDTO {

    public Integer getIdOffer() {
        return idOffer;
    }

    public void setIdOffer(Integer idOffer) {
        this.idOffer = idOffer;
    }

    private Integer idOffer;
    private Integer idOrder;
    private double totalPrice;
    private LocalDate deliveryDate;
    private Integer idSupplier;
    private OfferStatus offerStatus;

    public OfferStatus getOfferStatus() {
        return offerStatus;
    }

    public void setOfferStatus(OfferStatus offerStatus) {
        this.offerStatus = offerStatus;
    }

    public OfferDTO(Integer idOffer, Integer idOrder, double totalPrice, LocalDate deliveryDate, Integer idSupplier, OfferStatus offerStatus) {
        this.idOffer = idOffer;
        this.idOrder = idOrder;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
        this.idSupplier = idSupplier;
        this.offerStatus = offerStatus;
    }

    public OfferDTO(){}

    public OfferDTO(Integer idOrder, double totalPrice, LocalDate deliveryDate, Integer idSupplier) {
        this.idOrder = idOrder;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
        this.idSupplier = idSupplier;
    }
    public OfferDTO(Integer idOffer, Integer idOrder, double totalPrice, LocalDate deliveryDate, Integer idSupplier) {
        this.idOffer = idOffer;
        this.idOrder = idOrder;
        this.totalPrice = totalPrice;
        this.deliveryDate = deliveryDate;
        this.idSupplier = idSupplier;
    }

    public Integer getIdOrder() {
        return idOrder;
    }

    public void setIdOrder(Integer idOrder) {
        this.idOrder = idOrder;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public LocalDate getDeliveryDate() {
        return deliveryDate;
    }

    public void setDeliveryDate(LocalDate deliveryDate) {
        this.deliveryDate = deliveryDate;
    }

    public Integer getIdSupplier() {
        return idSupplier;
    }

    public void setIdSupplier(Integer idSupplier) {
        this.idSupplier = idSupplier;
    }

    @Override
    public String toString() {
        return "OfferDTO{" +
                "idOrder=" + idOrder +
                ", totalPrice=" + totalPrice +
                ", deliveryDate=" + deliveryDate +
                ", idSupplier=" + idSupplier +
                '}';
    }
}
