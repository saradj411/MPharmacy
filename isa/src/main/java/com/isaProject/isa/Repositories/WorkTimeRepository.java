package com.isaProject.isa.Repositories;


import com.isaProject.isa.Model.Users.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface WorkTimeRepository  extends JpaRepository<WorkTime, Integer> {

    //@Query("select s from WorkTime s where s.staff.idUser= ?1") //za pharm
    @Query("select s from WorkTime s where s.staff.id = ?1")
    WorkTime findWorkTimeByIdStaff(Integer id);



    @Query("select s from WorkTime s where s.staff.id= ?1 and pharmacy.idPharm= ?2") //za derm
    List<WorkTime> findWorkTimeByIdDermAndIdPharm(Integer id,Integer idPharm);

    @Query("select s from WorkTime s where s.date= ?1 and s.startTime= ?2 and s.endTime= ?3")
    WorkTime listaWorkTime(LocalDate date, LocalTime start, LocalTime end);

    @Query("select s from WorkTime s where s.date= ?1")
    List<WorkTime> listForPatient(LocalDate date);

}
