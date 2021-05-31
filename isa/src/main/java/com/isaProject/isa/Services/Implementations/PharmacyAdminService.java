package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.PharmacyAdminDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import com.isaProject.isa.Repositories.PharmacyAdminRepository;
import com.isaProject.isa.Services.IServices.IPharmacyAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PharmacyAdminService implements IPharmacyAdminService {

    @Autowired
    PharmacyAdminRepository pharmacyAdminRepository;

    @Autowired
    private PharmacyService pharmacyService;

    @Override
    public PharmacyAdmin findById(Integer id) {
        PharmacyAdmin pa = pharmacyAdminRepository.findOneById(id);
        return pa;
    }

    @Override
    public PharmacyAdmin findByName(String name) {
        return null;
    }

    @Override
    public List<PharmacyAdmin> findAll() {
        return pharmacyAdminRepository.findAll();
    }

    @Override
    public PharmacyAdmin save(PharmacyAdminDTO pharmacyAdminDTO) {
        PharmacyAdmin pa = new PharmacyAdmin();
        pa.setName(pharmacyAdminDTO.getName());
        Pharmacy p=pharmacyService.findById(pharmacyAdminDTO.getIdPharm());
        pa.setPharmacy(p);
        pa.setAddress(pharmacyAdminDTO.getAddress());
        pa.setCity(pharmacyAdminDTO.getCity());
        pa.setCountry(pharmacyAdminDTO.getCountry());
        pa.setEmail(pharmacyAdminDTO.getEmail());
        pa.setPassword(pharmacyAdminDTO.getPassword());
        pa.setPhoneNumber(pharmacyAdminDTO.getPhoneNumber());
        pa.setSurname(pharmacyAdminDTO.getSurname());
        return pharmacyAdminRepository.save(pa);
    }

    @Override
    public void update(PharmacyAdmin pharmacyAdmin) {
        PharmacyAdmin pa = pharmacyAdminRepository.getOne(pharmacyAdmin.getId());
        pa.setName(pharmacyAdmin.getName());
        pa.setSurname(pharmacyAdmin.getSurname());
        pa.setAddress(pharmacyAdmin.getAddress());
        pa.setCity(pharmacyAdmin.getCity());
        pa.setCountry(pharmacyAdmin.getCountry());
        pa.setPhoneNumber(pharmacyAdmin.getPhoneNumber());
        pa.setPassword(pharmacyAdmin.getPassword());
        pa.setEmail(pharmacyAdmin.getEmail());
        pharmacyAdminRepository.save(pa);
    }
}
