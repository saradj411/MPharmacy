package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.DrugOrderDTO;
import com.isaProject.isa.Model.Drugs.DrugOrder;

public interface IDrugOrderService {
     //DrugOrder createDrugOrder(DrugOrderDTO drugOrder);
     DrugOrder save(DrugOrderDTO drugOrderDTO) ;

}
