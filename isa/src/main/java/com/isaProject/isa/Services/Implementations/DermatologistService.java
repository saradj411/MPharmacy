package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Repositories.DermatologistRepository;
import com.isaProject.isa.Repositories.PharmacyRepository;
import com.isaProject.isa.Services.IServices.IDermatologistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
@Slf4j
public class DermatologistService implements IDermatologistService {


    public @Autowired
    DermatologistRepository dermatologistRepository;

    @Override
    public Dermatologist findById(Integer id) {
        //veki skontalaaa
        Dermatologist dermatologist=dermatologistRepository.findById(id).get();
        return dermatologist;
    }





    @Override
    public List<Dermatologist> findAll() {

        return dermatologistRepository.findAll();
    }
}
