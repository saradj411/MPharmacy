package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.DermatologistDTO;
import com.isaProject.isa.Model.DTO.WorkTimeDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Model.Users.WorkTime;

public interface IWorkTimeService {


    WorkTime findById(Integer id);

    WorkTime findByIdUser(Integer id);

    WorkTime save(WorkTimeDTO workTimeDTO);
}
