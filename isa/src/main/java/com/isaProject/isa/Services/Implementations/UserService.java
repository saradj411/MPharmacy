package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Config.Utils.TokenUtils;
import com.isaProject.isa.Model.DTO.UserDTO;
import com.isaProject.isa.Model.Users.Authority;
import com.isaProject.isa.Model.Users.Patient;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Model.Users.UserTokenState;
import com.isaProject.isa.Repositories.PatientRepository;
import com.isaProject.isa.Repositories.UserRepository;
import com.isaProject.isa.Services.IServices.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import java.nio.charset.Charset;
import java.util.List;
import java.util.Random;

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

    @Autowired
    private ServiceForEmail serviceForEmail;
    @Autowired
    private PatientRepository patientRepository;

    @Override
    public User findById(Integer id) {

        User user = userRepository.findOneById(id);
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
        List<Authority> auth = authService.findByname("ROLE_PATIENT");

        for(User u : userRepository.findAll()) {
            if(u.getEmail().equals(user.getEmail()))
                return null;
        }

        //User u = new User();
        Patient patient = new Patient();
        patient.setName(user.getName());
        patient.setSurname(user.getSurname());
        patient.setEmail(user.getEmail());
        patient.setPassword(passwordEncoder.encode(user.getPassword()));
        patient.setAddress(user.getAddress());
        patient.setPhoneNumber(user.getPhoneNumber());
        patient.setCity(user.getCity());
        patient.setCountry(user.getCountry());
        patient.setAccountEnabled(false);
        patient.setAuthorities(auth);
        patient.setPenalty(0);
        patient.setLoyaltyCategory("NONE");
        patient.setPoints(0);

        //User newUser = userRepository.save(patient);



        patientRepository.save(patient);
        return patient;

    }

    @Override
    public void update(User user) {
        User u = findById(user.getId());
        u.setName(user.getName());
        u.setSurname(user.getSurname());
        u.setEmail(user.getEmail());
        u.setAddress(user.getAddress());
        u.setCity(user.getCity());
        u.setCountry(user.getCountry());
        u.setPhoneNumber(user.getPhoneNumber());
        userRepository.save(u);
    }

    @Override
    public User findByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public User saveAdmin(UserDTO userDTO) throws MessagingException {
        List<Authority> auth = authService.findByname("ROLE_ADMIN");
        for(User u : userRepository.findAll())
        {
            if(u.getEmail().equals(userDTO.getEmail()))
                return null;
        }

        User u = new User();
        u.setName(userDTO.getName());
        u.setSurname(userDTO.getSurname());
        u.setEmail(userDTO.getEmail());
        u.setPassword(passwordEncoder.encode("123"));
        u.setAddress(userDTO.getAddress());
        u.setPhoneNumber(userDTO.getPhoneNumber());
        u.setCity(userDTO.getCity());
        u.setCountry(userDTO.getCountry());
        u.setAccountEnabled(false);
        u.setAuthorities(auth);


        return userRepository.save(u);
    }

    @Override
    public UserTokenState Login(String username, String password) {
        Authentication authentication = authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(username, password));

        SecurityContextHolder.getContext().setAuthentication(authentication);

        // Create a token for that user
        User user = (User) authentication.getPrincipal();
        String jwt = tokenUtils.generateToken(user.getEmail());
        int expiresIn = tokenUtils.getExpiredIn();

        return new UserTokenState(jwt, expiresIn);
        }

    @Override
    public User getLoggedUser() {
        Authentication loggedUser = SecurityContextHolder.getContext().getAuthentication();
        String email = loggedUser.getName();
        User u = userRepository.findByEmail(email);
        return  u;
    }

    @Override
    public User changePassword(String newPassword, String username) {
        User u = findByEmail(username);
        u.setPassword(passwordEncoder.encode(newPassword));
        u.setAccountEnabled(true);
        update(u);
        return u;
    }


    private String PasswordGenerator()
    {
        byte[] array = new byte[7]; // length is bounded by 7
        new Random().nextBytes(array);
        String generatedString = new String(array, Charset.forName("UTF-8"));
        System.out.println(generatedString);
        return  generatedString;

    }


}
