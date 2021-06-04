package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.ExaminationDTO;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;

import com.isaProject.isa.Model.DTO.SchedulePharmacistExaminationDTO;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Repositories.PatientRepository;
import com.isaProject.isa.Repositories.PharmacyRepository;
import com.isaProject.isa.Repositories.StaffRepository;
import com.isaProject.isa.Services.IServices.IExaminationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import javax.mail.MessagingException;
import java.util.ArrayList;
import java.util.Date;

import java.util.List;
import java.util.Set;

@Service
@Slf4j
public class ExaminationService implements IExaminationService {

    @Autowired
    ExaminationRepository examinationRepository;
    @Autowired
    PharmacyService pharmacyService;
    @Autowired
    PatientService patientService;
    @Autowired
    StaffService staffService;
    @Autowired
    PatientRepository patientRepository;
    @Autowired
    PharmacyRepository pharmacyRepository;
    @Autowired
    StaffRepository staffRepository;

    @Autowired
    ServiceForEmail serviceForEmail;

    @Override
    public List<Examination> findAll() {
        return examinationRepository.findAll();
    }


    @Override
    public Examination findById(Integer id) {
        return examinationRepository.findOneByIdExamination(id);
    }

    public Examination save(ExaminationDTO examinationDTO) {
        Examination d = new Examination();
        Staff s=new Staff();
        d.setDate(examinationDTO.getDate());
        d.setEndTime(examinationDTO.getEnd());
        d.setStartTime(examinationDTO.getStart());
        d.setStaff(staffService.findById(examinationDTO.getIdStaff()));
        d.setPharmacy(pharmacyService.findById(examinationDTO.getIdPharm()));
        d.setPrice(examinationDTO.getPrice());
        d.setType(ExaminationType.DERMATOLOGIST_EXAMINATION);
        d.setPatient(patientService.findById(examinationDTO.getIdPatient()));
        d.setStatus(ExaminationStatus.SCHEDULED);
        return examinationRepository.save(d);
    }



   /* @Override
    public Examination findById(Integer id) {
        //veki skontalaaa
        Examination examination=examinationRepository.findById(id).get();
        return examination;
    }*/

    @Override
    public void canceling(Integer id) {
        Examination pat = examinationRepository.getOne(id);


        pat.setCanceled(true);
        pat.setStatus(ExaminationStatus.CANCELED);


        examinationRepository.save(pat);
    }

    @Override
    public void patientCanceling(Examination examination) {
        Examination pat = examinationRepository.getOne(examination.getIdExamination());

        pat.setCanceled(true);
        pat.setStatus(ExaminationStatus.CREATED);
        pat.setScheduled(false);
        pat.setPatient(null);

        examinationRepository.save(pat);
    }
    @Override
    public void patientCancelingPharmacistExamination(Examination examination) {
        Examination pat = examinationRepository.getOne(examination.getIdExamination());

        pat.setCanceled(true);
        pat.setStatus(ExaminationStatus.CANCELED);
        pat.setScheduled(false);

        examinationRepository.save(pat);
    }

    public Boolean getExaminationByIdStaff(Integer idPharmacist){

        List<Examination> lista=examinationRepository.findAll();
        for(Examination e:lista){
            if (e.getStaff().getId().equals(idPharmacist)){
                return true;
            }
        }
        return  false;

    }

    public List<Examination>getExaminationsByIdStaffAndIdPharmacy(Integer idStaff){
        List<Examination>examinations=examinationRepository.getAllExaminationsByIdStaffAndIdPharmacy(idStaff);
        List<Examination>freeEx = new ArrayList<>();
        for (Examination e:examinations){
            if(e.getStatus().equals(ExaminationStatus.CREATED)){
                freeEx.add(e);
            }
        }
        return examinations;
    }


    @Override
    public List<FrontCreatedExaminationDTO> findCreatedDermatologistExamination() {
        List<Examination> list=examinationRepository.findAll();
        List<FrontCreatedExaminationDTO> newList=new ArrayList<>();
        for(Examination e:list){
            if (e.getType().compareTo(ExaminationType.DERMATOLOGIST_EXAMINATION)==0){
                if(e.getStatus().compareTo(ExaminationStatus.CREATED)==0) {
                    FrontCreatedExaminationDTO exDTO=new FrontCreatedExaminationDTO(e.getIdExamination(),e.getDate(),
                            e.getStartTime(),e.getEndTime(),e.getPrice(),
                            e.getStaff().getName(),e.getStaff().getSurname(),e.getStaff().getAvgGrade()
                    );
                    newList.add(exDTO);
                }
            }
        }
        return  newList;
    }
    @Override
    public void scheduledDermatologistExamination(Integer idPatient, Integer idExamination) throws MessagingException {
        Examination pat = examinationRepository.getOne(idExamination);


        pat.setStatus(ExaminationStatus.SCHEDULED);
        pat.setScheduled(true);

        Patient patient=patientRepository.getOne(idPatient);
        pat.setPatient(patient);

        examinationRepository.save(pat);
        serviceForEmail.sendingMailToPatientForExamination(pat,patient);
    }

    @Override
    public Boolean schedulePharmacistExamination(SchedulePharmacistExaminationDTO schedulePharmacistExaminationDTO) throws MessagingException {
        Examination examination=new Examination();
        Patient patient=patientRepository.findOneById(schedulePharmacistExaminationDTO.getPatient());
        Pharmacy pharmacy=pharmacyRepository.findOneByIdPharm(schedulePharmacistExaminationDTO.getPharmacy());
        Staff staff=staffRepository.getOne(schedulePharmacistExaminationDTO.getStaff());

        Boolean res=true;
        Set<Examination> list=patient.getExaminations();
        for(Examination e:list){
            if(e.getStatus().compareTo(ExaminationStatus.CANCELED)==0){
                if(e.getDate().compareTo(schedulePharmacistExaminationDTO.getDate())==0){
                    if(e.getStartTime().compareTo(schedulePharmacistExaminationDTO.getStartTime())==0){
                        if(e.getStaff().getId()==staff.getId()){
                            res=false;
                        }

                    }
                }
            }
        }
        if(res) {
            examination.setCanceled(false);
            examination.setDate(schedulePharmacistExaminationDTO.getDate());
            examination.setEndTime(schedulePharmacistExaminationDTO.getStartTime().plusHours(1));
            examination.setStartTime(schedulePharmacistExaminationDTO.getStartTime());
            examination.setScheduled(true);
            examination.setPrice(schedulePharmacistExaminationDTO.getPrice());
            examination.setReport(null);
            examination.setStatus(ExaminationStatus.SCHEDULED);
            examination.setType(ExaminationType.PHARMACIST_EXAMINATION);
            examination.setPatient(patient);
            examination.setPharmacy(pharmacy);
            examination.setStaff(staff);
            examination.setTherapy(null);

            examinationRepository.save(examination);

            serviceForEmail.sendingMailToPatientForExamination(examination, patient);
            return true;
        }else{
            return false;
        }
    }


}
