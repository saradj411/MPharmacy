package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.*;
import com.isaProject.isa.Model.Drugs.DrugOrder;
import com.isaProject.isa.Model.Drugs.OrderItem;
import com.isaProject.isa.Repositories.DrugOrderRepository;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Repositories.OrderItemRepository;
import com.isaProject.isa.Services.IServices.IDrugOrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.*;

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
    PharmacyService pharmacyService;
    @Autowired
    OrderItemRepository orderItemRepository;


    @Override
    public DrugOrder save(DrugOrderDTO drugOrderDTO) {
        DrugOrder d = new DrugOrder();
        d.setTimeLimit(drugOrderDTO.getTimeLimit());
        d.setProcessed(false);
        //ceka narudjbenicu
        d.setPharmacyAdmin(pharmacyAdminService.findById(drugOrderDTO.getId()));



        DrugOrder drugOrder = drugOrderRepository.save(d);
        for(OrderItemDTO medDto : drugOrderDTO.getOrderItemDTO()){//vrati mi listu llijekova sa kolicinom
            OrderItem orderItem1 = new OrderItem(medDto.getQuantity(),medDto.getDrug());//
            orderItem1.setDrugOrder(d);
            orderItemRepository.save(orderItem1);
        }
        return drugOrder;

    }
    @Override
    public List<DrugOrder> findAll() {
        return drugOrderRepository.findAll();
    }



    @Override
    public List<DrugOrder> getAllOrder() {
        return  drugOrderRepository.findAll();
    }

    @Override
    public List<DrugOrderAndItemDTO> getDrugOrderAndItemDTO() {

        ArrayList<DrugOrderAndItemDTO> retVal = new ArrayList<DrugOrderAndItemDTO>();



        for(DrugOrder drug : getAllOrder())
        {
            DrugOrderAndItemDTO dto = new DrugOrderAndItemDTO();
            dto.setIdOrder(drug.getIdOrder());
            dto.setPharmacyId(drug.getPharmacyAdmin().getId());
            dto.setTimeLimit(drug.getTimeLimit());
            dto.setPharmacyName(pharmacyService.findById(dto.getPharmacyId()).getName());

            ArrayList<DrugOrderItemDTO> drugItemListDTO = new ArrayList<>();

            Set<OrderItem> drugItems = drug.getOrderItems();

            for(OrderItem oi : drugItems)
            {
                DrugOrderItemDTO drugOrderItemDTO = new DrugOrderItemDTO();
                drugOrderItemDTO.setIdItemOrder(oi.getIdItem());
                drugOrderItemDTO.setIdDrug(oi.getDrug().getIdDrug());
                drugOrderItemDTO.setNameDrug(oi.getDrug().getName());
                drugOrderItemDTO.setQuantity(oi.getQuantity());
                drugOrderItemDTO.setManufacturuer(oi.getDrug().getManufacturer());

                drugItemListDTO.add(drugOrderItemDTO);
            }

            dto.setDrugList(drugItemListDTO);
            retVal.add(dto);
        }

        return retVal;
    }

    @Override
    public DrugOrder findById(Integer id) {
        return drugOrderRepository.findOnByidOrder(id);
    }



/*    @Override
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


    public List<OrderItem>getOrderByIdOffer(Integer idOrder){
        List<OrderItem>lista=orderItemRepository.findAll();
        List<OrderItem>itms=new ArrayList<>();
        for (OrderItem o:lista){
            if (o.getDrugOrder().getIdOrder().equals(idOrder)){
                itms.add(o);
            }
        }
        return itms;
    }


}
