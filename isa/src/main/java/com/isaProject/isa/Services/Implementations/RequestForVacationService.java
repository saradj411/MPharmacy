package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DrugDTO;
import com.isaProject.isa.Model.DTO.RequestForVacationDTO;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Model.Users.RequestForVacation;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Repositories.PharmacyAdminRepository;
import com.isaProject.isa.Repositories.RequestForVacationRepository;
import com.isaProject.isa.Services.IServices.IRequestForVacationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.List;


@Service
@Slf4j
public class RequestForVacationService implements IRequestForVacationService {


    @Autowired
    RequestForVacationRepository requestForVacationRepository;
    @Autowired
    DermatologistService dermatologistService;
    @Autowired
    PharmacistService pharmacistService;

    @Autowired
    PharmacyService pharmacyService;

    @Autowired
    PharmacyAdminRepository pharmacyAdminRepository;

    @Autowired
    ServiceForEmail serviceForEmail;

    @Override
    public RequestForVacation save(RequestForVacationDTO requestForVacationDTO) {
        RequestForVacation d = new RequestForVacation();
        Dermatologist der=dermatologistService.findById(requestForVacationDTO.getIdStaff());
        d.setAccepted(false);
        d.setEnd(requestForVacationDTO.getEnd());
        d.setStart(requestForVacationDTO.getStart());
        d.setStaff(der);
        d.setPharmacy(pharmacyService.pronadjiPoImenu(requestForVacationDTO.getName()));
        return requestForVacationRepository.save(d);
    }

    @Override
    public RequestForVacation save1(RequestForVacationDTO requestForVacationDTO) {
        RequestForVacation d = new RequestForVacation();
        Pharmacist pharmacist=pharmacistService.findById(requestForVacationDTO.getIdStaff());
        d.setAccepted(false);
        d.setEnd(requestForVacationDTO.getEnd());
        d.setStart(requestForVacationDTO.getStart());
        d.setStaff(pharmacist);
        d.setPharmacy(pharmacist.getPharmacy());
        return requestForVacationRepository.save(d);
    }


    /*
    Administrator apoteke ima listu svih pristiglih zahteva za godiĹˇnjim odmorom ili
    odsustvom farmaceuta, koje moĹľe da potvrdi ili da odbije.
*/

    @Override
    public List<RequestForVacation> listOfVacation(Integer idAdmina){

        PharmacyAdmin pharmacyAdmin=pharmacyAdminRepository.findOneById(idAdmina);
        List<RequestForVacation> listOfNotProcccesVacations=new ArrayList<>();

        List<RequestForVacation>lista=requestForVacationRepository.find(pharmacyAdmin.getPharmacy().getIdPharm());
        for (RequestForVacation r:lista){
            if(r.isRequestProcessed()){

            }else {
                listOfNotProcccesVacations.add(r);
            }
        }

        return listOfNotProcccesVacations;


    }

    /*
    Bilo da je zahtev prihvaÄ‡en ili odbijen, dermatolog ili farmaceut se obaveĹˇtava
putem mejla. Ukoliko je zahtev odbijen, administrator u slobodnoj formi unosi
razlog odbijanja zahteva koji se obavezno mora naÄ‡i u mejlu koji se Ĺˇalje
zaposlenom.

     */

    @Override
    public RequestForVacation acceptOrRefuseRequuest(Integer requestForVacationId, String text) throws MessagingException {
        RequestForVacation requestForVacation=requestForVacationRepository.getOne(requestForVacationId);
        if(text.equals("prihvacen")){
            serviceForEmail.sendingEmailToAcceptRequestForVacation(requestForVacation);
            requestForVacation.setAccepted(true);

        }else {
            //mejl za odbijanje
            serviceForEmail.sendingEmailToRejectRequestForVacation(requestForVacation,text);
            requestForVacation.setDescription(text);
            requestForVacation.setAccepted(false);
        }
        requestForVacation.setRequestProcessed(true);
        requestForVacationRepository.save(requestForVacation);


        return requestForVacation;


    }




    @Override
    public RequestForVacation acceptRequuest(Integer requestForVacationId) throws MessagingException {
        RequestForVacation requestForVacation=requestForVacationRepository.getOne(requestForVacationId);

            //mejl za prihvatanje
            serviceForEmail.sendingEmailToAcceptRequestForVacation(requestForVacation);
            requestForVacation.setAccepted(true);

        requestForVacation.setRequestProcessed(true);
        requestForVacationRepository.save(requestForVacation);


        return requestForVacation;


    }






}




