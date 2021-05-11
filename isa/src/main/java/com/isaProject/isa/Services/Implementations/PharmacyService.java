package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Repositories.PharmacyRepository;
import com.isaProject.isa.Services.IServices.IPharmacyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PharmacyService implements IPharmacyService {

    @Autowired
    PharmacyRepository pharmacyRepository;
}
