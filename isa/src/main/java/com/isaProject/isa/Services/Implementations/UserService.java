package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Config.Utils.TokenUtils;
import com.isaProject.isa.Model.DTO.UserDTO;
import com.isaProject.isa.Model.Users.Authority;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Model.Users.UserTokenState;
import com.isaProject.isa.Repositories.UserRepository;
import com.isaProject.isa.Services.IServices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private TokenUtils tokenUtils;
    @Autowired
    UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private AuthorityService authService;

    @Autowired
    private AuthenticationManager authenticationManager;

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
    public User save(UserDTO user) {
        List<Authority> auth = authService.findByname("PATIENT");
        for(User u : userRepository.findAll())
        {
            if(u.getEmail().equals(user.getEmail()))
                return null;
        }

        User u = new User();
        u.setName(user.getName());
        u.setSurname(user.getSurname());
        u.setEmail(user.getEmail());
        u.setPassword(passwordEncoder.encode(user.getPassword()));
        u.setAddress(user.getAddress());
        u.setPhoneNumber(user.getPhoneNumber());
        u.setCity(user.getCity());
        u.setCountry(user.getCountry());
        u.setAccountEnabled(false);
        u.setAuthorities(auth);
        //dodati na mejl
        return userRepository.save(u);
    }

    @Override
    public void update(User drug) {
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public UserTokenState Login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Create a token for that user
        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user);
        int expiresIn = tokenUtils.getExpiredIn();

        return new UserTokenState(jwt, expiresIn);
        }


}
