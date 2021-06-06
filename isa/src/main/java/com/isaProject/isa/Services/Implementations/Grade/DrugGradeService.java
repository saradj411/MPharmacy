package com.isaProject.isa.Services.Implementations.Grade;

import com.isaProject.isa.Model.Grades.DrugGrade;
import com.isaProject.isa.Model.Grades.PharmacistGrade;
import com.isaProject.isa.Repositories.DrugGradeRepository;
import com.isaProject.isa.Services.IServices.Grade.IDrugGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrugGradeService implements IDrugGradeService {
    @Autowired
    DrugGradeRepository drugGradeRepository;

    @Override
    public List<DrugGrade> findAll() {
        return drugGradeRepository.findAll();
    }

    @Override
    public DrugGrade grade(Integer idPatient, Integer grade, Integer idDrug) {
        List<DrugGrade> list=drugGradeRepository.findAll();
        //setuj dermatologu ocjenuuu
        DrugGrade newGrade=new DrugGrade();
        Boolean ima=false;
        for(DrugGrade dG:list){
            if(idPatient.equals(dG.getIdPatient()) && idDrug.equals(dG.getIdDrug())){
                ima=true;
                dG.setGrade(grade);
                newGrade=dG;

            }
        }

        if(ima){
            drugGradeRepository.save(newGrade);
            return newGrade;
        }else{
            DrugGrade newGrade1 =new DrugGrade();
            newGrade1.setGrade(grade);
            newGrade1.setIdDrug(idDrug);
            newGrade1.setIdPatient(idPatient);
            drugGradeRepository.save(newGrade1);
            return newGrade1;

        }

    }
}
