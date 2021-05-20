package com.isaProject.isa.Services.Implementations;

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

    }