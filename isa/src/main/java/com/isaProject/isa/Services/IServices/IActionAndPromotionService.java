package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.ActionAndPromotionDTO;
import com.isaProject.isa.Model.Users.ActionAndPromotion;

import javax.mail.MessagingException;

public interface IActionAndPromotionService {
    ActionAndPromotion save(ActionAndPromotionDTO dto);

    void sendMail(ActionAndPromotion actionAndPromotion) throws MessagingException;
}
