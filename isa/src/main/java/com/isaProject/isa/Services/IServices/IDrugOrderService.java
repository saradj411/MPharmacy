package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.DrugOrderDTO;
import com.isaProject.isa.Model.Drugs.DrugOrder;

import java.util.List;

public interface IDrugOrderService {
     //DrugOrder createDrugOrder(DrugOrderDTO drugOrder);
     DrugOrder save(DrugOrderDTO drugOrderDTO) ;

    List<DrugOrder> findAll();
    //    DrugOrder createDrugOrder(DrugOrderDTO drugOrder);

}
