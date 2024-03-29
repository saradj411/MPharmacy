package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.DrugFormat;
import com.isaProject.isa.Model.Drugs.Ingredient;

import java.util.HashSet;
import java.util.Set;

public class DrugAndSpecDTO {

    //For durg
    private String name;
    private String code;
    private boolean recipeNeed;
    private String drugType;
    private DrugFormat format;
    private String manufacturer;
    private Integer points;
    private Set<Integer> alternatives;

    //For specification
    private String contraindications;
    private String structure;
    private Integer recommendedDose;
    private String ingredients;

    private String napomene;
    private double grade;

    public DrugAndSpecDTO(String name, String code, boolean recipeNeed, String drugType, DrugFormat format, String manufacturer, Integer points) {
        this.name = name;
        this.code = code;
        this.recipeNeed = recipeNeed;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
        this.points = points;
    }

    public DrugAndSpecDTO(String name, String code, boolean recipeNeed, String drugType, DrugFormat format, String manufacturer, Integer points, Set<Integer> alternatives, String contraindications, String structure, Integer recommendedDose, String ingredients, String napomene, double grade) {
        this.name = name;
        this.code = code;
        this.recipeNeed = recipeNeed;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
        this.points = points;
        this.alternatives = alternatives;
        this.contraindications = contraindications;
        this.structure = structure;
        this.recommendedDose = recommendedDose;
        this.ingredients = ingredients;
        this.napomene = napomene;
        this.grade = grade;
    }

    public String getNapomene() {
        return napomene;
    }

    public void setNapomene(String napomene) {
        this.napomene = napomene;
    }

    public double getGrade() {
        return grade;
    }

    public void setGrade(double grade) {
        this.grade = grade;
    }

    public DrugAndSpecDTO() {}

    public Integer getPoints() {
        return points;
    }

    public void setPoints(Integer points) {
        this.points = points;
    }

    public Set<Integer> getAlternatives() {
        return alternatives;
    }

    public void setAlternatives(Set<Integer> alternatives) {
        this.alternatives = alternatives;
    }

    public DrugAndSpecDTO(String name, String code, boolean recipeNeed, String drugType, DrugFormat format, String manufacturer, String contraindications, String structure, Integer recommendedDose, String ingredients) {
        this.name = name;
        this.code = code;
        this.recipeNeed = recipeNeed;
        this.drugType = drugType;
        this.format = format;
        this.manufacturer = manufacturer;
        this.contraindications = contraindications;
        this.structure = structure;
        this.recommendedDose = recommendedDose;
        this.ingredients = ingredients;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public boolean isRecipeNeed() {
        return recipeNeed;
    }

    public void setRecipeNeed(boolean recipeNeed) {
        this.recipeNeed = recipeNeed;
    }

    public String getDrugType() {
        return drugType;
    }

    public void setDrugType(String drugType) {
        this.drugType = drugType;
    }

    public DrugFormat getFormat() {
        return format;
    }

    public void setFormat(DrugFormat format) {
        this.format = format;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
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

    @Override
    public String toString() {
        return "DrugAndSpecDTO{" +
                "name='" + name + '\'' +
                ", code='" + code + '\'' +
                ", recipeNeed=" + recipeNeed +
                ", drugType='" + drugType + '\'' +
                ", format=" + format +
                ", manufacturer='" + manufacturer + '\'' +
                ", points=" + points +
                ", alternatives=" + alternatives +
                ", contraindications='" + contraindications + '\'' +
                ", structure='" + structure + '\'' +
                ", recommendedDose=" + recommendedDose +
                ", ingredients='" + ingredients + '\'' +
                '}';
    }
}
