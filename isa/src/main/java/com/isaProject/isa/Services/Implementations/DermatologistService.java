package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DermatologistDTO;
import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.WorkTime;
import com.isaProject.isa.Repositories.DermatologistRepository;
import com.isaProject.isa.Repositories.PharmacyRepository;
import com.isaProject.isa.Services.IServices.IDermatologistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Optional;
import java.util.Set;

@Service
@Slf4j
public class DermatologistService implements IDermatologistService {


    public @Autowired
    DermatologistRepository dermatologistRepository;


    Set<WorkTime> tajm = new HashSet<WorkTime>();

    Set<Pharmacy> pharmOfDerm = new HashSet<Pharmacy>();

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

    @Override
    public Dermatologist save(DermatologistDTO dermatologist) {
        Dermatologist d = new Dermatologist();
        d.setName(dermatologist.getName());
        d.setSurname(dermatologist.getSurname());
        d.setEmail(dermatologist.getSurname());
        d.setPassword(dermatologist.getPassword());
        d.setAddress(dermatologist.getPhoneNumber());
        d.setPhoneNumber(dermatologist.getPhoneNumber());
        d.setCity(dermatologist.getCity());
        d.setCountry(dermatologist.getCountry());
        d.setAvgGrade(dermatologist.getAvgGrade());
        d.setWorkTime(null);
        d.setExaminations(null);
        d.setVacation(null);
        pharmOfDerm.add(dermatologist.getPharmacy());
        d.setPharmacies(pharmOfDerm);
        return dermatologistRepository.save(d);
    }
}
