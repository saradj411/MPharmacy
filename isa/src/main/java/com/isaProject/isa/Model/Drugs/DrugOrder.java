package com.isaProject.isa.Model.Drugs;

import com.isaProject.isa.Model.Users.PharmacyAdmin;

import javax.persistence.*;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class DrugOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idOrder;

    @Column
    private Integer quantity;

    //do kad se primaju ponude
    @Column
    private Date timeLimit;


    //statusu narudžbenice (čeka ponude, obrađena)
    @Column
    private Boolean processed;

    @OneToMany(mappedBy = "drugOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<OrderItem> orderItems = new HashSet<OrderItem>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "admin", referencedColumnName = "idUser")
    private PharmacyAdmin pharmacyAdmin;

    @OneToMany(mappedBy = "drugOrder", fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Set<Offer> offers = new HashSet<Offer>();
}


