package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.DrugOrderAndItemDTO;
import com.isaProject.isa.Model.DTO.DrugOrderDTO;
import com.isaProject.isa.Model.Drugs.DrugOrder;

import java.util.List;
import java.util.Optional;

public interface IDrugOrderService {
     //DrugOrder createDrugOrder(DrugOrderDTO drugOrder);
     DrugOrder save(DrugOrderDTO drugOrderDTO) ;
 //    DrugOrder createDrugOrder(DrugOrderDTO drugOrder);
     List<DrugOrder> getAllOrder();
     List<DrugOrderAndItemDTO> getDrugOrderAndItemDTO();
     DrugOrder findById(Integer id);

}
