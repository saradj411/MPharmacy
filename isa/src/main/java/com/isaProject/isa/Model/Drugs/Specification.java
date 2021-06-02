package com.isaProject.isa.Model.Drugs;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table
public class Specification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idSpec;

    //kontraindikacija
    @Column
    private String contraindications;

    //sastav lijeka
    @Column
    private String structure;

    //preporučeni unos terapije na dnevnom nivou
    @Column
    private Integer recommendedDose;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drugCode", referencedColumnName = "code")
    private Drug drug;

    @OneToMany(mappedBy = "specification", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JsonBackReference
    private Set<Ingredient> ingredients=new HashSet<Ingredient>();

    public Integer getIdSpec() {
        return idSpec;
    }

    public String getContraindications() {
        return contraindications;
    }

    public String getStructure() {
        return structure;
    }

    public Integer getRecommendedDose() {
        return recommendedDose;
    }

    public Drug getDrug() {
        return drug;
    }

    public Set<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIdSpec(Integer idSpec) {
        this.idSpec = idSpec;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public void setRecommendedDose(Integer recommendedDose) {
        this.recommendedDose = recommendedDose;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }

    public void setIngredients(Set<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }

    public Specification(Integer idSpec, String contraindications, String structure, Integer recommendedDose, Drug drug, Set<Ingredient> ingredients) {
        this.idSpec = idSpec;
        this.contraindications = contraindications;
        this.structure = structure;
        this.recommendedDose = recommendedDose;
        this.drug = drug;
        this.ingredients = ingredients;
    }

    public Specification() {
    }
}
