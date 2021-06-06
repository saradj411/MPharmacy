package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.PharmacyDTO;
import com.isaProject.isa.Model.DTO.StaffDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import org.springframework.stereotype.Service;

import java.util.List;


public interface IPharmacyService {

    Pharmacy findById(Integer id);
    List<Pharmacy> findByName(String name);

    Pharmacy findByNamee(String name);

    Pharmacy pronadjiPoImenu(String name);

    List<Pharmacy> findByAddress(String city);
    List<Pharmacy> findAll ();
    Pharmacy save(PharmacyDTO pharmacy);
    void update(Pharmacy pharmacy);

    double getAvgGrade(Integer idPharm);

    List<StaffDTO>view(Integer idPharm);

    List<StaffDTO>viewDerm(Integer idPharm);
    List<Pharmacy> findAllOrderByNameAsc();
    List<Pharmacy> findAllOrderByNameDesc();
}
