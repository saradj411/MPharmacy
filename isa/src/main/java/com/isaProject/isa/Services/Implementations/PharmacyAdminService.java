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
import com.isaProject.isa.Services.IServices.IPharmacyAdminService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class PharmacyAdminService implements IPharmacyAdminService {

    @Autowired
    PharmacyAdminRepository pharmacyAdminRepository;

    @Autowired
    private PharmacyService pharmacyService;

    @Autowired
    private DermatologistService dermatologistService;

    @Autowired
    private WorkTimeService workTimeService;

    @Autowired
    private WorkTimeRepository workTimeRepository;

    @Autowired
    ExaminationRepository examinationRepository;

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
        PharmacyAdmin pa = new PharmacyAdmin();
        pa.setName(pharmacyAdminDTO.getName());
        Pharmacy p=pharmacyService.findById(pharmacyAdminDTO.getIdPharm());
        pa.setPharmacy(p);
        pa.setAddress(pharmacyAdminDTO.getAddress());
        pa.setCity(pharmacyAdminDTO.getCity());
        pa.setCountry(pharmacyAdminDTO.getCountry());
        pa.setEmail(pharmacyAdminDTO.getEmail());
        pa.setPassword(pharmacyAdminDTO.getPassword());
        pa.setPhoneNumber(pharmacyAdminDTO.getPhoneNumber());
        pa.setSurname(pharmacyAdminDTO.getSurname());
        return pharmacyAdminRepository.save(pa);
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
