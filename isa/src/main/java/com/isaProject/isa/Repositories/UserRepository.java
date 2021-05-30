package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findOneByIdUser(Integer idUser);
    User findByEmail(String email);
}
