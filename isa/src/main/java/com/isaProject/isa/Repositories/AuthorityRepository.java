package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Users.Authority;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorityRepository extends JpaRepository<Authority, Integer> {
    Authority findByName(String name);

}
