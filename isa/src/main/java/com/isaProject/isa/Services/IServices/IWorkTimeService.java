package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.WorkTimeDTO;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Model.Users.WorkTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;

public interface IWorkTimeService {


    WorkTime findById(Integer id);

    WorkTime findByUserId(Integer id);

    WorkTime save(WorkTimeDTO workTimeDTO);
    List<WorkTime> findAll();
    List<Staff> listForPatient(LocalDate date, LocalTime time);
    List<Staff> listStaffForPatient(LocalDate date, LocalTime time);
}
