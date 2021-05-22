package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Users.Pharmacist;
import com.isaProject.isa.Model.Users.Staff;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Repositories.DrugRepository;
import com.isaProject.isa.Repositories.StaffRepository;
import com.isaProject.isa.Repositories.UserRepository;
import com.isaProject.isa.Services.IServices.IStaffService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class StaffService implements IStaffService {

    @Autowired
    StaffRepository staffRepository;


    @Override
    public Staff findById(Integer id) {
        //veki skontalaaa
        Staff pharmacist=staffRepository.findById(id).get();
        return pharmacist;
    }



}
