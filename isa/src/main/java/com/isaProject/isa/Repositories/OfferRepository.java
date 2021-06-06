package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.Offer;
import com.isaProject.isa.Model.Drugs.OrderItem;
import com.isaProject.isa.Model.Users.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Transactional
public interface OfferRepository extends JpaRepository<Offer , Integer> {

    //uzmi sve ponude jedne narudzbenice
    @Query("select s from Offer s where s.drugOrder.idOrder= ?1")
    List<Offer> findOffersByIdOrder(Integer id);
    Offer findByIdOffer(Integer idOffer);
    @Modifying
    @Query("delete from Offer f where f.idOffer = ?1")
    void delete(Integer idOffer);




}
