package com.isaProject.isa.Model.Users;


import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
@Table(name="AUTHORITY")
public class Authority implements GrantedAuthority {
    @Id
    @Column(name="id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    Integer id;

    @Column(name="name")
    String name;

    @Override
    public String getAuthority() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @JsonIgnore
    public String getName() {
        return name;
    }

    @JsonIgnore
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
