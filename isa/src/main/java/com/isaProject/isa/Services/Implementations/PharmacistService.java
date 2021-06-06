package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.PharmaceutDTO;
import com.isaProject.isa.Model.DTO.PharmacistForCreateDTO;
import com.isaProject.isa.Model.DTO.ReviewedClientsDTO;
import com.isaProject.isa.Model.DTO.ScheduleAnExaminationDTO;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.*;
import com.isaProject.isa.Repositories.*;
import com.isaProject.isa.Services.IServices.IPharamacistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;


@Service
@Slf4j
public class PharmacistService implements IPharamacistService {


    public @Autowired
    PharmacistRepository pharmacistRepository;
    public @Autowired
    ExaminationRepository examinationRepository;

    public @Autowired
    WorkTimeRepository workTimeRepository;
    public @Autowired
    ExaminationService examinationService;
    public @Autowired
    PatientRepository patientRepository;

    public @Autowired
    PharmacyRepository pharmacyRepository;

    public @Autowired
    StaffRepository staffRepository;
    public @Autowired
    DermatologistRepository dermatologistRepository;





    @Override
    public List<ReviewedClientsDTO> reviewedClientsDermatologist(Integer id){
        List<Examination> examinations=examinationRepository.findAll();
        List <ReviewedClientsDTO> reviewedClientsDTOS=new ArrayList<>();

        for (Examination e:examinations){
            if(e.getStaff().getId().equals(id)){
                if(e.getStatus().compareTo(ExaminationStatus.FINISHED)==0){
                    ReviewedClientsDTO reviewedClientsDTO=new ReviewedClientsDTO(e.getDate(),e.getPatient().getName(),e.getPatient().getSurname(),e.getStartTime(),e.getEndTime());
                    reviewedClientsDTOS.add(reviewedClientsDTO);
                }

            }
        }
        return  reviewedClientsDTOS;

    }
    @Override
    public void update(Pharmacist pharmacist) {
        Pharmacist pa = pharmacistRepository.getOne(pharmacist.getId());
        System.out.println("udje u update za farmacceuta ,proslo ime  je "+pa.getName());
        pa.setName(pharmacist.getName());
        pa.setSurname(pharmacist.getSurname());
        pa.setAddress(pharmacist.getAddress());
        pa.setCity(pharmacist.getCity());
        pa.setCountry(pharmacist.getCountry());
        pa.setPhoneNumber(pharmacist.getPhoneNumber());
        pa.setPassword(pharmacist.getPassword());
        pa.setEmail(pharmacist.getEmail());

        pharmacistRepository.save(pa);
    }

    @Override
    public void patientNotAppear(Integer idEx){
        Examination e=examinationRepository.getOne(idEx);
        Patient patient=patientRepository.getOne(e.getPatient().getId());
        e.setStatus(ExaminationStatus.EXPIRED);
        Integer penali= patient.getPenalty();
        patient.setPenalty(penali+1);
        examinationRepository.save(e);
        patientRepository.save(patient);
    }

    @Override
    public void updateFreeEx(ScheduleAnExaminationDTO scheduleAnExaminationDTO) {

        Patient patient=patientRepository.getOne(scheduleAnExaminationDTO.getIdPatient());
        Examination examination=examinationRepository.getExaminationsByParams(scheduleAnExaminationDTO.getDate(),scheduleAnExaminationDTO.getStartTime(),scheduleAnExaminationDTO.getEndTime(),scheduleAnExaminationDTO.getPrice(),scheduleAnExaminationDTO.getPharmacyName());
        examination.setPatient(patient);
        examination.setStatus(ExaminationStatus.SCHEDULED);
        examination.setScheduled(true);
        examinationRepository.save(examination);
        //dermatologistRepository.save(pa);
    }


    @Override
    public String delete(Pharmacist pharmacist) {// ne moze izbrisati farmaceute koji imaju zakazane preglede


        String message = "Pharmacist is not  deleted";
        if(examinationService.getExaminationByIdStaff(pharmacist.getId()).equals(false)){
            pharmacistRepository.delete(pharmacist);
            return  "Pharmacist is not  deleted";

        }

        for (Examination examination : examinationRepository.findAll()) {
            if (examination.getType().toString().equals("PHARMACIST_EXAMINATION") && examination.getStaff().getId().equals(pharmacist.getId()) && !examination.getScheduled()) {
                pharmacistRepository.delete(pharmacist);

                for (WorkTime workTimePharmacist : workTimeRepository.findAll()) {
                    if (workTimePharmacist.getStaff().getId().equals(pharmacist.getId())) {
                        workTimeRepository.delete(workTimePharmacist);

                    }
                }
                message = "Pharmacist is successfully deleted";
            }


        }
        return message;


    }

    @Override
    public Pharmacist findById(Integer id) {
        System.out.println("farmaceut id :"+id);
        //User user=userRepository.getOne(id);
        //System.out.println("ovdje uslo sada aaaaa:"+user.getName());
        Pharmacist pharmacist=pharmacistRepository.getOne(id);
        return pharmacist;
    }




    @Override
    public List<Pharmacist> findAll() {

        return pharmacistRepository.findAll();
    }


    @Override
    public Pharmacist save(PharmaceutDTO dto) {
        Pharmacist d = new Pharmacist();
        d.setName(dto.getName());
        d.setSurname(dto.getSurname());
        d.setEmail(dto.getEmail());
        d.setPassword(null);
        d.setAddress(dto.getAddress());
        d.setPhoneNumber(dto.getPhoneNumber());
        d.setCity(dto.getCity());
        d.setCountry(dto.getCountry());
        d.setAvgGrade(0.0);
        d.setVacation(null);
        d.setWorkTime(dto.getWorkTime());
        d.setExaminations(null);
        d.setPharmacy(dto.getPharmacy());

        return pharmacistRepository.save(d);
    }
/*
    @Override
    public String delete(Pharmacist pharmacist) {



        for(Examination examination : examinationRepository.findAll()){

            if(examination.getType().equals("PHARMACIST_EXAMINATION") && examination.getStaff().getId() == pharmacist.getId() && !examination.getScheduled()){
                throw  new IllegalStateException("Pharmacist  has scheduled examination.");
            }
        }

        for(WorkTime workTimePharmacist : workTimeRepository.findAll()){
            if(workTimePharmacist.getStaff().getId()== pharmacist.getId()){
                workTimeRepository.delete(workTimePharmacist);
            }
        }
        pharmacistRepository.delete(pharmacist);
        return  "Pharmacist is successfully deleted";
    }
*/

    @Override
    public  Pharmacist create(PharmacistForCreateDTO p){
        Pharmacist pharmacist=new Pharmacist();
        pharmacist.setAddress(p.getAddress());
        pharmacist.setAvgGrade(0.0);
        pharmacist.setCountry(p.getCountry());
        pharmacist.setPhoneNumber(p.getCity());
        pharmacist.setPassword(p.getPassword());
        pharmacist.setCity(p.getCity());

        pharmacist.setEmail(p.getEmail());
        pharmacist.setName(p.getName());
        pharmacist.setSurname(p.getSurname());
        pharmacist.setAccountEnabled(true);

        Pharmacy pharmacy=pharmacyRepository.getOne(p.getIdPharmacy());
        pharmacist.setPharmacy(pharmacy);
        Pharmacist created=pharmacistRepository.save(pharmacist);
        Staff staff=staffRepository.getOne(created.getId());

        WorkTime workTime=new WorkTime();
        workTime.setStartTime(p.getStartTime());
        workTime.setEndTime(p.getEndTime());
        workTime.setDate(p.getDate());
        workTime.setPharmacy(pharmacy);
        workTime.setStaff(staff);
        WorkTime workcreated=workTimeRepository.save(workTime);
      //  pharmacist.setWorkTime(workcreated);

        return pharmacist;

    }

}
