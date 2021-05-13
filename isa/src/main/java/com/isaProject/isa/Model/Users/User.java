package com.isaProject.isa.Model.Users;


import javax.persistence.*;

@Entity
@Table
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idUser;

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

}
