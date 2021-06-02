package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.DTO.FrontERecipeDTO;
import com.isaProject.isa.Model.Drugs.ERecipe;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

public interface IERecipeService {
    List<FrontERecipeDTO> findByPatient(Integer id);
}
