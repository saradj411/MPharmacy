package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Users.PharmacyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyAdminRepository extends JpaRepository<PharmacyAdmin, Integer> {

    PharmacyAdmin findOneByIdUser(Integer idUser);
}
