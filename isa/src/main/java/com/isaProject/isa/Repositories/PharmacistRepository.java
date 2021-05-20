package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacistRepository  extends JpaRepository<Pharmacist, Integer> {
}
