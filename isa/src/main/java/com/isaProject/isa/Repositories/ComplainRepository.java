package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Pharmacy.Complaint;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ComplainRepository extends JpaRepository<Complaint,Integer> {
    public Complaint findByIdComplaint(Integer id);
}
