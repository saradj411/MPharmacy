package com.isaProject.isa.Services.IServices;


import com.isaProject.isa.Model.DTO.ComplainDTO;
import com.isaProject.isa.Model.Pharmacy.Complaint;

public interface IComplainService {

    Complaint findById(Integer id);
    Complaint save(ComplainDTO complainDTO);
}
