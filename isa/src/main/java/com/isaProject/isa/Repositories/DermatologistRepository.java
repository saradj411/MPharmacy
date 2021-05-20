package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Users.Dermatologist;
import com.isaProject.isa.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DermatologistRepository  extends JpaRepository<Dermatologist, Integer> {

}
