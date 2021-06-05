package com.isaProject.isa.Model.Drugs;

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

    //@Column
    //private Integer idDrug;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drugCode", referencedColumnName = "code")
    private Drug drug;

    //@OneToMany(mappedBy = "specification", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
    //@JsonBackReference
    @Column
    private String ingredients;
    public Specification(){}

    public Specification(Integer idSpec, String contraindications, String structure, Integer recommendedDose, Drug drug, String ingredients) {
        this.idSpec = idSpec;
        this.contraindications = contraindications;
        this.structure = structure;
        this.recommendedDose = recommendedDose;
        this.drug = drug;
        this.ingredients = ingredients;
    }

    public Integer getIdSpec() {
        return idSpec;
    }

    public void setIdSpec(Integer idSpec) {
        this.idSpec = idSpec;
    }

    public String getContraindications() {
        return contraindications;
    }

    public void setContraindications(String contraindications) {
        this.contraindications = contraindications;
    }

    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    public Integer getRecommendedDose() {
        return recommendedDose;
    }

    public void setRecommendedDose(Integer recommendedDose) {
        this.recommendedDose = recommendedDose;
    }
    public String getIngredients() {
        return ingredients;
    }    

    public void setIngredients(String ingredients) {
        this.ingredients = ingredients;
    }

    
    public Drug getDrug() {
        return drug;
    }   

    public void setDrug(Drug drug) {
        this.drug = drug;
    }
    
}


