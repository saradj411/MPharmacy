package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.PharmacyDTO;
import com.isaProject.isa.Model.DTO.StaffDTO;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import com.isaProject.isa.Repositories.DermatologistRepository;
import com.isaProject.isa.Repositories.PharmacistRepository;
import com.isaProject.isa.Repositories.PharmacyRepository;
import com.isaProject.isa.Services.IServices.IPharmacyService;
import lombok.extern.slf4j.Slf4j;
import lombok.var;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Optional;

@Service
@Slf4j
public class PharmacyService implements IPharmacyService {

    @Autowired
    PharmacyRepository pharmacyRepository;

    @Autowired
    PharmacyAdminService pharmacyAdminService;

    @Autowired
    PharmacistRepository pharmacistRepository;

    @Autowired
    DermatologistRepository dermatologistRepository;
    @Override
    public List<Pharmacy> findAllOrderByNameAsc() {

        return pharmacyRepository.findAllOrderByNameAsc(Sort.by("name").ascending());
    }
    @Override
    public List<Pharmacy> findAllOrderByNameDesc() {

        return pharmacyRepository.findAllOrderByNameAsc(Sort.by("name").descending());
    }

    @Override
    public Pharmacy findById(Integer id) {
        //veki skontalaaa
        Pharmacy pharm = pharmacyRepository.findOneByIdPharm(id);
        return pharm;
    }
    @Override
    public List<Pharmacy> findByName(String name) {
        //veki skontalaaa
        return pharmacyRepository.findOneByName(name);

    }


    @Override
    public Pharmacy findByNamee(String name) {
            return pharmacyRepository.findOneByNamee(name);
    }

    @Override
    public Pharmacy pronadjiPoImenu(String name){
        List<Pharmacy>listOfPharm=pharmacyRepository.findAll();
        Pharmacy pharmacy=new Pharmacy();
        for (Pharmacy p:listOfPharm){
            if(p.getName().equals(name)){
                pharmacy=p;
            }
        }
        return pharmacy;
    }


    @Override
    public List<Pharmacy> findByAddress(String city) {
        return pharmacyRepository.findOneByAddress(city);
    }

    @Override
    public List<Pharmacy> findAll() {

        return pharmacyRepository.findAll();
    }

    @Override
    public Pharmacy save(PharmacyDTO pharmacyDTO) {
        System.out.println("Usao u pharmacy servis");
        System.out.println(pharmacyDTO);

        Pharmacy pharmacy = new Pharmacy();
        pharmacy.setName(pharmacyDTO.getName());
        pharmacy.setAddress(pharmacyDTO.getAddress());
        pharmacy.setCity(pharmacyDTO.getCity());
        pharmacy.setCountry(pharmacyDTO.getCountry());
        pharmacy.setDescription(pharmacyDTO.getDescription());
        pharmacy.setAvgGrade(pharmacyDTO.getAvgGrade());

        PharmacyAdmin pharmacyAdmin = pharmacyAdminService.findById(pharmacyDTO.getIdPharmacyAdmin());
        HashSet<PharmacyAdmin> pAdmin = new HashSet<>();
        pAdmin.add(pharmacyAdmin);
        pharmacy.setPharmacyAdmins(pAdmin);

        pharmacyRepository.save(pharmacy);

        pharmacyAdmin.setPharmacy(pharmacy);
        pharmacyAdminService.update(pharmacyAdmin);
        return pharmacy;
    }

    @Override
    public void update(Pharmacy pharmacy) {
        Pharmacy pharm = pharmacyRepository.getOne(pharmacy.getIdPharm());
        Integer ids=pharm.getIdPharm();

        pharm.setName(pharmacy.getName());
        pharm.setDescription(pharmacy.getDescription());
        pharm.setAddress(pharmacy.getAddress());
        pharm.setAvgGrade(pharmacy.getAvgGrade());

        pharmacyRepository.save(pharm);

        }

        @Override
    public double getAvgGrade(Integer idPharm){
        Pharmacy pharmacy=pharmacyRepository.getOne(idPharm);
        return pharmacy.getAvgGrade();
        }

        @Override
        public List<StaffDTO>view(Integer idPharm){
        List<Pharmacist>p=pharmacistRepository.findWorkTimeByIdDermAndIdPharm(idPharm);
        List<StaffDTO>staffDTOS=new ArrayList<>();
        for (Pharmacist pharmacist:p){
            StaffDTO s=new StaffDTO(pharmacist.getName(),pharmacist.getSurname(),pharmacist.getAvgGrade());
            staffDTOS.add(s);
        }
        return  staffDTOS;
        }

        @Override
       public List<StaffDTO>viewDerm(Integer idPharm){
        List<Dermatologist>lista=dermatologistRepository.findAll();
        List<StaffDTO>staffDTOS=new ArrayList<>();

        for (Dermatologist dermatologist:lista){
            for (Pharmacy p:dermatologist.getPharmacies()){
                if (p.getIdPharm().equals(idPharm)){
                    StaffDTO s=new StaffDTO(dermatologist.getName(),dermatologist.getSurname(),dermatologist.getAvgGrade());
                    staffDTOS.add(s);
                }
            }
        }
        return staffDTOS;

        }






}

