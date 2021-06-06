package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.PharmacyAdminDTO;
import com.isaProject.isa.Model.Users.PharmacyAdmin;

import java.util.List;

public interface IPharmacyAdminService {
    PharmacyAdmin findById(Integer id);
    PharmacyAdmin findByName(String name);
    List<PharmacyAdmin> findAll ();
    PharmacyAdmin save(PharmacyAdminDTO drug);

    void update1(PharmacyAdmin pharmacyAdmin);

    void update(PharmacyAdmin drug);
}
