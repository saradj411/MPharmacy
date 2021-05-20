package com.isaProject.isa.Services.IServices;
import com.isaProject.isa.Model.DTO.UserDTO;
import com.isaProject.isa.Model.Users.User;
import java.util.List;

public interface IUserService {
    User findById(Integer id);
    User findByName(String name);
    List<User> findAll ();
    User save(UserDTO drug);
    void update(User drug);
}
