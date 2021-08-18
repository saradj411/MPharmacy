package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.ComplainDTO;
import com.isaProject.isa.Model.Pharmacy.Complaint;
import com.isaProject.isa.Model.Pharmacy.PharmacyComplaint;
import com.isaProject.isa.Model.Pharmacy.StaffComplaint;
import com.isaProject.isa.Repositories.ComplainRepository;
import com.isaProject.isa.Repositories.StaffComplaintRepository;
import com.isaProject.isa.Services.IServices.IComplainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplainService implements IComplainService {

    @Autowired
    ComplainRepository complainRepository;
    @Autowired
    PatientService patientService;
    @Autowired
    PharmacyService pharmacyService;
    @Autowired
    StaffService staffService;
    @Autowired
    StaffComplaintRepository staffComplaintRepository;
    @Override
    public Complaint findById(Integer id) {
       return  complainRepository.findByIdComplaint(id);
    }

    @Override
    public Complaint save(ComplainDTO complainDTO) {

        if(complainDTO.getIdPharmacy()!= null)
        {
            PharmacyComplaint pComplaint = new PharmacyComplaint();
            pComplaint.setText(complainDTO.getText());
            pComplaint.setPatient(patientService.findById(complainDTO.getIdPatient()));
            pComplaint.setPharmacy(pharmacyService.findById(complainDTO.getIdPharmacy()));
            complainRepository.save(pComplaint);
            return pComplaint;

        }
        else
        {
            StaffComplaint staffComplaint = new StaffComplaint();
            staffComplaint.setText(complainDTO.getText());
            staffComplaint.setPatient(patientService.findById(complainDTO.getIdPatient()));
            staffComplaint.setStaff(staffService.findById(complainDTO.getIdStaff()));
            complainRepository.save(staffComplaint);
            return  staffComplaint;

        }
    }

    @Override
    public List<Complaint> findAll() {
        return  complainRepository.findAll();
    }

    @Override
    public List<StaffComplaint> findAllStaff() {
        return staffComplaintRepository.findAll();
    }


}
