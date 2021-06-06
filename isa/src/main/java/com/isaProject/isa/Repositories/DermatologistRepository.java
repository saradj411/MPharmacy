package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.Pharmacist;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import java.util.List;

@EnableJpaRepositories
public interface DermatologistRepository  extends JpaRepository<Dermatologist, Integer> {



}
