package com.isaProject.isa.Model.DTO;

public class ExaminationQuarterDTO {
    private int firstPart;
    private int secondPart;
    private int thirdPart;


    public int getFirstPart() {
        return firstPart;
    }

    public void setFirstPart(int firstPart) {
        this.firstPart = firstPart;
    }

    public int getSecondPart() {
        return secondPart;
    }

    public void setSecondPart(int secondPart) {
        this.secondPart = secondPart;
    }

    public int getThirdPart() {
        return thirdPart;
    }

    public void setThirdPart(int thirdPart) {
        this.thirdPart = thirdPart;
    }

    public ExaminationQuarterDTO(int firstPart, int secondPart, int thirdPart) {
        this.firstPart = firstPart;
        this.secondPart = secondPart;
        this.thirdPart = thirdPart;
    }

    public ExaminationQuarterDTO() {
    }
}
