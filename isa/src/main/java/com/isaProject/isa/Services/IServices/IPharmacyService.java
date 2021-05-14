package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPharmacyService {

    List<Pharmacy> findAll();
}
