package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.LoyalityProgramDTO;
import com.isaProject.isa.Model.Examination.Examination;
import com.isaProject.isa.Model.Users.LoyalityProgram;

import java.util.List;

public interface ILoyalityProgramService {
    List<LoyalityProgram> findAll ();
    LoyalityProgram save(LoyalityProgramDTO loyalityProgramDTO);
}
