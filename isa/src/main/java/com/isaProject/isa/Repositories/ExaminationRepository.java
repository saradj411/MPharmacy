package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import javax.naming.Name;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface ExaminationRepository extends JpaRepository<Examination, Integer> {


    @Query("select s from Examination s where s.staff.id= ?1")
    List<Examination> find(Integer id);

    @Query("select s from Examination s where s.pharmacy.idPharm= ?1")
    List<Examination> findExaminationsByIdPharm(Integer idPharm);

    Examination findOneByIdExamination(Integer id);

    @Query("select s from Examination s where s.staff.id= ?1")
    List<Examination>getAllExaminationsByIdStaffAndIdPharmacy(Integer idStaff);


    @Query("select s from Examination s where s.date= ?1 and s.startTime= ?2 and s.endTime= ?3 and s.price= ?4 and s.pharmacy.idPharm= ?5")
    Examination getExaminationsByParams(Date date, LocalTime startTime, LocalTime endTime, double price, String pharmacyName);


    @Query("select s from Examination s where s.date= ?1 and s.startTime= ?2 and s.endTime= ?3")
    List<Examination> getExaminationsByTime(LocalDate date, LocalTime startTime, LocalTime endTime);





}
