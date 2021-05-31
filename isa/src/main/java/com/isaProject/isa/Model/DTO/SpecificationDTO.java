package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.Drug;
import com.isaProject.isa.Model.Drugs.Ingredient;

import javax.persistence.*;
import java.util.HashSet;
import java.util.Set;

public class SpecificationDTO {

    private String contraindications;

    private String structure;

    //preporučeni unos terapije na dnevnom nivou

    private Integer recommendedDose;



    private Set<IngredientDTO> ingredients=new HashSet<IngredientDTO>();


    public String getContraindications() {
        return contraindications;
    }

    public String getStructure() {
        return structure;
    }

    public Integer getRecommendedDose() {
        return recommendedDose;
    }

    public Set<IngredientDTO> getIngredients() {
        return ingredients;
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

    public void setIngredients(Set<IngredientDTO> ingredients) {
        this.ingredients = ingredients;
    }

    public SpecificationDTO(String contraindications, String structure, Integer recommendedDose, Set<IngredientDTO> ingredients) {
        this.contraindications = contraindications;
        this.structure = structure;
        this.recommendedDose = recommendedDose;
        this.ingredients = ingredients;
    }

    public SpecificationDTO() {
    }
}
