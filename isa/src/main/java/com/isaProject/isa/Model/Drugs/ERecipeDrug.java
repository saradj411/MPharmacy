package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.isaProject.isa.Model.Pharmacy.Pharmacy;
import com.isaProject.isa.Model.Users.User;

import javax.persistence.*;

@Entity
@Table
public class ERecipeDrug {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    @Column(name = "code", nullable = false)
    private String code;

    @Column(name = "name", nullable = false)
    private String name;

    @Column(name = "quantity", nullable = false)
    private int quantity;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "erecipeId", referencedColumnName = "idRecipe")
    //ovo jsonback ostavi!!
    @JsonBackReference
    private ERecipe eRecipe;




    public ERecipeDrug() {
    }

    public ERecipeDrug(Integer id, String code, String name, int quantity, ERecipe eRecipe) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.quantity = quantity;
        this.eRecipe = eRecipe;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public ERecipe geteRecipe() {
        return eRecipe;
    }

    public void seteRecipe(ERecipe eRecipe) {
        this.eRecipe = eRecipe;
    }
}
/*
● Listu koja će sadržati za svaki prepisani lek:
○ Šifru leka
○ Naziv leka
○ Količinu
 */