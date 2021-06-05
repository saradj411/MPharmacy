package com.isaProject.isa.Model.DTO;

public class IncomeDTO {

    private double jan;
    private double feb;
    private double mart;

    public double getJan() {
        return jan;
    }

    public void setJan(double jan) {
        this.jan = jan;
    }

    public double getFeb() {
        return feb;
    }

    public void setFeb(double feb) {
        this.feb = feb;
    }

    public double getMart() {
        return mart;
    }

    public void setMart(double mart) {
        this.mart = mart;
    }

    public IncomeDTO(double jan, double feb, double mart) {
        this.jan = jan;
        this.feb = feb;
        this.mart = mart;
    }

    public IncomeDTO() {
    }
}
