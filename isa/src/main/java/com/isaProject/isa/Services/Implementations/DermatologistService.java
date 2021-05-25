package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DermatologistDTO;
import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Model.Users.WorkTime;
import com.isaProject.isa.Repositories.DermatologistRepository;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Repositories.PharmacyRepository;
import com.isaProject.isa.Repositories.WorkTimeRepository;
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

    public @Autowired
    WorkTimeRepository workTimeRepository;

    public @Autowired
    ExaminationRepository examinationRepository;
    public @Autowired
    ExaminationService examinationService;

    Set<WorkTime> tajm = new HashSet<WorkTime>();

    Set<Pharmacy> pharmOfDerm = new HashSet<Pharmacy>();

    @Override
    public void update(Dermatologist dermatologist) {
        Dermatologist pa = dermatologistRepository.getOne(dermatologist.getIdUser());
        pa.setName(dermatologist.getName());
        pa.setSurname(dermatologist.getSurname());
        pa.setAddress(dermatologist.getAddress());
        pa.setCity(dermatologist.getCity());
        pa.setCountry(dermatologist.getCountry());
        pa.setPhoneNumber(dermatologist.getPhoneNumber());
        pa.setPassword(dermatologist.getPassword());
        pa.setEmail(dermatologist.getEmail());
        dermatologistRepository.save(pa);
    }

    @Override
    public String delete(Dermatologist dermatologist) {
        String message = "Dermatoloist is not deleted!";


        if(examinationService.getExaminationByIdStaff(dermatologist.getIdUser()).equals(false)){
            dermatologistRepository.delete(dermatologist);
            return  "Dermatoloist is  deleted!";

        }
        for (Examination examination : examinationRepository.findAll()) {
            if (examination.getScheduled()){

            }else {
                if(examination.getStaff().getIdUser()==dermatologist.getIdUser()){
                    if(examination.getType().equals(ExaminationType.DERMATOLOGIST_EXAMINATION)){
                        dermatologistRepository.delete(dermatologist);

                        for (WorkTime workTimeDermatologist : workTimeRepository.findAll()) {
                            if (workTimeDermatologist.getStaff().getIdUser() == dermatologist.getIdUser()) {
                                workTimeRepository.delete(workTimeDermatologist);

                            }
                        }
                        message = "Dermatoloist is deleted!";

                    }
                }
            }




        }


        return message;


    }



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
