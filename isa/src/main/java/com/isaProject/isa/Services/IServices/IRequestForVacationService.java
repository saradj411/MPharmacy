package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.RequestForVacationDTO;
import com.isaProject.isa.Model.Users.RequestForVacation;

public interface IRequestForVacationService {
     RequestForVacation save(RequestForVacationDTO requestForVacationDTO) ;
     RequestForVacation save1(RequestForVacationDTO requestForVacationDTO);
}
