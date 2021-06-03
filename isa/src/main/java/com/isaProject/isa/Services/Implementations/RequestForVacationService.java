package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.RequestForVacationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.RequestForVacation;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Repositories.RequestForVacationRepository;
import com.isaProject.isa.Services.IServices.IRequestForVacationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
@Slf4j
public class RequestForVacationService implements IRequestForVacationService {


    @Autowired
    RequestForVacationRepository requestForVacationRepository;
    @Autowired
    DermatologistService dermatologistService;

    @Autowired
    PharmacyService pharmacyService;

    @Override
    public RequestForVacation save(RequestForVacationDTO requestForVacationDTO) {
        RequestForVacation d = new RequestForVacation();
        Dermatologist der=dermatologistService.findById(requestForVacationDTO.getIdStaff());
        d.setDescription(requestForVacationDTO.getDescription());
        d.setAccepted(false);
        d.setEnd(requestForVacationDTO.getEnd());
        d.setStart(requestForVacationDTO.getStart());
        d.setStaff(der);
        d.setPharmacy(pharmacyService.pronadjiPoImenu(requestForVacationDTO.getName()));
        return requestForVacationRepository.save(d);
    }
}
