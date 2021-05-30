package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Services.IServices.IExaminationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ExaminationService implements IExaminationService {

    @Autowired
    ExaminationRepository examinationRepository;

    @Override
    public List<Examination> findAll() {
        return examinationRepository.findAll();
    }

    @Override

    public void canceling(Integer id) {
        Examination pat = examinationRepository.getOne(id);


        pat.setCanceled(true);
        pat.setStatus(ExaminationStatus.CANCELED);


        examinationRepository.save(pat);
    }
    public Boolean getExaminationByIdStaff(Integer idPharmacist){

        List<Examination> lista=examinationRepository.findAll();
        for(Examination e:lista){
            if (e.getStaff().getId().equals(idPharmacist)){
                return true;
            }
        }
        return  false;

    }

}
