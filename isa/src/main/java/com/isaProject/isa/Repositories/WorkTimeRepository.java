package com.isaProject.isa.Repositories;


import com.isaProject.isa.Model.Users.WorkTime;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface WorkTimeRepository  extends JpaRepository<WorkTime, Integer> {

    @Query("select s from WorkTime s where s.staff.id = ?1")
    WorkTime findWorkTimeByIdStaff(Integer id);
}
