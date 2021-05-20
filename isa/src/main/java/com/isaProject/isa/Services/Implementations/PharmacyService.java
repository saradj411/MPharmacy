package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.PharmacyDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Repositories.PharmacyRepository;
import com.isaProject.isa.Services.IServices.IPharmacyService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PharmacyService implements IPharmacyService {

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Override
    public Pharmacy findById(Integer id) {
        //veki skontalaaa
        Pharmacy pharm = pharmacyRepository.findOneByIdPharm(id);
        return pharm;
    }
    @Override
    public List<Pharmacy> findByName(String name) {
        //veki skontalaaa
        return pharmacyRepository.findOneByName(name);

    }

    @Override
    public List<Pharmacy> findByAddress(String city) {
        return pharmacyRepository.findOneByAddress(city);
    }

    @Override
    public List<Pharmacy> findAll() {

        return pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy save(PharmacyDTO pharmacy) {
        Pharmacy pharm = new Pharmacy();
        pharm.setName(pharmacy.getName());
        pharm.setDescription(pharmacy.getDescription());
        pharm.setAddress(pharmacy.getAddress());
        pharm.setAvgGrade(pharmacy.getAvgGrade());

        return pharmacyRepository.save(pharm);
    }

    @Override
    public void update(Pharmacy pharmacy) {
        Pharmacy pharm = pharmacyRepository.getOne(pharmacy.getIdPharm());
        Integer ids=pharm.getIdPharm();

        pharm.setName(pharmacy.getName());
        pharm.setDescription(pharmacy.getDescription());
        pharm.setAddress(pharmacy.getAddress());
        pharm.setAvgGrade(pharmacy.getAvgGrade());

        pharmacyRepository.save(pharm);

        }
}

