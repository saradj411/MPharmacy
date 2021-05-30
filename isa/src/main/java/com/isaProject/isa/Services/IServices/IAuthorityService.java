package com.isaProject.isa.Services.IServices;

import com.isaProject.isa.Model.Users.Authority;

import java.util.List;

public interface IAuthorityService {
    List<Authority> findById(Integer id);
    List<Authority> findByname(String name);
}
