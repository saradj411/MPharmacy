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
import com.isaProject.isa.Model.Pharmacy.Complaint;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.*;

import com.isaProject.isa.Repositories.*;
import com.isaProject.isa.Services.IServices.IDermatologistService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.LocalTime;
import java.time.ZoneId;
import java.util.*;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
@Service
@Slf4j
public class DermatologistService implements IDermatologistService {

   //s private static final Logger log = org.slf4j.LoggerFactory.getLogger(DermatologistService.class);
     @Autowired
    DermatologistRepository dermatologistRepository;
    @Autowired
     PasswordEncoder passwordEncoder;
@Autowired
ServiceForEmail serviceForEmail;
    @Autowired
     AuthorityService authService;
     @Autowired
    WorkTimeRepository workTimeRepository;

     @Autowired
    PatientRepository patientRepository;

     @Autowired
    ExaminationRepository examinationRepository;

     @Autowired
    ExaminationService examinationService;

      @Autowired
    WorkTimeService workTimeService;

     @Autowired
    PharmacyService pharmacyService;


    Set<WorkTime> tajm = new HashSet<WorkTime>();

    Set<Pharmacy> pharmOfDerm = new HashSet<Pharmacy>();

     @Autowired
    StaffRepository staffRepository;



    @Autowired
    UserRepository userRepository;

     @Autowired
    SpecificationRepository specificationRepository;

     @Autowired
    DrugRepository drugRepository;

     @Autowired
    SpecificationService specificationService;
     @Autowired
    PharmacyRepository pharmacyRepository;
    @Override
    public Dermatologist create(DermatologistForCreateDTO dermatologistForCreateDTO){
        Dermatologist dermatologist=new Dermatologist();
        dermatologist.setAddress(dermatologistForCreateDTO.getAddress());
        dermatologist.setAvgGrade(0.0);
        dermatologist.setCountry(dermatologistForCreateDTO.getCountry());
        dermatologist.setPhoneNumber(dermatologistForCreateDTO.getCity());
        dermatologist.setPassword(dermatologistForCreateDTO.getPassword());
        dermatologist.setCity(dermatologistForCreateDTO.getCity());
        dermatologist.setEmail(dermatologistForCreateDTO.getEmail());
        dermatologist.setName(dermatologistForCreateDTO.getName());
        dermatologist.setSurname(dermatologistForCreateDTO.getSurname());
        dermatologist.setAccountEnabled(true);

        Pharmacy pharmacy=pharmacyRepository.getOne(dermatologistForCreateDTO.getIdPharmacy());
        Set<Pharmacy> p=new HashSet<>();
        p.add(pharmacy);
        dermatologist.setPharmacies(p);
        Dermatologist created=dermatologistRepository.save(dermatologist);
        Staff staff=staffRepository.getOne(created.getId());

        WorkTime workTime=new WorkTime();
        workTime.setStartTime(dermatologistForCreateDTO.getStartTime());
        workTime.setEndTime(dermatologistForCreateDTO.getEndTime());
        workTime.setDate(dermatologistForCreateDTO.getDate());
        workTime.setPharmacy(pharmacy);

        workTime.setStaff(staff);
        WorkTime workcreated=workTimeRepository.save(workTime);

        return dermatologist;

    }

     @Autowired
    RequestForVacationRepository requestForVacationRepository;

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

/*


(ukoliko
dermatolog ima zakazane preglede koje treba da održi, dermatolog se ne
može obrisati)

 */





    @Override
    public String delete(Dermatologist dermatologist, Integer idPharm) {
        String message = "";
        Staff staff=staffRepository.getOne(dermatologist.getId());
        Pharmacy p=pharmacyService.findById(idPharm);
        List<Examination>lista=examinationRepository.findAll();
        List<Examination>newList=new ArrayList<>();
        for (Examination e:lista){
            if (e.getScheduled().equals(true) &&e.getPharmacy().getIdPharm().equals(idPharm) && e.getStaff().getId().equals(dermatologist.getId())){
                newList.add(e);
            }
        }
        if (newList.size()==0){
            message="The dermatologist was not deleted because he has an appointment ";
        }else {
            //obrisi sve examinationse.
            for (Examination e:examinationRepository.findAll()) {
                if (e.getStaff().getId().equals(dermatologist.getId())) {
                    if (e.getDate().isAfter(LocalDate.now())) {
                        e.setPharmacy(null);
                        e.setPatient(null);
                        e.setStaff(null);

                        e.setPrice(0.0);
                        dermatologist.getExaminations().remove(e);
                        examinationRepository.delete(e);
                    }
                }
            }}
        dermatologist.getPharmacies().remove(p);
        dermatologistRepository.save(dermatologist);
        message="The dermatologist was deleted ";
        return message;
    }

    @Override
    public Dermatologist findById(Integer id) {
        Dermatologist dermatologist=dermatologistRepository.findById(id).get();
        return dermatologist;
    }

    @Override
    public List<Dermatologist> findAll() {
        return dermatologistRepository.findAll();
    }

    @Override
    public Dermatologist save(DermDTO dermDTO) throws MessagingException {
        System.out.println("Usao u servis");
        List<Authority> auth = authService.findByname("ROLE_DERMATOLOGIST");
        for(User d : userRepository.findAll())
        {
            if(d.getEmail().equals(dermDTO.getEmail())) {
                System.out.println("nasaoistog");
                return null;
            }
        }

        Dermatologist d = new Dermatologist();
        d.setName(dermDTO.getName());
        d.setSurname(dermDTO.getSurname());
        d.setEmail(dermDTO.getEmail());
        String pass = "123";
        d.setPassword(passwordEncoder.encode(pass));
        d.setAddress(dermDTO.getAddress());
        d.setPhoneNumber(dermDTO.getPhoneNumber());
        d.setCity(dermDTO.getCity());
        d.setCountry(dermDTO.getCountry());
        d.setAuthorities(auth);
        d.setAccountEnabled(false);

        d.setAvgGrade(dermDTO.getAvgGrade());
        serviceForEmail.sendRegistrationEmail(d.getEmail(), d.getName(), d.getSurname());
        Dermatologist newUser = dermatologistRepository.save(d);

        return newUser;
    }

    @Override
    public Set<PatientDTO> findAllPatients(Integer id) {
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

    public Dermatologist save(DermatologistDTO dermDTO) {
        System.out.println("Usao u servis");
        List<Authority> auth = authService.findByname("ROLE_DERMATOLOGIST");
        for(User d : userRepository.findAll())
        {
            if(d.getEmail().equals(dermDTO.getEmail())) {
                System.out.println("nasaoistog");
                return null;
            }
        }

        Dermatologist d = new Dermatologist();
        d.setName(dermDTO.getName());
        d.setSurname(dermDTO.getSurname());
        d.setEmail(dermDTO.getEmail());
        String pass = "123";
        d.setPassword(passwordEncoder.encode(pass));
        d.setAddress(dermDTO.getAddress());
        d.setPhoneNumber(dermDTO.getPhoneNumber());
        d.setCity(dermDTO.getCity());
        d.setCountry(dermDTO.getCountry());
        d.setAuthorities(auth);
        d.setAccountEnabled(false);

        d.setAvgGrade(dermDTO.getAvgGrade());

        User newUser = userRepository.save(d);
        return d;
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
                    if (end.isBefore(w.getEndTime())){
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



//da li se radno vrijeme poklapa
            if(!checkingThatTheScheduleMatches(workTimes,date, start,end)){
                throw new IllegalArgumentException("TheScheduleNotMatches");
        }
            List<Examination>listOfEx=examinationRepository.find(idDerm);

            /*List<WorkTime>workTimes1=workTimeRepository.listaWorkTime(date,start,end);
            List<WorkTime>finaList=new ArrayList<WorkTime>();

            for (WorkTime w:workTimes1){
                if(w.getStaff().getId().equals(idDerm)){
                    finaList.add(w);
                }
            }*/

            /*
            kao ni sa
drugim pregledom koji dermatolog ima zakazan.

             */
/*

            if (finaList.size()!=0){
                throw new IllegalArgumentException("Doctor have an appointment scheduled at that time ");
            }
*/


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
        /*Examination examination=new Examination();
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
*/
        //mejl o potvrdi

    }


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
    public Set<Pharmacy> pharmacies(Integer id){//id dermatologa
        Dermatologist d=dermatologistRepository.getOne(id);
        return  d.getPharmacies();

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
