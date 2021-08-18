package com.isaProject.isa.Model.Users;


import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "USERS")
@Inheritance(strategy = InheritanceType.JOINED)
//@JsonIdentityInfo(generator=ObjectIdGenerators.PropertyGenerator.class, property="id")

public class User  implements UserDetails {

    private static final long serialVersionUID = 1L;

    @Id
    @Column(name = "id")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column
    private String name;

    @Column
    private String surname;

    @Column
    private String email;

    @Column
    private String password;

    @Column
    private String address;

    @Column
    private String phoneNumber;

    @Column
    private String city;

    @Column
    private String country;

    @Column
    private Boolean accountEnabled;

    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name="user_authority",
            joinColumns = @JoinColumn(name ="user_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name="authority_id", referencedColumnName = "id"))
    private List<Authority> authorities;


    public User() {
    }

    public User(Integer id, String name, String surname, String email, String password, String address, String phoneNumber, String city, String country) {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.email = email;
        this.password = password;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.city = city;
        this.country = country;
        this.accountEnabled = true;
    }

    public User(Integer id)
    {
        this.id = id;
    }


    public void setAuthorities(List<Authority> authorities) {
        this.authorities = authorities;
    }


    public Integer getId() {
        return id;
    }

    public void setId(Integer idUser) {
        this.id = idUser;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return this.authorities;
    }


    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

    @Override
    public boolean isAccountNonExpired() {

        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }
    @Override
    public boolean isEnabled() {
        return accountEnabled;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setAccountEnabled(Boolean accountEnabled) {
        this.accountEnabled = accountEnabled;
    }

    public Date getLastPasswordResetDate() {
        return  null;
    }

    public String getAuthorityRole()
    {
        if(authorities.isEmpty()) return null;
        Authority authority = authorities.get(0);
        return authority.getAuthority();
    }

    public Boolean getAccountEnabled() {
        return accountEnabled;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                '}';
    }
}
