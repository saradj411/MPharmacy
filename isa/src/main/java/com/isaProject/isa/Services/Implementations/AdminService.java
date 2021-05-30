package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.DermatologistDTO;
import com.isaProject.isa.Model.Users.Authority;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;

import java.util.List;

public class AdminService {
    @Autowired
    private UserService userService;
    @Autowired
    private DermatologistService dermatologistService;


    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authService;

    @Autowired
    UserRepository userRepository;

    private User registerDermatologist(DermatologistDTO dermDTO)
    {
        List<Authority> auth = authService.findByname("DERMATOLOGIST");
        for(User u : userRepository.findAll())
        {
            if(u.getEmail().equals(dermDTO.getEmail()))
                return null;
        }

        return dermatologistService.save(dermDTO);

    }
}
