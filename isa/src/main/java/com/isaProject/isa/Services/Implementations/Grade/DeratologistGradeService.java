package com.isaProject.isa.Services.Implementations.Grade;

import com.isaProject.isa.Model.Grades.DermatolgoistGrade;
import com.isaProject.isa.Repositories.DermatologistGradeRepository;
import com.isaProject.isa.Services.IServices.Grade.IDeratologistGradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DeratologistGradeService implements IDeratologistGradeService {

    @Autowired
    DermatologistGradeRepository dermatologistGradeRepository;
    @Override
    public List<DermatolgoistGrade> findAll() {
        return dermatologistGradeRepository.findAll();
    }
}
