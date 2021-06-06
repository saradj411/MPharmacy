package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.SupplierDTO;
import com.isaProject.isa.Model.Users.Supplier;

import java.util.Optional;

public interface ISupplierService {
    Supplier save(SupplierDTO supplierDTO);
}
