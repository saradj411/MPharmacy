package com.isaProject.isa.Services.IServices;
import com.isaProject.isa.Model.DTO.UserDTO;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Model.Users.UserTokenState;

import javax.mail.MessagingException;
import java.util.List;

public interface IUserService {
    User findById(Integer id);
    User findByName(String name);
    List<User> findAll ();
    User save(UserDTO user) throws MessagingException;
    void update(User drug);
    User findByEmail(String email);
    User saveAdmin(UserDTO userDTO) throws MessagingException;

    UserTokenState Login(String email, String password);
    User getLoggedUser();
}
