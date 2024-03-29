package com.isaProject.isa.Model.Users;




import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Table
public class LoyalityProgram {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idProgram;

//poeni za svaku od kategorije
    @Column
    private int pointsToRegular;

    @Column
    private int pointsToSilver;

    @Column
    private int pointsToGold;

    @Column
    private int percentBronse;
    @Column
    private int percentSilver;
    @Column
    private int percentGold;
    @Column
    private LocalDate createdDate;
    @Column
    private Boolean isActive;

    public  LoyalityProgram(){}
    public LoyalityProgram(Integer idProgram, int pointsToRegular, int pointsToSilver, int pointsToGold, int percentBronse, int percentSilver, int percentGold, LocalDate createdDate, Boolean isActive) {
        this.idProgram = idProgram;
        this.pointsToRegular = pointsToRegular;
        this.pointsToSilver = pointsToSilver;
        this.pointsToGold = pointsToGold;
        this.percentBronse = percentBronse;
        this.percentSilver = percentSilver;
        this.percentGold = percentGold;
        this.createdDate = createdDate;
        this.isActive = isActive;
    }

    public LocalDate getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(LocalDate createdDate) {
        this.createdDate = createdDate;
    }

    public Boolean getActive() {
        return isActive;
    }

    public void setActive(Boolean active) {
        isActive = active;
    }

    public Integer getIdProgram() {
        return idProgram;
    }

    public void setIdProgram(Integer idProgram) {
        this.idProgram = idProgram;
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
