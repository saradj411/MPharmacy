package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Examination.Examination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination, Integer> {


    @Query("select s from Examination s where s.staff.id= ?1")
    List<Examination> find(Integer id);
}
