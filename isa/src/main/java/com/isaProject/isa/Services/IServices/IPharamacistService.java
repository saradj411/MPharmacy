package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;

import java.util.List;

public interface IPharamacistService {
    Pharmacist findById(Integer id);
    List<Pharmacist> findAll ();
}
