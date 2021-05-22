package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.WorkTimeDTO;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Model.Users.WorkTime;
import com.isaProject.isa.Repositories.WorkTimeRepository;
import com.isaProject.isa.Services.IServices.IWorkTimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class WorkTimeService implements IWorkTimeService {

    @Autowired
    WorkTimeRepository workTimeRepository;


   @Override
    public WorkTime findById(Integer id) {
        WorkTime workTime = workTimeRepository.findById(id).get();
        return workTime;

    }

    @Override
    public WorkTime findByIdUser(Integer id) {
        WorkTime workTime=workTimeRepository.findWorkTimeByIdStaff(id);
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

}
