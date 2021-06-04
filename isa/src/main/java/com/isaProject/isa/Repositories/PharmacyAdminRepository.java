package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Users.PharmacyAdmin;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PharmacyAdminRepository extends JpaRepository<PharmacyAdmin, Integer> {

    PharmacyAdmin findOneById(Integer idUser);

   // PharmacyAdmin findOneByIdUser(Integer idUser);

}
