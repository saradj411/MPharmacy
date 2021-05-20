package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.UserDTO;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Repositories.UserRepository;
import com.isaProject.isa.Services.IServices.IUserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserService implements IUserService {

    @Autowired
    UserRepository userRepository;

    @Override
    public User findById(Integer id) {

        User user = userRepository.findOneByIdUser(id);
        return user;
    }

    @Override
    public User findByName(String name) {
        return null;
    }

    @Override
    public List<User> findAll() {
        return userRepository.findAll();

    }

    @Override
    public User save(UserDTO drug) {
        return null;
    }

    @Override
    public void update(User drug) {

    }
}
