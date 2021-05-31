package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DrugItemDTO;
import com.isaProject.isa.Model.DTO.DrugOrderDTO;
import com.isaProject.isa.Model.DTO.OrderItemDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Drugs.DrugPricelist;
import com.isaProject.isa.Model.Drugs.OrderItem;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import com.isaProject.isa.Repositories.DrugOrderRepository;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Repositories.OrderItemRepository;
import com.isaProject.isa.Services.IServices.IDrugOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class DrugOrderService implements IDrugOrderService {

    @Autowired
    PharmacyAdminService pharmacyAdminService;

    @Autowired
    DrugService drugService;

    @Autowired
    DrugPricelistService drugPricelistService;

    @Autowired
    DrugOrderRepository drugOrderRepository;

    @Autowired
    DrugRepository drugRepository;

    @Autowired
    OrderItemRepository orderItemRepository;
    /*

    @Override
    public DrugOrder save(DrugOrderDTO drugOrderDTO) {
        DrugOrder d = new DrugOrder();
        d.setTimeLimit(drugOrderDTO.getTimeLimit());
        d.setPharmacyAdmin(pharmacyAdminService.findById(drugOrderDTO.getId()));
        //d.setProcessed(false);
        //d.setOffers(null);


        DrugOrder drugOrder = drugOrderRepository.save(d);
        for(OrderItemDTO medDto : drugOrderDTO.getOrderItemDTO()){//vrati mi listu llijekova sa kolicinom
            OrderItem orderItem1 = new OrderItem(medDto.getQuantity(),medDto.getDrug());//
            orderItem1.setDrugOrder(d);
            orderItemRepository.save(orderItem1);
        }
        return drugOrder;

    }
/*
    @Override
    public DrugOrder createDrugOrder(DrugOrderDTO drugOrder) {

        if(drugOrder.getTimeLimit().be(new Date())){
            throw new IllegalArgumentException("Error.Input date again");
        }
        DrugOrder order = new DrugOrder();
        order.setTimeLimit(drugOrder.getTimeLimit());//***********
        order.setProcessed(false);//**********
        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findById(drugOrder.getIdAdmin());
        order.setPharmacyAdmin(pharmacyAdmin);//preko admina moze doci do apoteke
        Pharmacy pharmacy = pharmacyAdmin.getPharmacy();
        order.setOffers(null);
        // order.setOrderItems(drugOrder.getDrugOrderItems());
        DrugOrder drugOrder1=drugOrderRepository.save(order);

        for(DrugItemDTO dto : drugOrder.getDrugOrderItems()){
            String code=dto.getCode();//****************
            String name;//***********
            Drug drug=new Drug();//***************
            List<Drug> drugs=drugService.findAll();
            for(Drug d:drugs){
                if(d.getCode().equals(code)){
                    drug=d;
                }
            }
            OrderItem item = new OrderItem(dto.getQuantity(),drug,drugOrder1);//*** mejbi izbaciti order
            //item.setOrder(order1);
            orderItemRepository.save(item);
        }

        return order;
    }*/
    }

     */
}
