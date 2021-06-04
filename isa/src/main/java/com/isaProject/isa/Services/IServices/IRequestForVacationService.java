package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.RequestForVacationDTO;
import com.isaProject.isa.Model.Users.RequestForVacation;

import javax.mail.MessagingException;
import java.util.List;

public interface IRequestForVacationService {
     RequestForVacation save(RequestForVacationDTO requestForVacationDTO) ;

    List<RequestForVacation> listOfVacation(Integer idAdmina);

    RequestForVacation acceptOrRefuseRequuest(Integer requestForVacationId, String text) throws MessagingException;
     RequestForVacation save1(RequestForVacationDTO requestForVacationDTO);
}
