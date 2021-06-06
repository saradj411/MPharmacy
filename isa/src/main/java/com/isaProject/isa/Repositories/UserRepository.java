package com.isaProject.isa.Repositories;

import com.isaProject.isa.Model.Users.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

public interface UserRepository extends JpaRepository<User, Integer> {
    User findOneById(Integer idUser);
    User findByEmail(String email);


    /*@Modifying
    @Query("delete s from User s where id = ?1")
    void delete(Integer id);*/

}
