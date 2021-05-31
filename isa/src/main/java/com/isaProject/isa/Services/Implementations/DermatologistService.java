package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.*;
import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.Ingredient;
import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Model.DTO.DermatologistDTO;
import com.isaProject.isa.Model.DTO.PatientDTO;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Model.Examination.Therapy;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Model.Users.WorkTime;
import com.isaProject.isa.Repositories.DermatologistRepository;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Repositories.PatientRepository;
import com.isaProject.isa.Repositories.WorkTimeRepository;
import com.isaProject.isa.Services.IServices.IDermatologistService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class DermatologistService implements IDermatologistService, Serializable {


   //s private static final Logger log = org.slf4j.LoggerFactory.getLogger(DermatologistService.class);
    public @Autowired
    DermatologistRepository dermatologistRepository;

    public @Autowired
    WorkTimeRepository workTimeRepository;

    public @Autowired
    PatientRepository patientRepository;

    public @Autowired
    ExaminationRepository examinationRepository;

    public @Autowired
    ExaminationService examinationService;

    public @Autowired
    PharmacyService pharmacyService;

    Set<WorkTime> tajm = new HashSet<WorkTime>();

    Set<Pharmacy> pharmOfDerm = new HashSet<Pharmacy>();

    public @Autowired
    StaffRepository staffRepository;

    public @Autowired
    SpecificationRepository specificationRepository;

    public @Autowired
    DrugRepository drugRepository;

    public @Autowired
    SpecificationService specificationService;

    @Override
    public void update(Dermatologist dermatologist) {
        Dermatologist pa = dermatologistRepository.getOne(dermatologist.getId());
        pa.setName(dermatologist.getName());
        pa.setSurname(dermatologist.getSurname());
        pa.setAddress(dermatologist.getAddress());
        pa.setCity(dermatologist.getCity());
        pa.setCountry(dermatologist.getCountry());
        pa.setPhoneNumber(dermatologist.getPhoneNumber());
        pa.setPassword(dermatologist.getPassword());
        pa.setEmail(dermatologist.getEmail());
        dermatologistRepository.save(pa);
    }



    @Override
    public String delete(Dermatologist dermatologist) {
        String message = "Dermatoloist is not deleted!";


        if(examinationService.getExaminationByIdStaff(dermatologist.getId()).equals(false)){
            dermatologistRepository.delete(dermatologist);
            return  "Dermatoloist is  deleted!";

        }
        for (Examination examination : examinationRepository.findAll()) {
            if (examination.getScheduled()){

            }else {
                if(examination.getStaff().getId()==dermatologist.getId()){
                    if(examination.getType().equals(ExaminationType.DERMATOLOGIST_EXAMINATION)){
                        dermatologistRepository.delete(dermatologist);

                        for (WorkTime workTimeDermatologist : workTimeRepository.findAll()) {
                            if (workTimeDermatologist.getStaff().getId() == dermatologist.getId()) {
                                workTimeRepository.delete(workTimeDermatologist);

                            }
                        }
                        message = "Dermatoloist is deleted!";

                    }
                }
            }




        }


        return message;


    }



    @Override
    public Dermatologist findById(Integer id) {
        //veki skontalaaa
        Dermatologist dermatologist=dermatologistRepository.findById(id).get();
        return dermatologist;
    }

    @Override
    public List<Dermatologist> findAll() {

        return dermatologistRepository.findAll();
    }


    @Override
    public Set<PatientDTO> findAllPatients(Integer id) {
        /*//proslijedim id dermatologa
        List<Examination> examinations=examinationRepository.findAll();
        List<Patient> patients=new ArrayList<>();
        for (Examination e:examinations){
            if(e.getStaff().getIdUser().equals(id)){
                System.out.println("Pacijent je :" +e.getPatient().getName());
                //nasla pregled proslijedjenog dermatologa
                patients.add(e.getPatient());
            }
        }
        return patients;*/
        Set<PatientDTO> patients=new HashSet<>();

        List<Examination>list=examinationRepository.find(id);

        System.out.println("Stampa id "+id);
        for(Examination l:list){
            System.out.println("Pacijent je "+ l.getPatient().getName());
            PatientDTO p=new PatientDTO(l.getPatient().getId(),l.getPatient().getEmail(),l.getPatient().getName(),l.getPatient().getSurname(),
                   l.getPatient().getPhoneNumber() );
            patients.add(p);
        }
        return  patients;

    }


    @Override
    public Dermatologist save(DermatologistDTO dermatologist) {
        Dermatologist d = new Dermatologist();
        d.setName(dermatologist.getName());
        d.setSurname(dermatologist.getSurname());
        d.setEmail(dermatologist.getSurname());
        d.setPassword(dermatologist.getPassword());
        d.setAddress(dermatologist.getPhoneNumber());
        d.setPhoneNumber(dermatologist.getPhoneNumber());
        d.setCity(dermatologist.getCity());
        d.setCountry(dermatologist.getCountry());
        d.setAvgGrade(dermatologist.getAvgGrade());
        d.setWorkTime(null);
        d.setExaminations(null);
        d.setVacation(null);
        pharmOfDerm.add(dermatologist.getPharmacy());
        d.setPharmacies(pharmOfDerm);
        return dermatologistRepository.save(d);
    }

/*
    Dermatolog za korisnika za kojeg trenutno izvršava pregled bira jedan od
    unapred definisanih pregleda(znaci u Examination imamo status CREATED) ili bira datum i satnicu za novi pregled. Satnicamora da se poklapa sa radnim vremenom dermatologa u apoteci u kojoj se
    pregled izvršava. Termin pregleda ne sme da se preklapa sa drugim pregledom
    ili savetovanjem koje pacijent ima zakazano (u bilo kojoj apoteci), kao ni sa
    drugim pregledom koji dermatolog ima zakazan. Dermatolog pacijentu može da
    zakaže pregled samo u istoj apoteci u kojoj se pregled izvršava. Nakon
    zakazivanja pregleda, pacijentu se šalje mail o potvrdi i pregled se dodaje u listu
    budućih pregleda kojoj korisnik pristupa sa svog profila. Pregled se dodaje i u
    radni kalendar dermatologa.




*/

    //uzmi sve unaprijed krirane pregglede kod dermatologa

    public List<Examination>getAllFreeExaminations(Integer idDeratolog,Integer idPharmacy){
        List<Examination>examinations=examinationService.getExaminationsByIdStaffAndIdPharmacy(idDeratolog);
        return examinations;
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
    public void scheduleEx() {

    }

    /*

    bira datum i satnicu za novi pregled. Satnicamora da se poklapa sa radnim vremenom dermatologa u apoteci
     u kojoj se
pregled izvršava. Termin pregleda ne sme da se preklapa sa drugim pregledom
ili savetovanjem koje pacijent ima zakazano (u bilo kojoj apoteci), kao ni sa
drugim pregledom koji dermatolog ima zakazan. Dermatolog pacijentu može da
zakaže pregled samo u istoj apoteci u kojoj se pregled izvršava. Nakon
zakazivanja pregleda, pacijentu se šalje mail o potvrdi i pregled se dodaje u listu
budućih pregleda kojoj korisnik pristupa sa svog profila. Pregled se dodaje i u radni kalendar derm
     */



    @Override
    public boolean checkingThatTheScheduleMatches(List<WorkTime> list, LocalDate date, LocalTime start, LocalTime end){

        boolean check=false;
        for (WorkTime w:list){
            if (w.getDate().equals(date)){
                if(w.getStartTime().isBefore(start)  || w.getStartTime().equals(start)){
                    if (end.isBefore(end)){
                        System.out.println("Vrijeme se poklapa sa radnim vremenom derm laajk/");
                        check=true;
                    }
                }
            }
        }
        return check;
    }


    @Override
    public void  scheduleEx(LocalDate date, LocalTime start, LocalTime end, String name, Integer idDerm, Integer idPharm, Integer idPatient, double price){
      /*  Satnicamora da se poklapa sa radnim vremenom dermatologa u apoteci u kojoj se
        pregled izvršava

       */
        Pharmacy pharmacy=pharmacyService.findByNamee(name);


        List<WorkTime> workTimes=workTimeRepository.findWorkTimeByIdDermAndIdPharm(idDerm,pharmacy.getIdPharm());




            if(checkingThatTheScheduleMatches(workTimes,date, start,end)){
                throw new IllegalArgumentException("TheScheduleNotMatches");
        }
            List<Examination>listOfEx=examinationRepository.find(idDerm);

            List<WorkTime>workTimes1=workTimeRepository.listaWorkTime(date,start,end);
            List<WorkTime>finaList=new ArrayList<WorkTime>();

            for (WorkTime w:workTimes1){
                if(w.getStaff().getIdUser().equals(idDerm)){
                    finaList.add(w);
                }
            }

            /*
            kao ni sa
drugim pregledom koji dermatolog ima zakazan.

             */

            if (finaList.size()!=0){
                throw new IllegalArgumentException("Doctor have an appointment scheduled at that time ");
            }


            /*


            Termin pregleda ne sme da se preklapa sa drugim pregledom
ili savetovanjem koje pacijent ima zakazano (u bilo kojoj apoteci),

             */

        List<Examination>listExaminationOfAllPatient=examinationService.findAll();
        Patient patient=patientRepository.getOne(idPatient);
        List<Examination>listExaminationOfMyPatient=new ArrayList<>();
        Staff staff=staffRepository.getOne(idDerm);

        for (Examination e:listExaminationOfAllPatient){
            if(e.getPatient().equals(patient)){
                listExaminationOfMyPatient.add(e);
            }
        }

        if(listExaminationOfMyPatient.size()!=0){
            throw new IllegalArgumentException("Patient have an appointment scheduled at that time ");
        }
        Examination examination=new Examination();
        examination.setScheduled(true);
        examination.setStatus(ExaminationStatus.CREATED);
        examination.setCanceled(false);
        examination.setPatient(patient);
        examination.setDate(date);
        examination.setStartTime(start);
        examination.setEndTime(end);
        examination.setPharmacy(pharmacy);
        examination.setStaff(staff);
        examination.setType(ExaminationType.DERMATOLOGIST_EXAMINATION);
        examination.setPrice(price);
        examinationRepository.save(examination);


        //mejl o potvrdi











    }

    @Override
    public void patientNotAppear(Integer id){
        Patient patient=patientRepository.getOne(id);
        Integer penali= patient.getPenalty();
        patient.setPenalty(penali+1);
        patientRepository.save(patient);
    }

    @Override
    public void startExamination(CreateExaminationDTO createExaminationDTO){
        Examination examination=new Examination();
        examination.setReport(createExaminationDTO.getReport());

        Optional<Patient> patient=patientRepository.findById(createExaminationDTO.getIdPatient());
        Patient patient1=patient.get();

        for (TherapyDTO therapy:createExaminationDTO.getTherapy()){
            Drug d=therapy.getDrug();
            for (Drug alergDrug:patient1.getAllergies()){
                if(alergDrug.equals(d)){
                    throw new IllegalArgumentException("The patient is alaergic to that drug");
                }
            }



        }
        /*
        Pre nego što preporuči
        lek, dermatolog šalje upit za proveru dostupnosti leka. Tek ukoliko je lek
        dostupan u trenutnoj apoteci u kojoj izvršava pregled, lek se prepisuje pacijentu.

         */




    }



    /*
    . Dermatolog korisniku može da prepiše lek. Lek ne sme biti preporučen
pacijentu ukoliko je pacijent alergičan na njega. Dermatolog može da pristupi
specifikaciji leka i da definiše trajanje terapije u danima.
Ukoliko lek nije dostupan (nema ga na stanju u trenutnoj apoteci), sistem
automatski šalje notifikaciju administratoru apoteke, a dermatologu se pruža
mogućnost da pacijentu prepiše neki od zamenskih lekova (ukoliko pacijent nije
alergičan).
     */



    /*
    Dermatolog može da pristupi
specifikaciji leka
     */


}
