package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.PharmacyAdminDTO;
import com.isaProject.isa.Model.Users.PharmacyAdmin;

import javax.mail.MessagingException;
import java.util.List;

public interface IPharmacyAdminService {
    PharmacyAdmin findById(Integer id);
    PharmacyAdmin findByName(String name);
    List<PharmacyAdmin> findAll ();
    PharmacyAdmin save(PharmacyAdminDTO drug) throws MessagingException;

    void update1(PharmacyAdmin pharmacyAdmin);

    void update(PharmacyAdmin drug);
}
