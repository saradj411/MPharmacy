package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DefiningFreeTermsWithDermatologist;
import com.isaProject.isa.Model.DTO.PharmacyAdminDTO;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Examination.ExaminationStatus;
import com.isaProject.isa.Model.Examination.ExaminationType;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import com.isaProject.isa.Model.Users.WorkTime;
import com.isaProject.isa.Repositories.ExaminationRepository;
import com.isaProject.isa.Repositories.PharmacyAdminRepository;
import com.isaProject.isa.Repositories.WorkTimeRepository;
import com.isaProject.isa.Model.Users.Authority;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Repositories.UserRepository;
import com.isaProject.isa.Services.IServices.IPharmacyAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PharmacyAdminService implements IPharmacyAdminService {

    @Autowired
     PharmacyAdminRepository pharmacyAdminRepository;
    @Autowired
     PasswordEncoder passwordEncoder;
    @Autowired
     PharmacyService pharmacyService;

    @Autowired
     DermatologistService dermatologistService;

    @Autowired
     WorkTimeService workTimeService;

    @Autowired
     WorkTimeRepository workTimeRepository;

    @Autowired
    ExaminationRepository examinationRepository;

    @Autowired
    AuthorityService authorityService;
    @Autowired
    UserRepository userRepository;

    @Override
    public PharmacyAdmin findById(Integer id) {
        PharmacyAdmin pa = pharmacyAdminRepository.findOneById(id);
        return pa;
    }

    @Override
    public PharmacyAdmin findByName(String name) {
        return null;
    }

    @Override
    public List<PharmacyAdmin> findAll() {
        return pharmacyAdminRepository.findAll();
    }

    @Override
    public PharmacyAdmin save(PharmacyAdminDTO pharmacyAdminDTO) {

        System.out.println("Usao u pharmacy admin service!");
        List<Authority> auth = authorityService.findByname("ROLE_PHARMACY_ADMIN");
        for(User d : userRepository.findAll())
        {
            if(d.getEmail().equals(pharmacyAdminDTO.getEmail())) {
                System.out.println("Pronasao usera sa istim email.");
                return null;
            }
        }

        PharmacyAdmin pa = new PharmacyAdmin();
        pa.setName(pharmacyAdminDTO.getName());
        pa.setSurname(pharmacyAdminDTO.getSurname());
        pa.setEmail(pharmacyAdminDTO.getEmail());
        pa.setPassword(passwordEncoder.encode("123"));
        pa.setAddress(pharmacyAdminDTO.getAddress());
        pa.setCity(pharmacyAdminDTO.getCity());
        pa.setCountry(pharmacyAdminDTO.getCountry());
        pa.setPhoneNumber(pharmacyAdminDTO.getPhoneNumber());
        pa.setAuthorities(auth);
        pa.setAccountEnabled(false);

        if(pharmacyAdminDTO.getIdPharm()!=null)
        {
            Pharmacy p=pharmacyService.findById(pharmacyAdminDTO.getIdPharm());
            pa.setPharmacy(p);
        }
        pharmacyAdminRepository.save(pa);
        return pa;
    }


    @Override
    public void update1(PharmacyAdmin pharmacyAdmin) {
        PharmacyAdmin pa = pharmacyAdminRepository.getOne(pharmacyAdmin.getId());
        pa.setName(pharmacyAdmin.getName());
        pa.setSurname(pharmacyAdmin.getSurname());
        pa.setAddress(pharmacyAdmin.getAddress());
        pa.setCity(pharmacyAdmin.getCity());
        pa.setCountry(pharmacyAdmin.getCountry());
        pa.setPhoneNumber(pharmacyAdmin.getPhoneNumber());
        pa.setPassword(pharmacyAdmin.getPassword());
        pa.setEmail(pharmacyAdmin.getEmail());
        //pa.setPharmacy(pd.getPharmacy());
        pharmacyAdminRepository.save(pa);

    }



    @Override
    public void update(PharmacyAdmin pharmacyAdmin) {

        PharmacyAdmin pa = pharmacyAdminRepository.getOne(pharmacyAdmin.getId());
        pa.setName(pharmacyAdmin.getName());
        pa.setSurname(pharmacyAdmin.getSurname());
        pa.setAddress(pharmacyAdmin.getAddress());
        pa.setCity(pharmacyAdmin.getCity());
        pa.setCountry(pharmacyAdmin.getCountry());
        pa.setPhoneNumber(pharmacyAdmin.getPhoneNumber());
        pa.setPassword(pharmacyAdmin.getPassword());
        pa.setEmail(pharmacyAdmin.getEmail());
        pa.setPharmacy(pharmacyAdmin.getPharmacy());
        pharmacyAdminRepository.save(pa);
    }

    /*

    Svaki dermatolog ima radno vreme za svaku apoteku posebno. Administrator
apoteke definiše preglede kod dermatologa u terminu kada je dermatolog u
apoteci. Za svaki pregled potrebno je definisati datum i vreme početka pregleda,
trajanje pregleda i cenu. U radnom kalendaru dermatologa nalaze se pregledi
koji su unapred definisani.


     */
   public Examination definingFreeTermsWithDermatologist(DefiningFreeTermsWithDermatologist definingFreeTermsWithDermatologist){

    Dermatologist dermatologist=dermatologistService.findById(definingFreeTermsWithDermatologist.getIdDerm());
    Pharmacy pharmacy=pharmacyService.findByNamee(definingFreeTermsWithDermatologist.getPharmName());
    WorkTime workTime=workTimeService.findByUserId(dermatologist.getId());
    //mozda ispisati na frontu kada je njegovo radno vrijeme u toj apoteci nmp
       List<WorkTime> workTimes=workTimeRepository.findWorkTimeByIdDermAndIdPharm(definingFreeTermsWithDermatologist.getIdDerm(),pharmacy.getIdPharm());

       if(dermatologistService.checkingThatTheScheduleMatches(workTimes,definingFreeTermsWithDermatologist.getDate(), definingFreeTermsWithDermatologist.getStartTime(),definingFreeTermsWithDermatologist.getEndTime())){
           throw new IllegalArgumentException("TheScheduleNotMatches");
       }

       //provjera da li se poklapa sa radnim vremenom

       Examination examination=new Examination();
       examination.setStatus(ExaminationStatus.CREATED);
       examination.setDate(definingFreeTermsWithDermatologist.getDate());
       examination.setStartTime(definingFreeTermsWithDermatologist.getStartTime());
       examination.setEndTime(definingFreeTermsWithDermatologist.getEndTime());
       examination.setPharmacy(pharmacy);
       examination.setPrice(definingFreeTermsWithDermatologist.getPrice());
       examination.setType(ExaminationType.DERMATOLOGIST_EXAMINATION);
       examination.setStaff(dermatologist);
       return examinationRepository.save(examination);

       //da li se treba ovo ostalo na null stavljati ???




   }
}
