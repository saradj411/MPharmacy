package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.DrugReservation;
import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Users.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ERecipeRepository extends JpaRepository<ERecipe, Integer> {
    List<ERecipe> findAllByPatient(Patient patient);

}
