package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Users.Supplier;
import com.isaProject.isa.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SupplierRepository extends JpaRepository<Supplier, Integer> {

}
