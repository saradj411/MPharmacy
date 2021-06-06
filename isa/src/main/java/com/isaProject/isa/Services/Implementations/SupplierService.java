package com.isaProject.isa.Services.Implementations;

import com.isaProject.isa.Model.DTO.SupplierDTO;
import com.isaProject.isa.Model.Users.Authority;
import com.isaProject.isa.Model.Users.Supplier;
import com.isaProject.isa.Model.Users.User;
import com.isaProject.isa.Repositories.SupplierRepository;
import com.isaProject.isa.Repositories.UserRepository;
import com.isaProject.isa.Services.IServices.ISupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService implements ISupplierService {
    @Autowired
    SupplierRepository supplierRepository;
    @Autowired
    AuthorityService authService;
    @Autowired
    PasswordEncoder passwordEncoder;
    @Autowired
    UserRepository userRepository;

    @Override
    public Supplier save(SupplierDTO supplierDTO) {
        List<Authority> auth = authService.findByname("ROLE_SUPPLIER");

        for(User u : userRepository.findAll()) {
            if(u.getEmail().equals(supplierDTO.getEmail()))
            {
                return null;
            }
        }
        Supplier supplier = new Supplier();
        supplier.setName(supplierDTO.getName());
        supplier.setSurname(supplierDTO.getSurname());
        supplier.setEmail(supplierDTO.getEmail());
        supplier.setPassword(passwordEncoder.encode("123"));
        supplier.setPhoneNumber(supplierDTO.getPhoneNumber());
        supplier.setAddress(supplierDTO.getAddress());
        supplier.setCity(supplierDTO.getCity());
        supplier.setCountry(supplierDTO.getCountry());
        supplier.setAuthorities(auth);
        supplier.setAccountEnabled(false);
        userRepository.save(supplier);
        //supplierRepository.save(supplier);

        return supplier;
    }
}
