package com.isaProject.isa.Model.DTO;

import javax.persistence.Column;

public class LoyalityProgramDTO {
    private int pointsToRegular;
    private int pointsToSilver;
    private int pointsToGold;
    private int percentBronse;
    private int percentSilver;
    private int percentGold;

    public  LoyalityProgramDTO(){}
    public LoyalityProgramDTO(int pointsToRegular, int pointsToSilver, int pointsToGold, int percentBronse, int percentSilver, int percentGold) {
        this.pointsToRegular = pointsToRegular;
        this.pointsToSilver = pointsToSilver;
        this.pointsToGold = pointsToGold;
        this.percentBronse = percentBronse;
        this.percentSilver = percentSilver;
        this.percentGold = percentGold;
   }

    public int getPointsToRegular() {
        return pointsToRegular;
    }

    public void setPointsToRegular(int pointsToRegular) {
        this.pointsToRegular = pointsToRegular;
    }

    public int getPointsToSilver() {
        return pointsToSilver;
    }

    public void setPointsToSilver(int pointsToSilver) {
        this.pointsToSilver = pointsToSilver;
    }

    public int getPointsToGold() {
        return pointsToGold;
    }

    public void setPointsToGold(int pointsToGold) {
        this.pointsToGold = pointsToGold;
    }

    public int getPercentBronse() {
        return percentBronse;
    }

    public void setPercentBronse(int percentBronse) {
        this.percentBronse = percentBronse;
    }

    public int getPercentSilver() {
        return percentSilver;
    }

    public void setPercentSilver(int percentSilver) {
        this.percentSilver = percentSilver;
    }

    public int getPercentGold() {
        return percentGold;
    }

    public void setPercentGold(int percentGold) {
        this.percentGold = percentGold;
    }
}
