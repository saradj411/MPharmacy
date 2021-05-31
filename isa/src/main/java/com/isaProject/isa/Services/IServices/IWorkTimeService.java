package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.WorkTimeDTO;
import com.isaProject.isa.Model.Users.WorkTime;

public interface IWorkTimeService {


    WorkTime findById(Integer id);

    WorkTime findByUserId(Integer id);

    WorkTime save(WorkTimeDTO workTimeDTO);
}
