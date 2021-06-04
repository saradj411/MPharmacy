package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.WorkTimeDTO;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Model.Users.WorkTime;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Repositories.WorkTimeRepository;
import com.isaProject.isa.Services.IServices.IWorkTimeService;
import lombok.extern.slf4j.Slf4j;
import org.apache.tomcat.jni.Local;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
@Slf4j
public class WorkTimeService implements IWorkTimeService {

    @Autowired
    WorkTimeRepository workTimeRepository;
    @Autowired
    ExaminationRepository examinationRepository;

    @Override
    public List<WorkTime> findAll() {

        return workTimeRepository.findAll();
    }
   @Override
    public WorkTime findById(Integer id) {
        WorkTime workTime = workTimeRepository.findById(id).get();
        return workTime;

    }

    @Override
    public WorkTime findByUserId(Integer id) {
        WorkTime workTime = workTimeRepository.findWorkTimeByIdStaff(id);
        return workTime;
    }

    @Override
    public WorkTime save(WorkTimeDTO workTimeDTO) {
        WorkTime workTime=new WorkTime();
        workTime.setPharmacy(workTimeDTO.getPharmacy());
        workTime.setEndTime(workTimeDTO.getEndTime());
        workTime.setStartTime(workTimeDTO.getStartTime());
        workTime.setDate(workTimeDTO.getDate());
        workTime.setStaff(workTimeDTO.getStaff());
        return workTimeRepository.save(workTime);

    }
    @Override
    public List<Staff> listForPatient(LocalDate date, LocalTime time){
        LocalTime newTime=time.plusHours(1);

        List<WorkTime> workTimes=workTimeRepository.listForPatient(date);

        List<WorkTime> wT=new ArrayList<>();
        List<WorkTime> result=new ArrayList<>();

        List<Staff> zaposleni=new ArrayList<>();
        for(WorkTime workT:workTimes){
            if(workT.getStaff().getAuthorityRole().equals("PHARMACIST")){
                  if(workT.getStartTime().isBefore(time)){
                    if(workT.getEndTime().isAfter(time)) {
                        System.out.println("radno vrijeme ima tad");
                        wT.add(workT);
                    }
                }
            }
        }

        for(WorkTime wrkT:wT){
            Boolean mozeLi=true;
            System.out.println("uslo u radna vremena ta");
            List<Examination> ex=examinationRepository.getAllExaminationsByIdStaffAndIdPharmacy(wrkT.getStaff().getId());
            for(Examination e:ex){
                if(e.getDate().compareTo(date)==0){
                    System.out.println("uslo u isti datuuum");
                    if(e.getStartTime().isBefore(time)){
                        if(!e.getEndTime().isBefore(time)) {
                           System.out.println("ima pregled tad");
                            mozeLi=false;
                        }
                    }
                    if(e.getStartTime().isAfter(time)){
                        if(e.getStartTime().isBefore(newTime)) {

                            System.out.println("ima pregled tad ovdheeee");
                            mozeLi=false;
                        }
                    }
                }
            }
            if(mozeLi){
                result.add(wrkT);
                zaposleni.add(wrkT.getStaff());
                //dodaj ga da ide dalje
            }
        }

        return zaposleni;
    }

}
