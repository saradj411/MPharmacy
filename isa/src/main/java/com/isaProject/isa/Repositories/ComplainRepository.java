package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Pharmacy.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ComplainRepository extends JpaRepository<Complaint,Integer> {
    Complaint findByIdComplaint(Integer id);
}
