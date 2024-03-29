package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.*;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.DTO.FrontCreatedExaminationDTO;

import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;

import com.isaProject.isa.Model.Pharmacy.Pharmacy;

import com.isaProject.isa.Model.Examination.Therapy;
import com.isaProject.isa.Model.Users.*;
import com.isaProject.isa.Repositories.*;

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
    DermatologistService dermatologistService;
    @Autowired
    DrugRepository drugRepository;
    @Autowired
    WorkTimeRepository workTimeRepository;
    @Autowired
    ExaminationService examinationService;

    @Autowired
    StaffRepository staffRepository;

    @Autowired
    ServiceForEmail serviceForEmail;

    @Autowired
    PharmacistRepository pharmacistRepository;

    @Autowired
    TherapyRepository therapyRepository;

    @Autowired
    RequestForVacationRepository requestForVacationRepository;
    @Autowired
    LoyalityProgramService loyalityProgramService;

    @Override
    public List<Examination> findAll() {
        return examinationRepository.findAll();
    }


    public List<Examination> findAllOverWithoutPoints() {

        List<Examination> overExamintaion = new ArrayList<Examination>();

        for (Examination e: examinationRepository.findAll()) {
            if(e.getStatus().equals(ExaminationStatus.FINISHED) && e.getPointsForExamination() == null)
                overExamintaion.add(e);
        }

        return overExamintaion;
    }

    public Examination savePointsFromExamination(ExamPointDTO examPoinDTO)
    {

        for (Examination e: findAllOverWithoutPoints()) {
            if(e.getIdExamination().equals(examPoinDTO.getIdExamination()))
            {
                if(e.getPointsForExamination() != null)
                    return null;
                e.setPointsForExamination(examPoinDTO.getPoints());
                addPointsToPatient(examPoinDTO, e);
                loyalityProgramService.changeStatusOfPatient(e.getPatient());
                examinationRepository.save(e);
                return e;
            }
        }
        return null;

    }

    private void addPointsToPatient(ExamPointDTO examPoinDTO, Examination e) {
        Integer points = e.getPatient().getPoints() + examPoinDTO.getPoints();
        e.getPatient().setPoints(points);
    }

    /*


    prilikom definisanja pregleda treba voditi računa da se
pregled ne preklapa sa već zakazanim. Pregled se ne može zakazati u
periodu kada je dermatolog na godišnjem odmoru ili odsustvu)

     */


    @Override
    public Examination defineTerms(ExaminationDTO examinationDTO) throws MessagingException {
        Examination d = new Examination();
        List<WorkTime> workTimes = workTimeRepository.findWorkTimeByIdDermAndIdPharm(examinationDTO.getIdStaff(), examinationDTO.getIdPharm());
        if (!dermatologistService.checkingThatTheScheduleMatches(workTimes, examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd())) {
            throw new IllegalArgumentException("TheScheduleNotMatches");

        }

        List<Examination> finaList = new ArrayList<Examination>();

        List<Examination> finaList2 = new ArrayList<Examination>();
        List<Examination> exx = examinationRepository.getExaminationsByTime(examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd());

        for (Examination e:exx){
            if (e.getStaff().getId().equals(examinationDTO.getIdStaff())){
                finaList.add(e);
            }
        }

        if (finaList.size()==0) {

        } else {
            throw new IllegalArgumentException("Doctor have an appointment scheduled at that time ");

        }

        List<RequestForVacation>requestForVacations=requestForVacationRepository.findAll();
        for (RequestForVacation r:requestForVacations){
            if(r.getStaff().getId().equals(examinationDTO.getIdStaff())){
                if (examinationDTO.getDate().isAfter(r.getStart())){
                    if (examinationDTO.getDate().isBefore(r.getEnd())){
                        throw new IllegalArgumentException("The doctor is on vacation ");

                    }

                }
            }
        }


        for (Examination e:exx){
            if (e.getPatient().getId().equals(examinationDTO.getIdPatient())){
                finaList2.add(e);
            }
        }

        if (finaList2.size()==0){

        }else{
            throw new IllegalArgumentException("Patient have an appointment scheduled at that time ");
        }




        d.setDate(examinationDTO.getDate());
        d.setEndTime(examinationDTO.getEnd());
        d.setStartTime(examinationDTO.getStart());
        d.setStaff(staffService.findById(examinationDTO.getIdStaff()));
        d.setPharmacy(pharmacyService.findById(examinationDTO.getIdPharm()));
        d.setPrice(examinationDTO.getPrice());
        d.setStatus(ExaminationStatus.CREATED);
        d.setType(ExaminationType.DERMATOLOGIST_EXAMINATION);
        return examinationRepository.save(d);
    }


    @Override
    public Examination createExD(ExaminationDTO examinationDTO) throws MessagingException {
        Examination d = new Examination();
        List<WorkTime> workTimes = workTimeRepository.findWorkTimeByIdDermAndIdPharm(examinationDTO.getIdStaff(), examinationDTO.getIdPharm());
        if (!dermatologistService.checkingThatTheScheduleMatches(workTimes, examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd())) {
            throw new IllegalArgumentException("TheScheduleNotMatches");
        }
        List<Examination> listOfEx = examinationRepository.find(examinationDTO.getIdStaff());

        // WorkTime workTimes1 = workTimeRepository.listaWorkTime(examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd());
        // System.out.println("EEEEEEEEEEEEEEE" + workTimes1.getStartTime());


        boolean check = true;
        List<Examination> finaList = new ArrayList<Examination>();

        List<Examination> finaList2 = new ArrayList<Examination>();
        List<Examination> exx = examinationRepository.getExaminationsByTime(examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd());

        for (Examination e:exx){
            if (e.getStaff().getId().equals(examinationDTO.getIdStaff())){
                finaList.add(e);
            }
        }





            /*
            kao ni sa
drugim pregledom koji dermatolog ima zakazan.

             */

        if (finaList.size()==0) {

        } else {
            throw new IllegalArgumentException("Doctor have an appointment scheduled at that time ");

        }


        //******************************************





           /*


            Termin pregleda ne sme da se preklapa sa drugim pregledom
ili savetovanjem koje pacijent ima zakazano (u bilo kojoj apoteci),

             */

        /*List<Examination>listExaminationOfAllPatient=examinationService.findAll();
        Patient patient=patientRepository.getOne(examinationDTO.getIdPatient());
        List<Examination>listExaminationOfMyPatient=new ArrayList<>();
        Staff staff=staffRepository.getOne(examinationDTO.getIdStaff());

        for (Examination e:listExaminationOfAllPatient){
            if(e.getPatient().equals(patient)){
                listExaminationOfMyPatient.add(e);
            }
        }

        if(listExaminationOfMyPatient.size()!=0){
            throw new IllegalArgumentException("Patient have an appointment scheduled at that time ");
        }*/

        for (Examination e:exx){
            if (e.getPatient().getId().equals(examinationDTO.getIdPatient())){
                finaList2.add(e);
            }
        }

        if (finaList2.size()==0){

        }else{
            throw new IllegalArgumentException("Patient have an appointment scheduled at that time ");
        }

        d.setDate(examinationDTO.getDate());
        d.setEndTime(examinationDTO.getEnd());
        d.setStartTime(examinationDTO.getStart());
        d.setStaff(staffService.findById(examinationDTO.getIdStaff()));
        System.out.println("APOTEKAAA "+examinationDTO.getName());
//        d.setPharmacy(pharmacyService.pronadjiPoImenu(examinationDTO.getName()));
        d.setPharmacy(pharmacyService.findById(examinationDTO.getIdPharm()));
        d.setPrice(examinationDTO.getPrice());
        d.setPatient(patientService.findById(examinationDTO.getIdPatient()));
        d.setStatus(ExaminationStatus.SCHEDULED);
        d.setType(ExaminationType.DERMATOLOGIST_EXAMINATION);
        //serviceForEmail.sendingAnEmailToInformPatientAboutExamination(examinationDTO);
        return examinationRepository.save(d);
    }


    /*public Examination findById(Integer id) {
        return examinationRepository.findOneByIdExamination(id);
    }*/





/*obrisano zbog gita
    public Examination save(ExaminationDTO examinationDTO) {
        Examination d = new Examination();
        List<WorkTime> workTimes = workTimeRepository.findWorkTimeByIdDermAndIdPharm(examinationDTO.getIdStaff(), examinationDTO.getIdPharm());
        if (!dermatologistService.checkingThatTheScheduleMatches(workTimes, examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd())) {
            throw new IllegalArgumentException("TheScheduleNotMatches");
        }
        List<Examination> listOfEx = examinationRepository.find(examinationDTO.getIdStaff());

        // WorkTime workTimes1 = workTimeRepository.listaWorkTime(examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd());
        // System.out.println("EEEEEEEEEEEEEEE" + workTimes1.getStartTime());


        boolean check = true;
        List<Examination> finaList = new ArrayList<Examination>();

        List<Examination> finaList2 = new ArrayList<Examination>();
        List<Examination> exx = examinationRepository.getExaminationsByTime(examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd());

        for (Examination e:exx){
            if (e.getStaff().getId().equals(examinationDTO.getIdStaff())){
                finaList.add(e);
            }
        }






            kao ni sa
drugim pregledom koji dermatolog ima zakazan.



        if (finaList.size()==0) {

        } else {
            throw new IllegalArgumentException("Doctor have an appointment scheduled at that time ");

        }










            Termin pregleda ne sme da se preklapa sa drugim pregledom
ili savetovanjem koje pacijent ima zakazano (u bilo kojoj apoteci),



        /*List<Examination>listExaminationOfAllPatient=examinationService.findAll();
        Patient patient=patientRepository.getOne(examinationDTO.getIdPatient());
        List<Examination>listExaminationOfMyPatient=new ArrayList<>();
        Staff staff=staffRepository.getOne(examinationDTO.getIdStaff());

        for (Examination e:listExaminationOfAllPatient){
            if(e.getPatient().equals(patient)){
                listExaminationOfMyPatient.add(e);
            }
        }

        if(listExaminationOfMyPatient.size()!=0){
            throw new IllegalArgumentException("Patient have an appointment scheduled at that time ");
        }

        for (Examination e:exx){
            if (e.getPatient().getId().equals(examinationDTO.getIdPatient())){
                finaList2.add(e);
            }
        }

        if (finaList2.size()==0){

        }else{
            throw new IllegalArgumentException("Patient have an appointment scheduled at that time ");
        }

        d.setDate(examinationDTO.getDate());
        d.setEndTime(examinationDTO.getEnd());
        d.setStartTime(examinationDTO.getStart());
        d.setStaff(staffService.findById(examinationDTO.getIdStaff()));
        System.out.println("APOTEKAAA "+examinationDTO.getName());
        d.setPharmacy(pharmacyService.pronadjiPoImenu(examinationDTO.getName()));
        d.setPharmacy(pharmacyService.findById(examinationDTO.getIdPharm()));
        d.setPrice(examinationDTO.getPrice());
        d.setPatient(patientService.findById(examinationDTO.getIdPatient()));
        d.setStatus(ExaminationStatus.CREATED);
        d.setType(ExaminationType.DERMATOLOGIST_EXAMINATION);
        serviceForEmail.sendingAnEmailToInformPatientAboutExamination(examinationDTO);
        return examinationRepository.save(d);
    }
    public Examination findById(Integer id) {
        return examinationRepository.findOneByIdExamination(id);
    }*/

    @Override
    public Examination finishExD(ExaminationFrontDTO examinationDTO,Integer id) {
        Examination d = examinationRepository.getOne(id);
        Drug drug=drugRepository.findOneByNameDrug(examinationDTO.getName());
        System.out.println(drug.getName());
        d.setDate(examinationDTO.getDate());
        d.setStaff(staffService.findById(examinationDTO.getIdStaff()));
        d.setPharmacy(pharmacyService.findById(examinationDTO.getIdPharm()));
        d.setPatient(patientService.findById(examinationDTO.getIdPatient()));
        d.setStatus(ExaminationStatus.FINISHED);
        d.setPrice(examinationDTO.getPrice());
        d.setType(ExaminationType.DERMATOLOGIST_EXAMINATION);
        d.setReport(examinationDTO.getReport());
        Therapy t=new Therapy(drug,examinationDTO.getNumberOfDay());
        d.setTherapy(t);

        therapyRepository.save(t);
        return examinationRepository.save(d);
    }
    @Override
    public Examination finishExP(ExaminationFrontDTO examinationDTO,Integer id) {
        Examination d = examinationRepository.getOne(id);
        Drug drug=drugRepository.findOneByNameDrug(examinationDTO.getName());
        System.out.println(drug.getName());
        d.setDate(examinationDTO.getDate());
        //d.setEndTime(examinationDTO.getEnd());
        //d.setStartTime(examinationDTO.getStart());
        d.setStaff(staffService.findById(examinationDTO.getIdStaff()));
        d.setPharmacy(pharmacyService.findById(examinationDTO.getIdPharm()));
        d.setPatient(patientService.findById(examinationDTO.getIdPatient()));
        d.setStatus(ExaminationStatus.FINISHED);
        d.setPrice(examinationDTO.getPrice());
        d.setType(ExaminationType.PHARMACIST_EXAMINATION);
        d.setReport(examinationDTO.getReport());
        Therapy t=new Therapy(drug,examinationDTO.getNumberOfDay());
        d.setTherapy(t);
        therapyRepository.save(t);
        return examinationRepository.save(d);
    }
    @Override
    public Examination createExP(ExaminationDTO examinationDTO) throws MessagingException {
        List<WorkTime> workTimes = workTimeRepository.findWorkTimeByIdDermAndIdPharm(examinationDTO.getIdStaff(), examinationDTO.getIdPharm());
        if (!dermatologistService.checkingThatTheScheduleMatches(workTimes, examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd())) {
            throw new IllegalArgumentException("TheScheduleNotMatches");
        }
        boolean check = true;
        List<Examination> finaList = new ArrayList<Examination>();
        List<Examination> finaList2 = new ArrayList<Examination>();
        List<Examination> exx = examinationRepository.getExaminationsByTime(examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd());
        for (Examination e:exx){
            if (e.getStaff().getId().equals(examinationDTO.getIdStaff())){
                finaList.add(e);
            }
        }

        if (finaList.size()==0) {

        } else {
            throw new IllegalArgumentException("Doctor have an appointment scheduled at that time ");

        }

        for (Examination e:exx){
            if (e.getPatient().getId().equals(examinationDTO.getIdPatient())){
                finaList2.add(e);
            }
        }

        if (finaList2.size()==0){

        }else{
            throw new IllegalArgumentException("Patient have an appointment scheduled at that time ");
        }
        Examination d = new Examination();
        d.setDate(examinationDTO.getDate());
        d.setEndTime(examinationDTO.getEnd());
        d.setStartTime(examinationDTO.getStart());
        d.setStaff(staffService.findById(examinationDTO.getIdStaff()));
        d.setPharmacy(pharmacyService.findById(examinationDTO.getIdPharm()));
        d.setPrice(examinationDTO.getPrice());
        d.setType(ExaminationType.PHARMACIST_EXAMINATION);
        d.setPatient(patientService.findById(examinationDTO.getIdPatient()));
        d.setStatus(ExaminationStatus.SCHEDULED);
        //serviceForEmail.sendingAnEmailToInformPatientAboutExamination(examinationDTO);
        return examinationRepository.save(d);

    }
    @Override
    public Examination save(ExaminationDTO examinationDTO) {

        List<WorkTime> workTimes = workTimeRepository.findWorkTimeByIdDermAndIdPharm(examinationDTO.getIdStaff(), pharmacyService.pronadjiPoImenu(examinationDTO.getName()).getIdPharm());
        if (!dermatologistService.checkingThatTheScheduleMatches(workTimes, examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd())) {
            throw new IllegalArgumentException("TheScheduleNotMatches");
        }
        boolean check = true;
        List<Examination> finaList = new ArrayList<Examination>();
        List<Examination> finaList2 = new ArrayList<Examination>();
        List<Examination> exx = examinationRepository.getExaminationsByTime(examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd());
        for (Examination e:exx){
            if (e.getStaff().getId().equals(examinationDTO.getIdStaff())){
                finaList.add(e);
            }
        }

        if (finaList.size()==0) {

        } else {
            throw new IllegalArgumentException("Doctor have an appointment scheduled at that time ");

        }

        for (Examination e:exx){
            if (e.getPatient().getId().equals(examinationDTO.getIdPatient())){
                finaList2.add(e);
            }
        }

        if (finaList2.size()==0){

        }else{
            throw new IllegalArgumentException("Patient have an appointment scheduled at that time ");
        }        Examination d = new Examination();
        System.out.println(pharmacyService.pronadjiPoImenu(examinationDTO.getName()));
        d.setPharmacy(pharmacyService.pronadjiPoImenu(examinationDTO.getName()));

        d.setDate(examinationDTO.getDate());
        d.setEndTime(examinationDTO.getEnd());
        d.setStartTime(examinationDTO.getStart());
        d.setStaff(staffService.findById(examinationDTO.getIdStaff()));
        d.setType(ExaminationType.DERMATOLOGIST_EXAMINATION);
        d.setPatient(patientService.findById(examinationDTO.getIdPatient()));
        d.setStatus(ExaminationStatus.SCHEDULED);
        //serviceForEmail.sendingAnEmailToInformPatientAboutExamination(examinationDTO);

        return examinationRepository.save(d);

    }
    
    @Override
    public Examination saveP(ExaminationDTO examinationDTO) throws MessagingException {
        Pharmacist s = pharmacistRepository.getOne(examinationDTO.getIdStaff());
        System.out.println("aaaa" + s.getPharmacy().getIdPharm());
        List<WorkTime> workTimes = workTimeRepository.findWorkTimeByIdDermAndIdPharm(examinationDTO.getIdStaff(), s.getPharmacy().getIdPharm());
        if (!dermatologistService.checkingThatTheScheduleMatches(workTimes, examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd())) {
            throw new IllegalArgumentException("TheScheduleNotMatches");
        }
        boolean check = true;
        List<Examination> finaList = new ArrayList<Examination>();
        List<Examination> finaList2 = new ArrayList<Examination>();
        List<Examination> exx = examinationRepository.getExaminationsByTime(examinationDTO.getDate(), examinationDTO.getStart(), examinationDTO.getEnd());
        for (Examination e : exx) {
            if (e.getStaff().getId().equals(examinationDTO.getIdStaff())) {
                finaList.add(e);
            }
        }

        if (finaList.size() == 0) {

        } else {
            throw new IllegalArgumentException("Doctor have an appointment scheduled at that time ");

        }

        for (Examination e : exx) {
            if (e.getPatient().getId().equals(examinationDTO.getIdPatient())) {
                finaList2.add(e);
            }
        }

        if (finaList2.size() == 0) {

        } else {
            throw new IllegalArgumentException("Patient have an appointment scheduled at that time ");
        }
        Examination d = new Examination();
        System.out.println(pharmacyService.pronadjiPoImenu(examinationDTO.getName()));
        d.setPharmacy(s.getPharmacy());

        d.setDate(examinationDTO.getDate());
        d.setEndTime(examinationDTO.getEnd());
        d.setStartTime(examinationDTO.getStart());
        d.setStaff(staffService.findById(examinationDTO.getIdStaff()));
        d.setType(ExaminationType.PHARMACIST_EXAMINATION);
        d.setPatient(patientService.findById(examinationDTO.getIdPatient()));
        d.setStatus(ExaminationStatus.SCHEDULED);
        //serviceForEmail.sendingAnEmailToInformPatientAboutExamination(examinationDTO);

        return examinationRepository.save(d);

    }



    @Override
    public Examination findById(Integer id) {
        //veki skontalaaa
        Examination examination=examinationRepository.findById(id).get();
        return examination;
    }


    @Override
        public void canceling(Integer id) {
            Examination pat = examinationRepository.getOne(id);


            pat.setCanceled(true);
            pat.setStatus(ExaminationStatus.CANCELED);


            examinationRepository.save(pat);
        }

    @Override
    public void patientCanceling(Integer examination) {
        System.out.println("EEEEEEEEEEEEEEE");

        Examination pat = examinationRepository.getOne(examination);

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
                if(e.getStatus().compareTo(ExaminationStatus.SCHEDULED)==0){
                    freeEx.add(e);
                }
            }
            //examinations
            return freeEx;
        }


        @Override
        public List<FrontCreatedExaminationDTO> findCreatedDermatologistExamination() {
            List<Examination> list=examinationRepository.findAll();
            List<FrontCreatedExaminationDTO> newList = new ArrayList<>();

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
            return newList;
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
            examination.setPrice(pharmacy.getConsultationPrice());
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

