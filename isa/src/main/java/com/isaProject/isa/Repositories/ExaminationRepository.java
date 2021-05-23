package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Examination.Examination;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ExaminationRepository extends JpaRepository<Examination, Integer> {
}
