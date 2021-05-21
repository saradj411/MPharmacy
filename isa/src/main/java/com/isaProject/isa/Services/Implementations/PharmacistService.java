package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.PharmaceutDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Repositories.DermatologistRepository;
import com.isaProject.isa.Repositories.PharmacistRepository;
import com.isaProject.isa.Services.IServices.IDermatologistService;
import com.isaProject.isa.Services.IServices.IPharamacistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
@Slf4j
public class PharmacistService implements IPharamacistService {


    public @Autowired
    PharmacistRepository pharmacistRepository;

    @Override
    public Pharmacist findById(Integer id) {
        //veki skontalaaa
        Pharmacist pharmacist=pharmacistRepository.findById(id).get();
        return pharmacist;
    }





    @Override
    public List<Pharmacist> findAll() {

        return pharmacistRepository.findAll();
    }


    @Override
    public Pharmacist save(PharmaceutDTO dto) {
        Pharmacist d = new Pharmacist();
        d.setName(dto.getName());
        d.setSurname(dto.getSurname());
        d.setEmail(dto.getEmail());
        d.setPassword(null);
        d.setAddress(dto.getAddress());
        d.setPhoneNumber(dto.getPhoneNumber());
        d.setCity(dto.getCity());
        d.setCountry(dto.getCountry());
        d.setAvgGrade(0.0);
        d.setVacation(null);
        d.setWorkTime(dto.getWorkTime());
        d.setExaminations(null);
        d.setPharmacy(dto.getPharmacy());

        return pharmacistRepository.save(d);
    }

    }