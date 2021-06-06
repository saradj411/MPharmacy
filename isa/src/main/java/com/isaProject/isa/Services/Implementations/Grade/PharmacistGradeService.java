package com.isaProject.isa.Services.Implementations.Grade;

import com.isaProject.isa.Model.Grades.DermatolgoistGrade;
import com.isaProject.isa.Model.Grades.PharmacistGrade;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Repositories.PharmacistGradeRepository;
import com.isaProject.isa.Repositories.PharmacistRepository;
import com.isaProject.isa.Services.IServices.Grade.IPharmacistGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PharmacistGradeService implements IPharmacistGradeService {
    @Autowired
    PharmacistGradeRepository pharmacistGradeRepository;
    @Autowired
    PharmacistRepository pharmacistRepository;

    @Override
    public List<PharmacistGrade> findAll() {
        return pharmacistGradeRepository.findAll();
    }

    @Override
    public PharmacistGrade grade(Integer idPatient, Integer grade, Integer idPharm) {
        List<PharmacistGrade> list=pharmacistGradeRepository.findAll();
        Pharmacist pharmacist=pharmacistRepository.getOne(idPharm);
        System.out.println(pharmacist.getAvgGrade());
        //setuj dermatologu ocjenuuu
        PharmacistGrade newGrade=new PharmacistGrade();
        Boolean ima=false;
        for(PharmacistGrade dG:list){
            if(idPatient.equals(dG.getIdPatient()) && idPharm.equals(dG.getIdPharmacist())){
                ima=true;
                dG.setGrade(grade);
                newGrade=dG;

            }
        }

        if(ima){
            PharmacistGrade dg=pharmacistGradeRepository.save(newGrade);
            Double gradeD=(pharmacist.getAvgGrade()+dg.getGrade())/2;
            pharmacist.setAvgGrade(gradeD);
            pharmacistRepository.save(pharmacist);
            return newGrade;
        }else{
            PharmacistGrade newGrade1 =new PharmacistGrade();
            newGrade1.setGrade(grade);
            newGrade1.setIdPharmacist(idPharm);
            newGrade1.setIdPatient(idPatient);
            PharmacistGrade dg=pharmacistGradeRepository.save(newGrade1);

            Double gradeD=(pharmacist.getAvgGrade()+dg.getGrade())/2;
            pharmacist.setAvgGrade(gradeD);
            pharmacistRepository.save(pharmacist);
            return newGrade1;

        }


    }

}
