package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpecificationRepository extends JpaRepository<Specification, Integer> {

}
