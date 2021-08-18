package com.isaProject.isa.Model.DTO;

import com.isaProject.isa.Model.Drugs.ERecipe;
import com.isaProject.isa.Model.Users.User;

public class ERecipeWithUserDTO {

    private ERecipe eRecipe;
    private User user;

    public ERecipeWithUserDTO(){}

    public ERecipeWithUserDTO(ERecipe eRecipe,User user) {
        this.eRecipe = eRecipe;
        this.user = user;
    }

    public ERecipe geteRecipe() {
        return eRecipe;
    }

    public void seteRecipe(ERecipe eRecipe) {
        this.eRecipe = eRecipe;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
