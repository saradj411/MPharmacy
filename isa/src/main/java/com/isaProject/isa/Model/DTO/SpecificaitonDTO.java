package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.Ingredient;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class SpecificaitonDTO {

    private String contraindications;
    private String structure;
    private Integer recommendedDose;
    private Drug drug;
    private String ingredients;

    public Drug getDrug() {
        return drug;
    }

    public void setDrug(Drug drug) {
        this.drug = drug;
    }



    public  SpecificaitonDTO() {}

    public SpecificaitonDTO(String contraindications, String structure, Integer recommendedDose, Drug drug, String ingredients) {
        this.contraindications = contraindications;
        this.structure = structure;
        this.recommendedDose = recommendedDose;
        this.drug = drug;
        this.ingredients = ingredients;
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
}
