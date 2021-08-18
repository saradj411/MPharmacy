package com.isaProject.isa.Services.IServices;


import com.isaProject.isa.Model.DTO.ComplainDTO;
import com.isaProject.isa.Model.Pharmacy.Complaint;
import com.isaProject.isa.Model.Pharmacy.StaffComplaint;

import java.util.List;

public interface IComplainService {

    Complaint findById(Integer id);
    Complaint save(ComplainDTO complainDTO);
    List<Complaint> findAll();
    List<StaffComplaint> findAllStaff();
}
