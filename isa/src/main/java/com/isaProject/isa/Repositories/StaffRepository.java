package com.isaProject.isa.Repositories;


import com.isaProject.isa.Model.Users.Staff;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface StaffRepository  extends JpaRepository<Staff, Integer> {





}
