package com.isaProject.isa.Services.Implementations.Grade;

import com.isaProject.isa.Model.Grades.DermatolgoistGrade;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Repositories.DermatologistGradeRepository;
import com.isaProject.isa.Repositories.DermatologistRepository;
import com.isaProject.isa.Services.IServices.Grade.IDeratologistGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeratologistGradeService implements IDeratologistGradeService {

    @Autowired
    DermatologistGradeRepository dermatologistGradeRepository;
    @Autowired
    DermatologistRepository dermatologistRepository;
    @Override
    public List<DermatolgoistGrade> findAll() {
        return dermatologistGradeRepository.findAll();
    }

    @Override
    public DermatolgoistGrade grade(Integer idPatient, Integer grade, Integer idDerm) {
        List<DermatolgoistGrade> list=dermatologistGradeRepository.findAll();
        Dermatologist dermatologist=dermatologistRepository.getOne(idDerm);

        //setuj dermatologu ocjenuuu
        DermatolgoistGrade newGrade=new DermatolgoistGrade();
        Boolean ima=false;
        for(DermatolgoistGrade dG:list){
                if(idPatient.equals(dG.getIdPatient()) && idDerm.equals(dG.getIdDermatologist())){
                        ima=true;
                        dG.setGrade(grade);
                        newGrade=dG;

                    }
                }

        if(ima){
            dermatologistGradeRepository.save(newGrade);
            Double gradeD=(dermatologist.getAvgGrade()+newGrade.getGrade())/2;
            dermatologist.setAvgGrade(gradeD);
            dermatologistRepository.save(dermatologist);
            return newGrade;
        }else{
            DermatolgoistGrade newGrade1 =new DermatolgoistGrade();
            newGrade1.setGrade(grade);
            newGrade1.setIdDermatologist(idDerm);
            newGrade1.setIdPatient(idPatient);
            dermatologistGradeRepository.save(newGrade1);
            Double gradeD=(dermatologist.getAvgGrade()+newGrade.getGrade())/2;
            dermatologist.setAvgGrade(gradeD);
            dermatologistRepository.save(dermatologist);
            return newGrade1;

        }


    }
}
