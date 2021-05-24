package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.PharmaceutDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Model.Users.WorkTime;
import com.isaProject.isa.Repositories.DermatologistRepository;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Repositories.PharmacistRepository;
import com.isaProject.isa.Repositories.WorkTimeRepository;
import com.isaProject.isa.Services.IServices.IDermatologistService;
import com.isaProject.isa.Services.IServices.IPharamacistService;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.Instant;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Set;


@Service
@Slf4j
public class PharmacistService implements IPharamacistService {


    public @Autowired
    PharmacistRepository pharmacistRepository;

    public @Autowired
    ExaminationRepository examinationRepository;

    public @Autowired
    WorkTimeRepository workTimeRepository;
    public @Autowired
    ExaminationService examinationService;


    @Override
    public String delete(Pharmacist pharmacist) {// ne moze izbrisati farmaceute koji imaju zakazane preglede


        String message = "Pharmacist is not  deleted";
        if(examinationService.getExaminationByIdStaff(pharmacist.getIdUser()).equals(false)){
            pharmacistRepository.delete(pharmacist);
            return  "Pharmacist is not  deleted";

        }

        for (Examination examination : examinationRepository.findAll()) {
            if (examination.getType().toString().equals("PHARMACIST_EXAMINATION") && examination.getStaff().getIdUser().equals(pharmacist.getIdUser()) && !examination.getScheduled()) {
                pharmacistRepository.delete(pharmacist);

                for (WorkTime workTimePharmacist : workTimeRepository.findAll()) {
                    if (workTimePharmacist.getStaff().getIdUser().equals(pharmacist.getIdUser())) {
                        workTimeRepository.delete(workTimePharmacist);

                    }
                }
                message = "Pharmacist is successfully deleted";
            }


        }
        return message;


    }

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
/*
    @Override
    public String delete(Pharmacist pharmacist) {



        for(Examination examination : examinationRepository.findAll()){

            if(examination.getType().equals("PHARMACIST_EXAMINATION") && examination.getStaff().getIdUser() == pharmacist.getIdUser() && !examination.getScheduled()){
                throw  new IllegalStateException("Pharmacist  has scheduled examination.");
            }
        }

        for(WorkTime workTimePharmacist : workTimeRepository.findAll()){
            if(workTimePharmacist.getStaff().getIdUser()== pharmacist.getIdUser()){
                workTimeRepository.delete(workTimePharmacist);
            }
        }
        pharmacistRepository.delete(pharmacist);
        return  "Pharmacist is successfully deleted";
    }
*/
    }