package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.Specification;
import com.isaProject.isa.Model.Pharmacy.StaffComplaint;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StaffComplaintRepository extends JpaRepository<StaffComplaint, Integer> {
}
