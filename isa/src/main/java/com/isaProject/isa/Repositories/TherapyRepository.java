package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Examination.Therapy;
import com.isaProject.isa.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TherapyRepository extends JpaRepository<Therapy, Integer> {
}
