package com.isaProject.isa.Services.Implementations.Grade;

import com.isaProject.isa.Model.Grades.PharmacistGrade;
import com.isaProject.isa.Model.Grades.PharmacyGrade;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Repositories.PharmacistGradeRepository;
import com.isaProject.isa.Repositories.PharmacyGradeRepository;
import com.isaProject.isa.Repositories.PharmacyRepository;
import com.isaProject.isa.Services.IServices.Grade.IPharmacyGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PharmacyGradeService implements IPharmacyGradeService {
    @Autowired
    PharmacyGradeRepository pharmacyGradeRepository;
    @Autowired
    PharmacyRepository pharmacyRepository;

    @Override
    public List<PharmacyGrade> findAll() {
        return pharmacyGradeRepository.findAll();
    }

    @Override
    public PharmacyGrade grade(Integer idPatient, Integer grade, Integer idPharm) {
        List<PharmacyGrade> list=pharmacyGradeRepository.findAll();
        Pharmacy pharmacy=pharmacyRepository.getOne(idPharm);
        //setuj dermatologu ocjenuuu
        PharmacyGrade newGrade=new PharmacyGrade();
        Boolean ima=false;
        for(PharmacyGrade dG:list){
            if(idPatient.equals(dG.getIdPatient()) && idPharm.equals(dG.getIdPharmacy())){
                ima=true;
                dG.setGrade(grade);
                newGrade=dG;

            }
        }

        if(ima){
            PharmacyGrade dg=pharmacyGradeRepository.save(newGrade);

            Double gradeD=(pharmacy.getAvgGrade()+dg.getGrade())/2;
            pharmacy.setAvgGrade(gradeD);
            pharmacyRepository.save(pharmacy);
            return newGrade;
        }else{
            PharmacyGrade newGrade1 =new PharmacyGrade();
            newGrade1.setGrade(grade);
            newGrade1.setIdPharmacy(idPharm);
            newGrade1.setIdPatient(idPatient);
            PharmacyGrade dg=pharmacyGradeRepository.save(newGrade1);

            Double gradeD=(pharmacy.getAvgGrade()+dg.getGrade())/2;
            pharmacy.setAvgGrade(gradeD);
            pharmacyRepository.save(pharmacy);

            return newGrade1;

        }


    }

}
