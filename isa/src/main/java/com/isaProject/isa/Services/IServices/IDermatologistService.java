package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.*;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.WorkTime;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;
import java.util.List;
import java.util.Set;

public interface IDermatologistService {

    String delete(Dermatologist dermatologist, Integer idPharm);

    Dermatologist findById(Integer id);
    List<Dermatologist> findAll ();

    Dermatologist save(DermatologistDTO dermatologist);
    //String delete(Dermatologist dermatologist);
    Set<PatientDTO> findAllPatients(Integer id) ;

    Dermatologist create(DermatologistForCreateDTO dermatologistForCreateDTO);

    void update(Dermatologist dermatologist);

  //  void update(ScheduleAnExaminationDTO scheduleAnExaminationDTO);

    void updateFreeEx(ScheduleAnExaminationDTO scheduleAnExaminationDTO);

    void  scheduleEx();

    boolean checkingThatTheScheduleMatches(List<WorkTime> list, LocalDate date, LocalTime start, LocalTime end);
/*
    void  scheduleEx(Date date, LocalTime start, LocalTime end, String pharmacyName, Integer idDerm);

    void  scheduleEx(Date date, LocalTime start, LocalTime end, String name, Integer idDerm, Integer idPharm);
*/
    void  scheduleEx(LocalDate date, LocalTime start, LocalTime end, String name, Integer idDerm, Integer idPharm, Integer idPatient, double price);

    void patientNotAppear(Integer idEx);

    void startExamination(CreateExaminationDTO createExaminationDTO);

    List<ReviewedClientsDTO> reviewedClientsDermatologist(Integer id);
    Set<Pharmacy> pharmacies(Integer id);

   // String delete(Dermatologist dermatologist, Integer idPharm);


}
