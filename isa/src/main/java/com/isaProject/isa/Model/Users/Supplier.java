package com.isaProject.isa.Model.Users;

import com.isaProject.isa.Model.Drugs.Offer;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;
import java.util.HashSet;
import java.util.Set;

@Entity
public class Supplier extends  User{

    //ponuda za narudzbu

    @OneToMany(mappedBy = "supplier", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Offer> offers=new HashSet<Offer>();
}
